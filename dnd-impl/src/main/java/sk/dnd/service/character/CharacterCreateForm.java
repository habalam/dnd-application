package sk.dnd.service.character;

import sk.dnd.domain.character.background.Background;
import sk.dnd.domain.character.Gender;
import sk.dnd.domain.character.race.Race;
import sk.dnd.domain.character.subrace.Subrace;
import sk.dnd.domain.character.support.Allignment;

public class CharacterCreateForm {

	private String name;
	private Integer level;
	private Integer hitPoints;
	private Integer temporaryHitPoints;
	private Integer hitPointsCurrent;
	private Integer wounds;

	private Race race;
	private Subrace subrace;
	private Gender gender;
	private Background background;
	private Allignment allignment;

	private Integer strength;
	private Integer dexterity;
	private Integer constitution;
	private Integer wisdom;
	private Integer intelligence;
	private Integer charisma;

	private boolean inspired;
	private String origin;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(Integer hitPoints) {
		this.hitPoints = hitPoints;
	}

	public Integer getTemporaryHitPoints() {
		return temporaryHitPoints;
	}

	public void setTemporaryHitPoints(Integer temporaryHitPoints) {
		this.temporaryHitPoints = temporaryHitPoints;
	}

	public Integer getHitPointsCurrent() {
		return hitPointsCurrent;
	}

	public void setHitPointsCurrent(Integer hitPointsCurrent) {
		this.hitPointsCurrent = hitPointsCurrent;
	}

	public Integer getWounds() {
		return wounds;
	}

	public void setWounds(Integer wounds) {
		this.wounds = wounds;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Allignment getAllignment() {
		return allignment;
	}

	public void setAllignment(Allignment allignment) {
		this.allignment = allignment;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Integer getDexterity() {
		return dexterity;
	}

	public void setDexterity(Integer dexterity) {
		this.dexterity = dexterity;
	}

	public Integer getConstitution() {
		return constitution;
	}

	public void setConstitution(Integer constitution) {
		this.constitution = constitution;
	}

	public Integer getWisdom() {
		return wisdom;
	}

	public void setWisdom(Integer wisdom) {
		this.wisdom = wisdom;
	}

	public Integer getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(Integer intelligence) {
		this.intelligence = intelligence;
	}

	public Integer getCharisma() {
		return charisma;
	}

	public void setCharisma(Integer charisma) {
		this.charisma = charisma;
	}

	public boolean isInspired() {
		return inspired;
	}

	public void setInspired(boolean inspired) {
		this.inspired = inspired;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Subrace getSubrace() {
		return subrace;
	}

	public void setSubrace(Subrace subrace) {
		this.subrace = subrace;
	}

	public void reset() {
		name = null;
		level = null;
		hitPoints = null;
		temporaryHitPoints = null;
		hitPointsCurrent = null;
		wounds = null;
		race = null;
		subrace = null;
		gender = null;
		allignment = null;
		strength = null;
		dexterity = null;
		constitution = null;
		wisdom = null;
		intelligence = null;
		charisma = null;
		inspired = false;
		origin = null;
	}

	public Background getBackground() {
		return background;
	}

	public void setBackground(Background background) {
		this.background = background;
	}
}
