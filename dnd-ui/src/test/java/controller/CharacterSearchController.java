package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.dnd.domain.character.Character;
import sk.dnd.domain.character.CharacterRepository;
import sk.dnd.service.CharacterService;

@SpringBootApplication
@EntityScan("sk.dnd")
@EnableJpaRepositories("sk.dnd")
@ComponentScan("sk.dnd")
@RestController
public class CharacterSearchController {

	@Autowired
	private CharacterService characterService;

	@Autowired
	private CharacterRepository characterRepository;


	@GetMapping("/test")
	public String home() {
		characterService.setMessage("Auto");
		return characterService.getMessage();
	}

	@GetMapping("/character")
	public Character showCharacter(String characterName) {
		Character character = new Character();
		character.setName("Grondal");
		character.setLevel(20);
		characterRepository.save(character);
		return characterRepository.findByName(characterName);
	}

	public static void main(String[]args) {
		SpringApplication.run(CharacterSearchController.class, args);
	}
}
