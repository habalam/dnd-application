package sk.dnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sk.dnd.domain.character.Character;
import sk.dnd.domain.character.Gender;
import sk.dnd.domain.character.support.Allignment;
import sk.dnd.service.character.CharacterCreateForm;
import sk.dnd.service.character.CharacterService;

//TODO create separate controller for Character creation
@Controller
public class CharacterSearchController {

	@Autowired
	private CharacterService characterService;

	@RequestMapping("/character")
	public String showCharacter(String characterName, Model model) {
		Character character = characterService.findCharacter(characterName);
		model.addAttribute("character", character);
		return "greeting";
	}

	@RequestMapping("/createCharacter")
	public String createCharacter(@ModelAttribute CharacterCreateForm characterCreateForm, Model model) {
		Character character = characterService.createCharacter(characterCreateForm);
		model.addAttribute("character", character);
		return "greeting";
	}

	@RequestMapping("/creating")
	public String characterCreation(Model model) {
		model.addAttribute("characterCreateForm", new CharacterCreateForm());
		model.addAttribute("genders", Gender.values());
		model.addAttribute("allignments", Allignment.values());
		return "create";
	}

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
}
