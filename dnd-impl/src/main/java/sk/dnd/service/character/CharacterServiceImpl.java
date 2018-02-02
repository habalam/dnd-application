package sk.dnd.service.character;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.dnd.domain.character.*;
import sk.dnd.domain.character.Character;
import sk.dnd.domain.character.background.Background;
import sk.dnd.domain.character.background.BackgroundRepositoryCustom;
import sk.dnd.domain.character.race.AbilityModifier;
import sk.dnd.domain.character.race.AbilityModifierRepository;
import sk.dnd.domain.character.race.Race;
import sk.dnd.domain.character.race.RaceRepositoryCustom;
import sk.dnd.domain.character.subrace.Subrace;
import sk.dnd.domain.character.subrace.SubraceRepositoryCustom;
import sk.dnd.domain.character.support.ClassificationType;

@Component
public class CharacterServiceImpl implements CharacterService {

	@Autowired
	private CharacterRepository characterRepository;

	@Autowired
	private RaceRepositoryCustom raceRepositoryCustom;

	@Autowired
	private AbilityModifierRepository abilityModifierRepository;

	@Autowired
	private SubraceRepositoryCustom subraceRepositoryCustom;

	@Autowired
	private BackgroundRepositoryCustom characterBackgroundRepositoryCustom;

	@Autowired
	private ClassificationRepository classificationRepository;

	@Override
	public Character findCharacter(String characterName) {
		return characterRepository.findByName(characterName);
	}

	@Override
	public Character createCharacter(CharacterCreateForm form) {
		Character character = new Character();
		character.setName(form.getName());
		character.setLevel(form.getLevel());
		character.setHitPoints(form.getHitPoints());
		character.setTemporaryHitPoints(form.getTemporaryHitPoints());
		character.setWounds(form.getWounds());
		character.setGender(form.getGender());
		character.setAllignment(form.getAllignment());
		character.setStrength(form.getStrength());
		character.setDexterity(form.getDexterity());
		character.setConstitution(form.getConstitution());
		character.setWisdom(form.getWisdom());
		character.setIntelligence(form.getIntelligence());
		character.setCharisma(form.getCharisma());
		character.setInspired(form.isInspired());
		character.setOrigin(form.getOrigin());
		characterRepository.save(character);

		CharacterBackground characterBackground = createCharacterBackground(character, form);
		character.setCharacterBackground(characterBackground);

		CharacterRace characterRace = createCharacterRace(character, form);
		character.setCharacterRace(characterRace);

		CharacterSubrace characterSubrace = createCharacterSubrace(character, form);
		character.setCharacterSubrace(characterSubrace);

		CharacterDimension characterDimension = createCharacterDimension(character);
		character.setCharacterDimension(characterDimension);

		characterRepository.save(character);
		return character;
	}

	//TODO move to new serice to get list of DB objects (race, subrace, backround, ...)

	@Override
	public List<Race> listRaces(String currentLangCode) {
		return raceRepositoryCustom.listAllWithCurrentLocale(currentLangCode);
	}
	//TODO move to new serice to get list of DB objects (race, subrace, backround, ...)

	@Override
	public List<Subrace> listSubraces(String currentLangCode) {
		return subraceRepositoryCustom.listAllWithCurrentLocale(currentLangCode);
	}
	//TODO move to new serice to get list of DB objects (race, subrace, backround, ...)

	@Override
	public List<Background> listBackgrounds(String currentLangCode) {
		return characterBackgroundRepositoryCustom.listAllWithCurrentLocale(currentLangCode);
	}
	@Override
	public Character findCharacterById(Integer characterId) {
		return characterRepository.findById(characterId);
	}

	private CharacterDimension createCharacterDimension(Character character) {
		CharacterDimension characterDimension = new CharacterDimension();
		characterDimension.setCharacter(character);
		characterDimension.setFeets(6);
		characterDimension.setInches(0);
		characterDimension.setPounds(170);
		return characterDimension;
	}

	private CharacterRace createCharacterRace(Character character, CharacterCreateForm form) {
		Race race = form.getRace();
		CharacterRace characterRace = new CharacterRace();
		characterRace.setCharacter(character);
		characterRace.setRace(race);
		List<AbilityModifier> characterRaceAbilityModifiers = new ArrayList<>();
		for(AbilityModifier abilityModifier: race.getRaceAbilityModifiers()) {
			AbilityModifier characterRaceAbilityModifier = new AbilityModifier();
			characterRaceAbilityModifier.setAbilityType(abilityModifier.getAbilityType());
			characterRaceAbilityModifier.setValue(abilityModifier.getValue());
			abilityModifierRepository.save(characterRaceAbilityModifier);
			characterRaceAbilityModifiers.add(characterRaceAbilityModifier);
		}
		characterRace.setAbilityModifiers(characterRaceAbilityModifiers);
		return characterRace;
	}

	private CharacterSubrace createCharacterSubrace(Character character, CharacterCreateForm form) {
		Subrace subrace = form.getSubrace();
		CharacterSubrace characterSubrace = new CharacterSubrace();
		characterSubrace.setCharacter(character);
		characterSubrace.setSubrace(subrace);
		List<AbilityModifier> characterSubraceAbilityModifiers = new ArrayList<>();
		for(AbilityModifier abilityModifier: subrace.getSubraceAbilityModifiers()) {
			AbilityModifier characterSubaceAbilityModifier = new AbilityModifier();
			characterSubaceAbilityModifier.setAbilityType(abilityModifier.getAbilityType());
			characterSubaceAbilityModifier.setValue(abilityModifier.getValue());
			abilityModifierRepository.save(characterSubaceAbilityModifier);
			characterSubraceAbilityModifiers.add(characterSubaceAbilityModifier);
		}
		characterSubrace.setAbilityModifiers(characterSubraceAbilityModifiers);
		return characterSubrace;
	}

	private CharacterBackground createCharacterBackground(Character character, CharacterCreateForm form) {
		Background background = form.getBackground();
		CharacterBackground characterBackground = new CharacterBackground();
		characterBackground.setCharacter(character);
		characterBackground.setBackground(background);
		characterBackground.setTraits(new ArrayList<>(background.getTraits()));
		characterBackground.setBonds(new ArrayList<>(background.getBonds()));
		characterBackground.setIdeals(new ArrayList<>(background.getIdeals()));
		characterBackground.setFlaws(new ArrayList<>(background.getFlaws()));
		characterBackground.setSkills(new ArrayList<>(background.getSkills()));
		List<Classification> languages = new ArrayList<>();
		int languagesSelected = 0;
		Iterator<Classification> classificationsIterator = classificationRepository.findAll().iterator();
		while(classificationsIterator.hasNext() && languagesSelected < background.getLanguagesCount()) {
			Classification classification = classificationsIterator.next();
			if(ClassificationType.LANGUAGE.equals(classification.getType())) {
				languages.add(classification);
				languagesSelected++;
			}
		}
		characterBackground.setLanguages(languages);
		return characterBackground;
	}
}
