package sk.dnd.service;

import sk.dnd.domain.character.Character;

public interface CharacterService {

	public Character findCharacter(String characterName);

	public Character createCharacter();
}
