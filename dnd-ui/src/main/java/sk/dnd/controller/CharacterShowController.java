package sk.dnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sk.dnd.domain.character.Character;
import sk.dnd.service.character.CharacterService;

@Controller
public class CharacterShowController {

	@Autowired
	private CharacterService characterService;

	@RequestMapping("/character/{id}")
	public String showCharacter(@PathVariable(name = "id") Integer characterId, Model model) {
		Character character = characterService.findCharacterById(characterId);
		model.addAttribute("character", character);
		return "show";
	}
}
