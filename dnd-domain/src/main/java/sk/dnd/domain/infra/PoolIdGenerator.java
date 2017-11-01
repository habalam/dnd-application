package sk.dnd.domain.infra;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.relational.Database;
import org.hibernate.boot.model.relational.QualifiedName;
import org.hibernate.boot.model.relational.QualifiedNameParser;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.engine.jdbc.spi.SqlStatementLogger;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGeneratorHelper;
import org.hibernate.id.IntegralDataTypeHolder;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.jdbc.AbstractReturningWork;
import org.hibernate.jdbc.WorkExecutorVisitable;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.id.PersistentIdentifierGenerator;

public class PoolIdGenerator implements PersistentIdentifierGenerator, Configurable {

	private static final Logger logger = LoggerFactory.getLogger(PoolIdGenerator.class);

	private static final Map<String, PoolIdGenerator> poolIdGeneratorMap = Collections.synchronizedMap(new HashMap<String, PoolIdGenerator>());

	// properties pre konfiguraciu v xml
	public static final String ID_TABLE = "table";
	public static final String PK_COLUMN_NAME = "primary_key_column";
	public static final String PK_VALUE_NAME = "primary_key_value";
	public static final String VALUE_COLUMN_NAME = "value_column";
	public static final String PK_LENGTH_NAME = "primary_key_length";
	public static final String POOL_SIZE = "pool_size";

	private static final int DEFAULT_PK_LENGTH = 255;
	private static final long START_FROM = 0L;

	// default hodnoty
	private static final String DEFAULT_TABLE = "sys_sequence";
	private static final String DEFAULT_PK_COLUMN = "seq_name";
	private static final String DEFAULT_VALUE_COLUMN = "seq_count";

	private QualifiedName qualifiedTableName;

	private String renderedTableName;

	private String pkColumnName;

	private String valueColumnName;

	private String query;

	private String insert;

	private String update;

	private Class<?> returnClass;

	private int keySize;

	/**
	 * Pocet rezervovanych ideciek (velkost poolu).
	 */
	private int poolSize;

	/**
	 * Dalsie idecko po vycerpani pool-u (o jedna vacsie ako posledne rezervovane idecko).
	 */
	private IntegralDataTypeHolder idPoolSuprema;

	/**
	 * Dalsie idecko, ktore bude vygenerovane.
	 */
	private IntegralDataTypeHolder value;

	private String keyValue;

	public PoolIdGenerator() {
		logger.trace("Created new instance: {}", this);
	}

	public String[] sqlCreateStrings(Dialect dialect) {
		String createScript = dialect.getCreateTableString() + ' ' + (dialect.supportsIfExistsBeforeTableName() ? " if not exists " : "") +
			renderedTableName + " (" + pkColumnName + ' ' + dialect.getTypeName(Types.VARCHAR, keySize, 0, 0) + " NOT NULL " + ", " +
			valueColumnName + ' ' + dialect.getTypeName(Types.INTEGER) + ')' +
			(dialect.supportsIfExistsAfterTableName() ? " if not exists " : "");

		String pkScript = "ALTER TABLE " + renderedTableName + " ADD PRIMARY KEY (" + pkColumnName + ')';

		logger.trace("Sequence crateScipt: {} sql: {} ", keyValue, createScript);

		return new String[] {createScript, pkScript};
	}

	@Override
	public String[] sqlDropStrings(Dialect dialect) {
		String sqlDropString = "drop table " + (dialect.supportsIfExistsBeforeTableName() ? " if exists " : "") +
			renderedTableName + dialect.getCascadeConstraintsString() + (dialect.supportsIfExistsAfterTableName() ? " if exists" : "");
		return new String[] {sqlDropString};
	}

