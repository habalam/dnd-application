package sk.dnd.domain.character;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import sk.dnd.domain.character.race.AbilityModifier;
import sk.dnd.domain.character.race.Race;
import sk.dnd.domain.infra.BaseObject;

@Entity
@Table(name = "DND_CHARACTER_RACE")
public class CharacterRace extends BaseObject<Integer> {

	private Race race;
	private List<AbilityModifier> abilityModifiers;
	private List<CharacterFeature> characterRaceFeatures;
	private List<Classification> languages;
	private Character character;

	@Id
	@Column(name = "DND_CHARACTER_ID", nullable = false, unique = true)
	@Override
	public Integer getId() {
		return super.getId();
	}

	@NotNull
	@OneToOne
	@PrimaryKeyJoinColumn
	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
		if (character != null) {
			setId(character.getId());
		}
	}

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DND_RACE_ID", nullable = false)
	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	@NotNull
	@OneToMany
	@JoinTable(name = "DND_CHARACTER_RACE_ABILITY_MODIFIER",
		joinColumns = @JoinColumn(name = "DND_CHARACTER_ID"),
		inverseJoinColumns = @JoinColumn(name = "DND_ABILITY_MODIFIER_ID")
	)
	public List<AbilityModifier> getAbilityModifiers() {
		return abilityModifiers;
	}

	public void setAbilityModifiers(List<AbilityModifier> abilityModifiers) {
		this.abilityModifiers = abilityModifiers;
	}

	@OneToMany
	@JoinTable(name = "DND_CHARACTER_RACE_LANGUAGE",
		joinColumns = @JoinColumn(name = "DND_CHARACTER_ID"),
		inverseJoinColumns = @JoinColumn(name = "DND_CLASSIFICATION_ID")
	)
	public List<Classification> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Classification> languages) {
		this.languages = languages;
	}

	@OneToMany
	@JoinTable(name = "DND_CHARACTER_RACE_FEATURE",
		joinColumns = @JoinColumn(name = "DND_CHARACTER_ID"),
		inverseJoinColumns = @JoinColumn(name = "DND_CHARACTER_FEATURE_ID")
	)
	public List<CharacterFeature> getCharacterRaceFeatures() {
		return characterRaceFeatures;
	}

	public void setCharacterRaceFeatures(List<CharacterFeature> characterRaceFeatures) {
		this.characterRaceFeatures = characterRaceFeatures;
	}
}
