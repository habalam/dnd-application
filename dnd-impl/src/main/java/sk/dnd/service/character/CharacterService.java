package sk.dnd.service.character;

import java.util.List;

import sk.dnd.domain.character.Character;
import sk.dnd.domain.character.race.Race;
import sk.dnd.domain.character.race.Subrace;

public interface CharacterService {

	Character findCharacter(String characterName);

	Character createCharacter();

	Character createCharacter(CharacterCreateForm form);

	List<Race> listRaces();

	List<Subrace> listSubraces();
}
