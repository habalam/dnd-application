package sk.dnd.domain.character.subrace;

import java.util.List;
import java.util.Map;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import sk.dnd.domain.character.race.AbilityModifier;
import sk.dnd.domain.character.race.Feature;
import sk.dnd.domain.character.race.Race;
import sk.dnd.domain.infra.BaseObject;

@Entity
@Table(name = "DND_SUBRACE")
public class Subrace extends BaseObject<Integer> {

	private List<AbilityModifier> subraceAbilityModifiers;
	private List<Feature> subraceFeatures;
	private SubracePhysiognomy racePhysiognomy;
	private Map<String, SubraceLocale> locales;

	private Race race;
	private SubraceLocale currentLocale;

	@Override
	@Id
	@Column(name = "DND_SUBRACE_ID", nullable = false)
	@GeneratedValue(generator = "DND_SUBRACE_GEN")
	@GenericGenerator(name = "DND_SUBRACE_GEN",
		strategy = "sk.dnd.domain.infra.PoolIdGenerator",
		parameters = {
			@Parameter(name = "table", value = "SYS_SEQUENCE"),
			@Parameter(name = "primary_key_column", value = "SEQ_NAME"),
			@Parameter(name = "value_columen", value = "SEQ_VALUE"),
			@Parameter(name = "primary_key_value", value = "DND_ABILITY_ID"),
			@Parameter(name = "pool_size", value = "20")
		}
	)
	public Integer getId() {
		return super.getId();
	}

	@NotNull
	@OneToMany
	@JoinTable(name = "DND_SUBRACE_ABILITY_MODIFIER",
		joinColumns = @JoinColumn(name = "DND_SUBRACE_ID"),
		inverseJoinColumns = @JoinColumn(name = "DND_ABILITY_MODIFIER_ID")
	)
	public List<AbilityModifier> getSubraceAbilityModifiers() {
		return subraceAbilityModifiers;
	}

	public void setSubraceAbilityModifiers(List<AbilityModifier> subraceAbilityModifiers) {
		this.subraceAbilityModifiers = subraceAbilityModifiers;
	}

	@NotNull
	@OneToMany
	@JoinTable(name = "DND_SUBRACE_FEATURE",
		joinColumns = @JoinColumn(name = "DND_SUBRACE_ID"),
		inverseJoinColumns = @JoinColumn(name = "DND_FEATURE_ID")
	)
	public List<Feature> getSubraceFeatures() {
		return subraceFeatures;
	}

	public void setSubraceFeatures(List<Feature> subraceFeatures) {
		this.subraceFeatures = subraceFeatures;
	}

	@NotNull
	@OneToMany(mappedBy = "subrace", fetch = FetchType.LAZY)
	@MapKey(name = "subraceLocalePk.langCode")
	public Map<String, SubraceLocale> getLocales() {
		return locales;
	}

	public void setLocales(Map<String, SubraceLocale> locales) {
		this.locales = locales;
	}

	@NotNull
	@ManyToOne
	@JoinColumn(name = "DND_RACE_ID", nullable = false)
	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	@NotNull
	@OneToOne(mappedBy = "subrace", optional = false)
	public SubracePhysiognomy getRacePhysiognomy() {
		return racePhysiognomy;
	}

	public void setRacePhysiognomy(SubracePhysiognomy racePhysiognomy) {
		this.racePhysiognomy = racePhysiognomy;
	}

	@Transient
	public SubraceLocale getCurrentLocale() {
		return currentLocale;
	}

	public void setCurrentLocale(String currentLangCode) {
		this.currentLocale = locales.get(currentLangCode);
	}

	public void setCurrentLocale(SubraceLocale currentLocale) {
		this.currentLocale = currentLocale;
	}
}
