package sk.dnd.domain.character.support;

import sk.dnd.domain.character.support.profession.*;

//TODO doplnit javadoc
public enum ProfessionType {

	BARBARIAN(new Barbarian()),
	BARD(new Bard()),
	CLERIC(new Cleric()),
	DRUID(new Druid()),
	FIGHTER(new Fighter()),
	MONK(new Monk()),
	PALADIN(new Paladin()),
	RANGER(new Ranger()),
	ROGUE(new Rogue()),
	SORCERER(new Sorcerer()),
	WARLOCK(new Warlock()),
	WIZARD(new Wizard());

	private ProfessionBase characterBase;

	ProfessionType(ProfessionBase characterBase) {
		this.characterBase = characterBase;
	}

	public ProfessionBase getCharacterBase() {
		return characterBase;
	}
}
