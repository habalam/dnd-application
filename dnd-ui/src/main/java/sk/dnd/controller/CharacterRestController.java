package sk.dnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sk.dnd.domain.util.LangUtils;
import sk.dnd.service.character.CharacterService;

@Controller
public class CharacterRestController {

	@Autowired
	private CharacterService service;

	@RequestMapping(value = "/races")
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:4200")
	String getRaces() {
		return service.racesListJsonsWithCurrentLocale(LangUtils.getCurrentLangCode());
	}

	@RequestMapping("/subraces")
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:4200")
	String getSubraces(@RequestParam(value = "raceId") Integer raceId) {
		return service.listSubracesListJsonByRaceWithCurrentLocale(raceId, LangUtils.getCurrentLangCode());
	}
}
