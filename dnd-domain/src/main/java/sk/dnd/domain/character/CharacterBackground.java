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
	private int languagesCount;
	private List<PersonalCharacteristic> traits;
	private List<PersonalCharacteristic> ideals;
	private List<PersonalCharacteristic> bonds;
	private List<PersonalCharacteristic> flaws;
	private Map<String, CharacterBackgroundLocale> locales;
	private Map<String, CharacterBackgroundSpeciality> specialities;

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

	@NotNull
	@Column(name = "LANGUAGES_COUNT", nullable = false)
	public int getLanguagesCount() {
		return languagesCount;
	}

	public void setLanguagesCount(int languagesCount) {
		this.languagesCount = languagesCount;
	}

	@OneToMany(mappedBy = "characterBackground", fetch = FetchType.LAZY)
	@MapKey(name = "characterBackgroundLocalePk.langCode")
	public Map<String, CharacterBackgroundLocale> getLocales() {
		return locales;
	}

	public void setLocales(Map<String, CharacterBackgroundLocale> locales) {
		this.locales = locales;
	}

	@OneToMany(mappedBy = "characterBackground", fetch = FetchType.LAZY)
	@MapKey(name = "langCode")
	public Map<String, CharacterBackgroundSpeciality> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(Map<String, CharacterBackgroundSpeciality> specialities) {
		this.specialities = specialities;
	}

	@NotNull
	@OneToMany
	@JoinTable(name = "DND_CHARACTER_BACKGROUND_TRAIT",
		joinColumns = @JoinColumn(name = "DND_CHARACTER_BACKGROUND_ID"),
		inverseJoinColumns = @JoinColumn(name = "DND_PERSONAL_CHARACTERISTIC_ID"))
	public List<PersonalCharacteristic> getTraits() {
		return traits;
	}

	public void setTraits(List<PersonalCharacteristic> traits) {
		this.traits = traits;
	}

	@NotNull
	@OneToMany
	@JoinTable(name = "DND_CHARACTER_BACKGROUND_IDEAL",
		joinColumns = @JoinColumn(name = "DND_CHARACTER_BACKGROUND_ID"),
		inverseJoinColumns = @JoinColumn(name = "DND_PERSONAL_CHARACTERISTIC_ID"))
	public List<PersonalCharacteristic> getIdeals() {
		return ideals;
	}

	public void setIdeals(List<PersonalCharacteristic> ideals) {
		this.ideals = ideals;
	}

	@NotNull
	@OneToMany
	@JoinTable(name = "DND_CHARACTER_BACKGROUND_BOND",
		joinColumns = @JoinColumn(name = "DND_CHARACTER_BACKGROUND_ID"),
		inverseJoinColumns = @JoinColumn(name = "DND_PERSONAL_CHARACTERISTIC_ID"))
	public List<PersonalCharacteristic> getBonds() {
		return bonds;
	}

	public void setBonds(List<PersonalCharacteristic> bonds) {
		this.bonds = bonds;
	}

	@NotNull
	@OneToMany
	@JoinTable(name = "DND_CHARACTER_BACKGROUND_FLAW",
		joinColumns = @JoinColumn(name = "DND_CHARACTER_BACKGROUND_ID"),
		inverseJoinColumns = @JoinColumn(name = "DND_PERSONAL_CHARACTERISTIC_ID"))
	public List<PersonalCharacteristic> getFlaws() {
		return flaws;
	}

	public void setFlaws(List<PersonalCharacteristic> flaws) {
		this.flaws = flaws;
	}
}
