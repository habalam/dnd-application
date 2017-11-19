package sk.dnd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.dnd.domain.character.Character;
import sk.dnd.domain.character.CharacterBackground;
import sk.dnd.domain.character.CharacterBackgroundRepository;
import sk.dnd.domain.character.CharacterRepository;
import sk.dnd.domain.character.support.Allignment;
import sk.dnd.domain.character.support.RaceType;
import sk.dnd.domain.character.support.SubraceType;

@Component
public class CharacterServiceImpl implements CharacterService {

	@Autowired
	private CharacterRepository characterRepository;

	@Autowired
	private CharacterBackgroundRepository characterBackgroundRepository;

	public Character findCharacter(String characterName) {
		return characterRepository.findByName(characterName);
	}

	public Character createCharacter() {
		CharacterBackground criminalBackground = characterBackgroundRepository.findById(2);

		Character character = new Character();
		character.setName("Grondal");
		character.setLevel(20);
		character.setHitPoints(200);
		character.setCharacterRace(RaceType.DWARF);
		character.setCharacterSubrace(SubraceType.DWARF_HILL);
		character.setStrength(20);
		character.setDexterity(20);
		character.setConstitution(20);
		character.setWisdom(20);
		character.setIntelligence(20);
		character.setCharisma(20);
		character.setExperiencePoints(0);
		character.setAllignment(Allignment.GOOD_LAWFUL);
		character.setOrigin("Test origin");
		character.setInspired(true);
		character.setCharacterBackground(criminalBackground);
		characterRepository.save(character);
		return character;
	}
}
