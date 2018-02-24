package sk.dnd.service.character;

import java.util.List;

import sk.dnd.domain.character.Character;
import sk.dnd.domain.character.background.Background;
import sk.dnd.domain.character.race.Race;
import sk.dnd.domain.character.subrace.Subrace;

public interface CharacterService {

	Character findCharacter(String characterName);

	Character createCharacter(CharacterCreateForm form);

	List<Race> listRaces(String currentLangCode);

	List<Subrace> listSubraces(String currentLangCode);

	List<Background> listBackgrounds(String currentLangCode);

	Character findCharacterById(Integer characterId);

	List<String> listSubraceJsonsByRaceWithCurrentLocale(Integer raceId, String currentLangCode);

	String getSubracePhysiognomyJson(Integer subraceId);
}
