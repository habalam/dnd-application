package sk.dnd.domain.character;

import java.util.List;
import java.util.Map;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import sk.dnd.domain.infra.BaseObject;

@Entity
@Table(name = "DND_CHARACTER_BACKGROUND")
public class CharacterBackground extends BaseObject<Integer> {

	private List<Classification> skills;
	private List<Classification> languages;
	private Map<String, CharacterBackgroundLocale> locales;

	@Id
	@Column(name = "DND_CHARACTER_BACKGROUND_ID", nullable = false, unique = true)
	@GeneratedValue(generator = "DND_CHARACTER_BACKGROUND_GEN")
	@GenericGenerator(
		name = "DND_CHARACTER_BACKGROUND_GEN",
		strategy = "sk.dnd.domain.infra.PoolIdGenerator",
		parameters = {
			@Parameter(name = "table", value = "SYS_SEQUENCE"),
			@Parameter(name = "primary_key_column", value = "SEQ_NAME"),
			@Parameter(name = "primary_key_value", value = "DND_CHARACTER_BACKGROUND_ID"),
			@Parameter(name = "value_column", value = "SEQ_COUNT"),
			@Parameter(name = "pool_size", value = "20")
		}
	)
	public Integer getId() {
		return super.getId();
	}

	@ManyToMany
	@JoinTable(name = "DND_CHARACTER_BACKGROUND_SKILL",
		joinColumns = @JoinColumn(name = "DND_CHARACTER_BACKGROUND_ID"),
		inverseJoinColumns = @JoinColumn(name = "DND_CLASSIFICATION_ID")
	)
	public List<Classification> getSkills() {
		return skills;
	}

	public void setSkills(List<Classification> skills) {
		this.skills = skills;
	}

	@ManyToMany
	@JoinTable(name = "DND_CHARACTER_BACKGROUND_LANGUAGE",
		joinColumns = @JoinColumn(name = "DND_CHARACTER_BACKGROUND_ID"),
		inverseJoinColumns = @JoinColumn(name = "DND_CLASSIFICATION_ID")
	)
	public List<Classification> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Classification> languages) {
		this.languages = languages;
	}

	@NotNull
	@OneToMany(mappedBy = "characterBackground", fetch = FetchType.LAZY)
	@MapKey(name = "characterBackgroundLocalePk.langCode")
	public Map<String, CharacterBackgroundLocale> getLocales() {
		return locales;
	}

	public void setLocales(Map<String, CharacterBackgroundLocale> locales) {
		this.locales = locales;
	}
}
