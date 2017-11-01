package sk.dnd.domain.character.support;

import sk.dnd.domain.character.support.subrace.*;

/**
 * SubraceType.
 *
 * @author habala
 */
//TODO some races don't have subraces (dragonborn, tiefling, ...)
public enum SubraceType {

	DWARF_HILL(RaceType.DWARF, new HillDwarf()),
	DWARF_MOUNTAIN(RaceType.DWARF, new MountainDwarf()),
	ELF_HIGH(RaceType.ELF, new HighElf()),
	ELF_WOOD(RaceType.ELF, new WoodElf()),
	ELF_DARK(RaceType.ELF, new DarkElf()),
	HALFLING_LIGHTFOOT(RaceType.HALFLING, new LightfootHalfling()),
	HALFLING_STOUT(RaceType.HALFLING, new StoutHalfling()),
	HUMAN_CLASSIC(RaceType.HUMAN, new ClassicHuman()),
	HUMAN_VARIANT(RaceType.HUMAN, new VariantHuman()),
	GNOME_FOREST(RaceType.GNOME, new ForestGnome()),
	GNOME_ROCK(RaceType.GNOME, new RockGnome());

	private final RaceType raceType;
	private final SubraceBase subraceBase;

	private SubraceType(RaceType raceType, SubraceBase subraceBase) {
		this.raceType = raceType;
		this.subraceBase = subraceBase;
	}
}
