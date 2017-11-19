package sk.dnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.dnd.domain.character.Character;
import sk.dnd.domain.character.CharacterBackground;
import sk.dnd.domain.character.CharacterBackgroundRepository;
import sk.dnd.domain.character.support.Allignment;
import sk.dnd.domain.character.support.RaceType;
import sk.dnd.domain.character.support.SubraceType;
import sk.dnd.service.CharacterService;

@RestController
public class CharacterSearchController {

	@Autowired
	private CharacterService characterService;

	@GetMapping("/character")
	public Character showCharacter(String characterName) {
		return characterService.findCharacter(characterName);
	}

	@GetMapping("/createCharacter")
	public Character createCharacter() {
		return characterService.createCharacter();
	}
}
