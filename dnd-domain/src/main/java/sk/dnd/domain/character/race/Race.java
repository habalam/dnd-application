package sk.dnd.domain.character.race;

import java.util.List;
import java.util.Map;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import sk.dnd.domain.character.Classification;
import sk.dnd.domain.character.support.SizeType;
import sk.dnd.domain.infra.BaseObject;

@Entity
@Table(name = "DND_RACE")
public class Race extends BaseObject<Integer> {

	private List<AbilityModifier> raceAbilityModifiers;
	private List<Feature> raceFeatures;
	private Map<String, RaceLocale> locales;
	private SizeType size;
	private int speed;
	private boolean darkvision;
	private List<Subrace> subraces;
	private List<Classification> languages;
	//TODO prejst vsetky rasy a implentovat pripadne specialitky

	@Override
	@Id
	@Column(name = "DND_RACE_ID", nullable = false)
	@GeneratedValue(generator = "DND_RACE_GEN")
	@GenericGenerator(name = "DND_RACE_GEN",
		strategy = "sk.dnd.domain.infra.PoolIdGenerator",
		parameters = {
			@Parameter(name = "table", value = "SYS_SEQUENCE"),
			@Parameter(name = "primary_key_column", value = "SEQ_NAME"),
			@Parameter(name = "value_columen", value = "SEQ_VALUE"),
			@Parameter(name = "primary_key_value", value = "DND_RACE_ID"),
			@Parameter(name = "pool_size", value = "20")
		})
	public Integer getId() {
		return super.getId();
	}

	@NotNull
	@OneToMany
	@JoinTable(name = "DND_RACE_ABILITY_MODIFIER",
		joinColumns = @JoinColumn(name = "DND_ABILITY_MODIFIER_ID"),
		inverseJoinColumns = @JoinColumn(name = "DND_RACE_ID")
	)
	public List<AbilityModifier> getRaceAbilityModifiers() {
		return raceAbilityModifiers;
	}

	public void setRaceAbilityModifiers(List<AbilityModifier> raceAbilityModifiers) {
		this.raceAbilityModifiers = raceAbilityModifiers;
	}

	@NotNull
	@OneToMany(mappedBy = "race", fetch = FetchType.LAZY)
	@MapKey(name = "raceLocalePk.langCode")
	public Map<String, RaceLocale> getLocales() {
		return locales;
	}

	public void setLocales(Map<String, RaceLocale> locales) {
		this.locales = locales;
	}

	@NotNull
	@Column(name = "SIZE", nullable = false)
	@Enumerated(EnumType.STRING)
	public SizeType getSize() {
		return size;
	}

	public void setSize(SizeType size) {
		this.size = size;
	}

	@NotNull
	@Column(name = "SPEED", nullable = false)
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@NotNull
	@Column(name = "DARKVISION", nullable = false)
	@Type(type = "yes_no")
	public boolean isDarkvision() {
		return darkvision;
	}

	public void setDarkvision(boolean darkvision) {
		this.darkvision = darkvision;
	}

	@NotNull
	@OneToMany
	@JoinTable(name = "DND_RACE_FEATURE",
		joinColumns = @JoinColumn(name = "DND_RACE_ID"),
		inverseJoinColumns = @JoinColumn(name = "DND_FEATURE_ID")
	)
	public List<Feature> getRaceFeatures() {
		return raceFeatures;
	}

	public void setRaceFeatures(List<Feature> raceFeatures) {
		this.raceFeatures = raceFeatures;
	}

	@OneToMany(mappedBy = "race", fetch = FetchType.LAZY)
	public List<Subrace> getSubraces() {
		return subraces;
	}

	public void setSubraces(List<Subrace> subraces) {
		this.subraces = subraces;
	}

	@ManyToMany
	@JoinTable(name = "DND_RACE_LANGUAGE",
		joinColumns = @JoinColumn(name = "DND_RACE_ID"),
		inverseJoinColumns = @JoinColumn(name = "DND_CLASSIFICATION_ID")
	)
	public List<Classification> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Classification> languages) {
		this.languages = languages;
	}
}