	private IntegralDataTypeHolder doWorkInCurrentTransaction(final SessionImplementor session, Connection conn) throws SQLException {
		IntegralDataTypeHolder dataTypeHolder = IdentifierGeneratorHelper.getIntegralDataTypeHolder(returnClass);
		SqlStatementLogger sqlStatementLogger = session
			.getFactory()
			.getServiceRegistry()
			.getService(JdbcServices.class)
			.getSqlStatementLogger();

		int rows;
		do {
			executeQueryPart(conn, dataTypeHolder, sqlStatementLogger);
			rows = executeUpdatePart(conn, dataTypeHolder, sqlStatementLogger);
		}
		while (rows == 0);

		return dataTypeHolder;
	}

	private void executeQueryPart(Connection conn, IntegralDataTypeHolder dataTypeHolder, SqlStatementLogger sqlStatementLogger) throws SQLException {
		sqlStatementLogger.logStatement(query);
		try (PreparedStatement qps = conn.prepareStatement(query)) {
			executeQueryResultSetProcessing(conn, dataTypeHolder, sqlStatementLogger, qps);
		}
		catch (SQLException sqle) {
			logger.error("could not read or init seq_count for: {}", keyValue, sqle);
			throw sqle;
		}
	}

	private void executeQueryResultSetProcessing(Connection conn, IntegralDataTypeHolder dataTypeHolder, SqlStatementLogger sqlStatementLogger, PreparedStatement qps) throws SQLException {
		try (ResultSet rs = qps.executeQuery()) {
			boolean isInitialized = rs.next();
			if (!isInitialized) {
				executeQueryNotInitializedPart(conn, dataTypeHolder, sqlStatementLogger);
			}
			else {
				dataTypeHolder.initialize(rs, START_FROM);
				logger.trace("Sequence pool for {} (re-)initialized to {}", keyValue, dataTypeHolder);
			}
		}
	}

	private void executeQueryNotInitializedPart(Connection conn, IntegralDataTypeHolder dataTypeHolder, SqlStatementLogger sqlStatementLogger) throws SQLException {
		dataTypeHolder.initialize(START_FROM);
		sqlStatementLogger.logStatement(insert);
		try (PreparedStatement ips = conn.prepareStatement(insert)) {
			dataTypeHolder.bind(ips, 1);
			ips.execute();
		}
	}

	private int executeUpdatePart(Connection conn, IntegralDataTypeHolder dataTypeHolder, SqlStatementLogger sqlStatementLogger) throws SQLException {
		int rows;
		sqlStatementLogger.logStatement(update);
		try (PreparedStatement ups = conn.prepareStatement(update)) {
			dataTypeHolder.copy().add(poolSize).bind(ups, 1);
			dataTypeHolder.bind(ups, 2);
			rows = ups.executeUpdate();
		}
		catch (SQLException sqle) {
			logger.error("could not update seq_count for: {}", pkColumnName, sqle);
			throw sqle;
		}
		return rows;
	}

	@Override
	public synchronized Serializable generate(final SessionImplementor session, Object obj) {
		Serializable id;

		if (poolSize < 1) {
			// keep the behavior consistent even for boundary usages
			IntegralDataTypeHolder dataTypeHolder = null;
			while (dataTypeHolder == null || dataTypeHolder.lt(1)) {
				dataTypeHolder = doWorkInNewTransaction(session);
			}
			return dataTypeHolder.makeValue();
		}

		id = generateId(session);

		logger.trace("Generated id {} for {} ", id, keyValue);
		logger.trace("Generated id {} for {} ", id, keyValue);
		return id;
	}

	private Serializable generateId(SessionImplementor session) {
		if (noPoolOrDepletedPool()) {
			value = doWorkInNewTransaction(session).increment();
			idPoolSuprema = value.copy().add(poolSize);

		}

		return value.makeValueThenIncrement();
	}

	private boolean noPoolOrDepletedPool() {
		return idPoolSuprema == null || !(idPoolSuprema.gt(value));
	}

