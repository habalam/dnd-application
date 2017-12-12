package sk.dnd.domain.character;

import java.util.List;

import javax.persistence.*;

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.springframework.cache.annotation.Cacheable;
import sk.dnd.domain.character.support.Allignment;
import sk.dnd.domain.infra.BaseObject;
import sk.dnd.domain.util.DndConsts;

/**
 * Entity for played character. Has class, levels, ... .
 */
@Entity
@Table(name = "DND_CHARACTER")
@Cacheable
public class Character extends BaseObject<Integer> {

	private String name;
	private int level;
	private int hitPoints;
	private int temporaryHitPoints;
	private int experiencePoints;
	private int hitPointsCurrent;
	private int wounds;

	private Gender gender;
	private CharacterDimension characterDimension;
	private Allignment allignment;
	private CharacterRace characterRace;
	private CharacterSubrace characterSubrace;
	private List<CharacterProfession> characterProfessions;
	private CharacterBackground characterBackground;

	private List<PersonalCharacteristic> personalCharacteristics;

	//TODO not propertly implemented
	private CharacterEquipment equipment;

	//TODO maybe separate to new table
	private int strength;
	private int dexterity;
	private int constitution;
	private int wisdom;
	private int intelligence;
	private int charisma;

	private boolean inspired = false;
	private String origin;

	//TODO add skills/tools
	//TODO add languages - from profession/race/feat
	//TODO add equiped equipment + whole items
	//TODO add death saves
	//TODO add feats

	@Override
	@NotNull
	@Column(name = "DND_CHARACTER_ID", nullable = false, unique = true)
	@GeneratedValue(generator = "DND_CHARACTER_GEN")
	@GenericGenerator(
		name = "DND_CHARACTER_GEN",
		strategy = "sk.dnd.domain.infra.PoolIdGenerator",
		parameters = {
			@Parameter(name = "table", value = "SYS_SEQUENCE"),
			@Parameter(name = "primary_key_column", value = "SEQ_NAME"),
			@Parameter(name = "value_column", value = "SEQ_COUNT"),
			@Parameter(name = "primary_key_value", value = "DND_CHARACTER_ID"),
			@Parameter(name = "pool_size", value = "20")
		}
	)
	@Id
	public Integer getId() {
		return super.getId();
	}

	@NotNull
	@Column(name = "LEVEL", nullable = false, length = DndConsts.LEVEL_LEN)
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@OneToMany(mappedBy = "character", fetch = FetchType.LAZY)
	public List<CharacterProfession> getCharacterProfessions() {
		return characterProfessions;
	}

	public void setCharacterProfessions(List<CharacterProfession> characterProfessions) {
		this.characterProfessions = characterProfessions;
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
	@Column(name = "HIT_POINTS", nullable = false, length = DndConsts.HIT_POINTS_LEN)
	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	@NotNull
	@OneToOne(mappedBy = "character", fetch = FetchType.LAZY)
	public CharacterEquipment getEquipment() {
		return equipment;
	}

	public void setEquipment(CharacterEquipment equipment) {
		this.equipment = equipment;
	}

	@NotNull
	@Column(name = "STRENGTH", nullable = false)
	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	@NotNull
	@Column(name = "DEXTERITY", nullable = false)
	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	@NotNull
	@Column(name = "CONSTITUTION", nullable = false)
	public int getConstitution() {
		return constitution;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}

	@NotNull
	@Column(name = "WISDOM", nullable = false)
	public int getWisdom() {
		return wisdom;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	@NotNull
	@Column(name = "INTELLIGENCE", nullable = false)
	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	@NotNull
	@Column(name = "CHARISMA", nullable = false)
	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

	@NotNull
	@Column(name = "GENDER", nullable = false)
	@Enumerated(EnumType.STRING)
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@NotNull
	@Column(name = "ALLIGNMENT", nullable = false)
	public Allignment getAllignment() {
		return allignment;
	}

	public void setAllignment(Allignment allignment) {
		this.allignment = allignment;
	}

	@NotNull
	@Column(name = "EXPERIENCE_POINTS")
	public int getExperiencePoints() {
		return experiencePoints;
	}

	public void setExperiencePoints(int experiencePoints) {
		this.experiencePoints = experiencePoints;
	}

	@NotNull
	@Column(name = "INSPIRED", nullable = false)
	@Type(type = "yes_no")
	public boolean isInspired() {
		return inspired;
	}

	public void setInspired(boolean inspired) {
		this.inspired = inspired;
	}

	@Lob
	@Column(name = "ORIGIN")
	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	@Column(name = "TEMPORARY_HIT_POINTS")
	public int getTemporaryHitPoints() {
		return temporaryHitPoints;
	}

	public void setTemporaryHitPoints(int temporaryHitPoints) {
		this.temporaryHitPoints = temporaryHitPoints;
	}

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DND_CHARACTER_BACKGROUND_ID", nullable = false)
	public CharacterBackground getCharacterBackground() {
		return characterBackground;
	}

	public void setCharacterBackground(CharacterBackground characterBackground) {
		this.characterBackground = characterBackground;
	}

	@OneToOne(mappedBy = "character", cascade = CascadeType.ALL, orphanRemoval = true)
	public CharacterDimension getCharacterDimension() {
		return characterDimension;
	}

	public void setCharacterDimension(CharacterDimension characterDimension) {
		this.characterDimension = characterDimension;
	}

	@ManyToMany
	@JoinTable(name = "DND_CHARACTER_PERTONALITY_CHARACTERISTIC",
		joinColumns = @JoinColumn(name = "DND_CHARACTER_ID"),
		inverseJoinColumns = @JoinColumn(name = "DND_PERSONAL_CHARACTERISTIC_ID")
	)
	public List<PersonalCharacteristic> getPersonalCharacteristics() {
		return personalCharacteristics;
	}

	public void setPersonalCharacteristics(List<PersonalCharacteristic> personalCharacteristics) {
		this.personalCharacteristics = personalCharacteristics;
	}

	@NotNull
	@Column(name = "WOUNDS", nullable = false)
	public int getWounds() {
		return wounds;
	}

	public void setWounds(int wounds) {
		this.wounds = wounds;
	}

	@NotNull
	@Column(name = "HIT_POINTS_CURRENT", nullable = false)
	public int getHitPointsCurrent() {
		return hitPointsCurrent;
	}

	public void setHitPointsCurrent(int hitPointsCurrent) {
		this.hitPointsCurrent = hitPointsCurrent;
	}

	@OneToOne(mappedBy = "character", cascade = CascadeType.ALL, orphanRemoval = true)
	public CharacterRace getCharacterRace() {
		return characterRace;
	}

	public void setCharacterRace(CharacterRace characterRace) {
		this.characterRace = characterRace;
	}

	@OneToOne(mappedBy = "character", cascade = CascadeType.ALL, orphanRemoval = true)
	public CharacterSubrace getCharacterSubrace() {
		return characterSubrace;
	}

	public void setCharacterSubrace(CharacterSubrace characterSubrace) {
		this.characterSubrace = characterSubrace;
	}

	public String toString() {
		//TODO finish
		return null;
	}
}
