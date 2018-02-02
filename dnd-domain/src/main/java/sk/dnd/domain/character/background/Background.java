package sk.dnd.domain.character.background;

import java.util.List;
import java.util.Map;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import sk.dnd.domain.character.Classification;
import sk.dnd.domain.character.PersonalCharacteristic;
import sk.dnd.domain.infra.BaseObject;

//TODO doplnit nejaku entitu pre ukladanie konkrétnych backgroundov - s vybrými skillmi/language/skillmi a pod.
@Entity
@Table(name = "DND_BACKGROUND")
public class Background extends BaseObject<Integer> {

	private List<Classification> skills; //only suggested skills, user can pick different
	private int languagesCount;
	private List<PersonalCharacteristic> traits;
	private List<PersonalCharacteristic> ideals;
	private List<PersonalCharacteristic> bonds;
	private List<PersonalCharacteristic> flaws;
	private Map<String, BackgroundLocale> locales;
	private Map<String, BackgroundSpeciality> specialities;
	private BackgroundLocale currentLocale;

	//TODO add tools
	//TODO add equipment

	@Id
	@Column(name = "DND_BACKGROUND_ID", nullable = false, unique = true)
	@GeneratedValue(generator = "DND_BACKGROUND_GEN")
	@GenericGenerator(
		name = "DND_BACKGROUND_GEN",
		strategy = "sk.dnd.domain.infra.PoolIdGenerator",
		parameters = {
			@Parameter(name = "table", value = "SYS_SEQUENCE"),
			@Parameter(name = "primary_key_column", value = "SEQ_NAME"),
			@Parameter(name = "primary_key_value", value = "DND_BACKGROUND_ID"),
			@Parameter(name = "value_column", value = "SEQ_COUNT"),
			@Parameter(name = "pool_size", value = "20")
		}
	)
	public Integer getId() {
		return super.getId();
	}

	@ManyToMany
	@JoinTable(name = "DND_BACKGROUND_SKILL",
		joinColumns = @JoinColumn(name = "DND_BACKGROUND_ID"),
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

	@OneToMany(mappedBy = "background", fetch = FetchType.LAZY)
	@MapKey(name = "backgroundLocalePk.langCode")
	public Map<String, BackgroundLocale> getLocales() {
		return locales;
	}

	public void setLocales(Map<String, BackgroundLocale> locales) {
		this.locales = locales;
	}

	@OneToMany(mappedBy = "background", fetch = FetchType.LAZY)
	@MapKey(name = "langCode")
	public Map<String, BackgroundSpeciality> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(Map<String, BackgroundSpeciality> specialities) {
		this.specialities = specialities;
	}

	@NotNull
	@OneToMany
	@JoinTable(name = "DND_BACKGROUND_TRAIT",
		joinColumns = @JoinColumn(name = "DND_BACKGROUND_ID"),
		inverseJoinColumns = @JoinColumn(name = "DND_PERSONAL_CHARACTERISTIC_ID"))
	public List<PersonalCharacteristic> getTraits() {
		return traits;
	}

	public void setTraits(List<PersonalCharacteristic> traits) {
		this.traits = traits;
	}

	@NotNull
	@OneToMany
	@JoinTable(name = "DND_BACKGROUND_IDEAL",
		joinColumns = @JoinColumn(name = "DND_BACKGROUND_ID"),
		inverseJoinColumns = @JoinColumn(name = "DND_PERSONAL_CHARACTERISTIC_ID"))
	public List<PersonalCharacteristic> getIdeals() {
		return ideals;
	}

	public void setIdeals(List<PersonalCharacteristic> ideals) {
		this.ideals = ideals;
	}

	@NotNull
	@OneToMany
	@JoinTable(name = "DND_BACKGROUND_BOND",
		joinColumns = @JoinColumn(name = "DND_BACKGROUND_ID"),
		inverseJoinColumns = @JoinColumn(name = "DND_PERSONAL_CHARACTERISTIC_ID"))
	public List<PersonalCharacteristic> getBonds() {
		return bonds;
	}

	public void setBonds(List<PersonalCharacteristic> bonds) {
		this.bonds = bonds;
	}

	@NotNull
	@OneToMany
	@JoinTable(name = "DND_BACKGROUND_FLAW",
		joinColumns = @JoinColumn(name = "DND_BACKGROUND_ID"),
		inverseJoinColumns = @JoinColumn(name = "DND_PERSONAL_CHARACTERISTIC_ID"))
	public List<PersonalCharacteristic> getFlaws() {
		return flaws;
	}

	public void setFlaws(List<PersonalCharacteristic> flaws) {
		this.flaws = flaws;
	}

	@Transient
	public BackgroundLocale getCurrentLocale() {
		return currentLocale;
	}

	public void setCurrentLocale(BackgroundLocale currentLocale) {
		this.currentLocale = currentLocale;
	}

	public void setCurrentLocale(String currentLangCode) {
		this.currentLocale = locales.get(currentLangCode);
	}
}
