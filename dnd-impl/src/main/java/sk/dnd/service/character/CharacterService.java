package sk.dnd.service.character;

import sk.dnd.domain.character.Character;

public interface CharacterService {

	Character findCharacter(String characterName);

	Character createCharacter();

	Character createCharacter(CharacterCreateForm form);
}
