package sk.dnd.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sk.dnd.domain.character.Character;

//@Repository
public class CharacterRepositoryImpl /*implements CharacterRepository*/ {

	private static final List<Character> CHARACTERS;

	static {
		List<Character> characters = new ArrayList<>();
		characters.add(createCharacter("Grondal", 20));
		characters.add(createCharacter("Torgal", 1));
		CHARACTERS = Collections.unmodifiableList(characters);
	}

	private static Character createCharacter(String characterName, int level) {
		Character character = new Character();
		character.setName(characterName);
		character.setLevel(level);
		return character;
	}

//	@Override
	public Character findByCharacterName(String characterName) {
		for (Character character: CHARACTERS) {
			if (character.getName().equals(characterName)) {
				return character;
			}
		}
		return null;
	}
}
