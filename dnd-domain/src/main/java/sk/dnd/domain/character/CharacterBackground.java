package sk.dnd.domain.character;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import sk.dnd.domain.character.background.Background;
import sk.dnd.domain.infra.BaseObject;

@Entity
@Table(name = "DND_CHARACTER_BACKGROUND")
public class CharacterBackground extends BaseObject<Integer>{

	private List<Classification> skills;
	private List<Classification> languages;
	private List<PersonalCharacteristic> traits;
	private List<PersonalCharacteristic> ideals;
	private List<PersonalCharacteristic> bonds;
	private List<PersonalCharacteristic> flaws;

	private Character character;
	private Background background;

	@Id
	@Column(name = "DND_CHARACTER_ID", nullable = false, unique = true)
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DND_BACKGROUND_ID", nullable = false)
	public Background getBackground() {
		return background;
	}

	public void setBackground(Background background) {
		this.background = background;
	}

	@ManyToMany
	@JoinTable(name = "DND_CHARACTER_BACKGROUND_TRAIT",
		joinColumns = @JoinColumn(name = "DND_CHARACTER_ID"),
		inverseJoinColumns = @JoinColumn(name = "DND_PERSONAL_CHARACTERISTIC_ID")
	)
	public List<PersonalCharacteristic> getTraits() {
		return traits;
	}

	public void setTraits(List<PersonalCharacteristic> traits) {
		this.traits = traits;
	}

	@ManyToMany
	@JoinTable(name = "DND_CHARACTER_BACKGROUND_IDEAL",
		joinColumns = @JoinColumn(name = "DND_CHARACTER_ID"),
		inverseJoinColumns = @JoinColumn(name = "DND_PERSONAL_CHARACTERISTIC_ID")
	)
	public List<PersonalCharacteristic> getIdeals() {
		return ideals;
	}

	public void setIdeals(List<PersonalCharacteristic> ideals) {
		this.ideals = ideals;
	}

	@ManyToMany
	@JoinTable(name = "DND_CHARACTER_BACKGROUND_BOND",
		joinColumns = @JoinColumn(name = "DND_CHARACTER_ID"),
		inverseJoinColumns = @JoinColumn(name = "DND_PERSONAL_CHARACTERISTIC_ID")
	)
	public List<PersonalCharacteristic> getBonds() {
		return bonds;
	}

	public void setBonds(List<PersonalCharacteristic> bonds) {
		this.bonds = bonds;
	}

	@ManyToMany
	@JoinTable(name = "DND_CHARACTER_BACKGROUND_FLAW",
		joinColumns = @JoinColumn(name = "DND_CHARACTER_ID"),
		inverseJoinColumns = @JoinColumn(name = "DND_PERSONAL_CHARACTERISTIC_ID")
	)
	public List<PersonalCharacteristic> getFlaws() {
		return flaws;
	}

	public void setFlaws(List<PersonalCharacteristic> flaws) {
		this.flaws = flaws;
	}

	@ManyToMany
	@JoinTable(name = "DND_CHARACTER_BACKGROUND_LANGUAGE",
		joinColumns = @JoinColumn(name = "DND_CHARACTER_ID"),
		inverseJoinColumns = @JoinColumn(name = "DND_CLASSIFICATION_ID")
	)
	public List<Classification> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Classification> languages) {
		this.languages = languages;
	}

	@ManyToMany
	@JoinTable(name = "DND_CHARACTER_BACKGROUND_SKILL",
		joinColumns = @JoinColumn(name = "DND_CHARACTER_ID"),
		inverseJoinColumns = @JoinColumn(name = "DND_CLASSIFICATION_ID")
	)
	public List<Classification> getSkills() {
		return skills;
	}

	public void setSkills(List<Classification> skills) {
		this.skills = skills;
	}
}
