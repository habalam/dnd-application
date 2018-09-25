package sk.dnd.controller;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import sk.dnd.domain.character.Character;
import sk.dnd.domain.character.Gender;
import sk.dnd.domain.character.support.Allignment;
import sk.dnd.domain.util.LangUtils;
import sk.dnd.service.character.CharacterCreateForm;
import sk.dnd.service.character.CharacterService;

@SessionAttributes("characterCreateForm")
@Controller
public class CharacterCreateController {

	@Autowired
	private CharacterService characterService;

	@RequestMapping("/createCharacter")
	public String createCharacter(CharacterCreateForm characterCreateForm, Model model) {
		Character character = characterService.createCharacter(characterCreateForm);
		model.addAttribute("character", character);
		return "greeting";
	}

	@RequestMapping("/reset")
	public String reset(CharacterCreateForm characterCreateForm) {
		characterCreateForm.reset();
		return "redirect:/creating";
	}

	@RequestMapping("/creating")
	public String characterCreation(CharacterCreateForm characterCreateForm, Model model) {
		setDefaultParameters(model);
		return "create";
	}

	private void setDefaultParameters(Model model) {
		String currentLangCode = LangUtils.getCurrentLangCode();
		model.addAttribute("genders", Gender.values());
		model.addAttribute("allignments", Allignment.values());
		model.addAttribute("races", characterService.listRaces(currentLangCode));
		model.addAttribute("subraces", characterService.listSubraces(currentLangCode));
		model.addAttribute("backgrounds", characterService.listBackgrounds(currentLangCode));
	}


	@RequestMapping("/subrace/physiognomy")
	@ResponseBody
	public String getSubracePhysiognomy(@RequestParam("subraceId") Integer subraceId) {
		return characterService.getSubracePhysiognomyJson(subraceId);
	}

}
