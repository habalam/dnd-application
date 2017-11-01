package sk.dnd.domain.character.support;

import sk.dnd.domain.character.support.race.*;

/**
 * RaceType.
 *
 * @author habala
 */
public enum RaceType {

	DWARF(new Dwarf()),
	ELF(new Elf()),
	HALFLING(new Halfling()),
	HUMAN(new Human()),
	DRAGONBORN(new Dragonborn()),
	GNOME(new Gnome()),
	HALFELF(new Halfelf()),
	HALFORC(new Halforc()),
	TIEFLING(new Tiefling());

	private final RaceBase raceBase;

	private RaceType(RaceBase raceBase) {
		this.raceBase = raceBase;
	}

	public RaceBase getRaceBase() {
		return raceBase;
	}
}
