package sk.dnd.domain.character.background;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import sk.dnd.domain.infra.BaseObject;

@Entity
@Table(name = "DND_BACKGROUND_SPECIALITY")
public class BackgroundSpeciality extends BaseObject<Integer> {

	private String langCode;

	private String name;
	private String description;
	private List<String> values;

	private Background background;


	@Id
	@Column(name = "DND_BACKGROUND_SPECIALITY_ID", nullable = false, unique = true)
	@GeneratedValue(generator = "DND_BACKGROUND_SPECIALITY_GEN")
	@GenericGenerator(
		name = "DND_BACKGROUND_SPECIALITY_GEN",
		strategy = "sk.dnd.domain.infra.PoolIdGenerator",
		parameters = {
			@Parameter(name = "table", value = "SYS_SEQUENCE"),
			@Parameter(name = "primary_key_column", value = "SEQ_NAME"),
			@Parameter(name = "primary_key_value", value = "DND_BACKGROUND_SPECIALITY_ID"),
			@Parameter(name = "value_column", value = "SEQ_COUNT"),
			@Parameter(name = "pool_size", value = "20")
		}
	)
	public Integer getId() {
		return super.getId();
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "DND_BACKGROUND_ID", nullable = false)
	public Background getBackground() {
		return background;
	}

	public void setBackground(Background background) {
		this.background = background;
	}

	@NotNull
	@Column(name = "LANG_CODE", nullable = false)
	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	@NotNull
	@Column(name = "NAME", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull
	@Column(name = "DESCRIPTION", nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ElementCollection
	@CollectionTable(name = "DND_BACKGROUND_SPECIALITY_VALUE", joinColumns = @JoinColumn(name = "DND_BACKGROUND_SPECIALITY_ID"))
	@Column(name = "VALUE")
	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}
}