	/**
	 * Vrati posledne rezervovane idecko podla databazy.
	 */
	private IntegralDataTypeHolder doWorkInNewTransaction(final SessionImplementor session) {

		final WorkExecutorVisitable<IntegralDataTypeHolder> work = new AbstractReturningWork<IntegralDataTypeHolder>() {

			@Override
			public IntegralDataTypeHolder execute(Connection connection) throws SQLException {
				String sql = null;
				try {
					return doWorkInCurrentTransaction(session, connection);
				}
				catch (SQLException sqle) {
					throw new IllegalStateException("Could not get or update next value (" + sql + ')', sqle);
				}
			}
		};
		return session.getTransactionCoordinator().createIsolationDelegate().delegateWork(work, true);
	}

	@Override
	public Object generatorKey() {
		return keyValue;
	}

	private synchronized void dropIdPoolSuprema() {
		idPoolSuprema = null;
	}

	public static void refreshFromDatabase(String pkColumnName) {
		PoolIdGenerator poolIdGenerator = poolIdGeneratorMap.get(pkColumnName);
		poolIdGenerator.dropIdPoolSuprema();
		logger.debug("PoolIdGenerator for {} will be refreshed from the database", pkColumnName);
	}

	@Override
	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) {
		JdbcEnvironment jdbcEnvironment = serviceRegistry.getService(JdbcEnvironment.class);
		qualifiedTableName = determineGeneratorTableName(params, jdbcEnvironment);

		pkColumnName = determineValueColumnName(params, jdbcEnvironment, PK_COLUMN_NAME, DEFAULT_PK_COLUMN);
		valueColumnName = determineValueColumnName(params, jdbcEnvironment, VALUE_COLUMN_NAME, DEFAULT_VALUE_COLUMN);
		keySize = ConfigurationHelper.getInt(PK_LENGTH_NAME, params, DEFAULT_PK_LENGTH);
		keyValue = ConfigurationHelper.getString(PK_VALUE_NAME, params, params.getProperty(TABLE));

		poolIdGeneratorMap.put(keyValue, this);

		poolSize = ConfigurationHelper.getInt(POOL_SIZE, params, Short.MAX_VALUE);
		returnClass = type.getReturnedClass();

		logger.debug("Configured {}, assigned name {} ", this, keyValue);
	}

	protected QualifiedName determineGeneratorTableName(Properties params, JdbcEnvironment jdbcEnvironment) {
		final String tableName = ConfigurationHelper.getString(ID_TABLE, params, DEFAULT_TABLE);

		// if already qualified there is not much we can do in a portable manner so we pass it
		// through and assume the user has set up the name correctly.
		if (tableName.contains(".")) {
			return QualifiedNameParser.INSTANCE.parse(tableName);
		}
		else {
			final Identifier catalog = jdbcEnvironment.getIdentifierHelper().toIdentifier(
				ConfigurationHelper.getString(CATALOG, params)
			);
			final Identifier schema = jdbcEnvironment.getIdentifierHelper().toIdentifier(
				ConfigurationHelper.getString(SCHEMA, params)
			);
			return new QualifiedNameParser.NameParts(
				catalog,
				schema,
				jdbcEnvironment.getIdentifierHelper().toIdentifier(tableName)
			);
		}
	}

	protected String determineValueColumnName(Properties params, JdbcEnvironment jdbcEnvironment, String columnName, String defaultColumn) {
		final String name = ConfigurationHelper.getString(columnName, params, defaultColumn);
		return jdbcEnvironment.getIdentifierHelper().toIdentifier(name).render(jdbcEnvironment.getDialect());
	}

	@Override
	public void registerExportables(Database database) {
		this.renderedTableName = qualifiedTableName.render();

		this.query = "select " + valueColumnName + " from " + renderedTableName + " where " + pkColumnName + " = '" + keyValue + '\'';
		this.update = "update " + renderedTableName + " set " + valueColumnName + " = ? where " + valueColumnName + " = ? and " + pkColumnName + " = '" + keyValue + '\'';
		this.insert = "insert into " + renderedTableName + '(' + pkColumnName + ", " + valueColumnName + ") " + "values('" + keyValue + "', ?)";
	}
}
