package sk.dnd.domain.character;

import java.util.List;
import java.util.Map;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import sk.dnd.domain.character.support.ClassificationType;
import sk.dnd.domain.infra.BaseObject;

/**
 * Classification.
 *
 * @author habala
 */
@Entity
@Table(name = "DND_CLASSIFICATION")
public class Classification extends BaseObject<Integer> {

	private ClassificationType type;
	private Map<String, ClassificationLocale> locales;

	@Override
	@Id
	@NotNull
	@Column(name = "DND_CLASSIFICATION_ID", nullable = false)
	@GeneratedValue(generator = "DND_CLASSIFICATION_GEN")
	@GenericGenerator(
		name = "DND_CLASSIFICATION_GEN",
		strategy = "sk.dnd.domain.infra.PoolIdGenerator",
		parameters = {
			@Parameter(name = "table", value = "SYS_SEQUENCE"),
			@Parameter(name = "primary_key_column", value = "SEQ_NAME"),
			@Parameter(name = "value_columen", value = "SEQ_VALUE"),
			@Parameter(name = "primary_key_value", value = "DND_CLASSIFICATION_ID"),
			@Parameter(name = "pool_size", value = "20")
		}
	)
	public Integer getId() {
		return super.getId();
	}

	@Column(name = "TYPE", nullable = false)
	@Enumerated(EnumType.STRING)
	public ClassificationType getType() {
		return type;
	}

	public void setType(ClassificationType type) {
		this.type = type;
	}

	@OneToMany(mappedBy = "classification", fetch = FetchType.LAZY)
	@MapKey(name = "classificationLocalePk.langCode")
	public Map<String, ClassificationLocale> getLocales() {
		return locales;
	}

	public void setLocales(Map<String, ClassificationLocale> locales) {
		this.locales = locales;
	}
}
