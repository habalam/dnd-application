package sk.dnd.service.character;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.dnd.domain.character.Character;
import sk.dnd.domain.character.CharacterBackground;
import sk.dnd.domain.character.CharacterBackgroundRepository;
import sk.dnd.domain.character.CharacterDimension;
import sk.dnd.domain.character.CharacterRace;
import sk.dnd.domain.character.CharacterRepository;
import sk.dnd.domain.character.CharacterSubrace;
import sk.dnd.domain.character.Gender;
import sk.dnd.domain.character.PersonalCharacteristic;
import sk.dnd.domain.character.race.AbilityModifier;
import sk.dnd.domain.character.race.AbilityModifierRepository;
import sk.dnd.domain.character.race.Race;
import sk.dnd.domain.character.race.RaceRepository;
import sk.dnd.domain.character.race.Subrace;
import sk.dnd.domain.character.race.SubraceRepository;
import sk.dnd.domain.character.support.Allignment;

@Component
public class CharacterServiceImpl implements CharacterService {

	@Autowired
	private CharacterRepository characterRepository;

	@Autowired
	private RaceRepository raceRepository;

	@Autowired
	private AbilityModifierRepository abilityModifierRepository;

	@Autowired
	private SubraceRepository subraceRepository;

	@Autowired
	private CharacterBackgroundRepository characterBackgroundRepository;

	public Character findCharacter(String characterName) {
		return characterRepository.findByName(characterName);
	}

	public Character createCharacter() {
		Character character = createBaseCharacter();
		characterRepository.save(character);

		CharacterRace characterRace = createCharacterRace(character);
		character.setCharacterRace(characterRace);

		CharacterSubrace characterSubrace = createCharacterSubrace(character);
		character.setCharacterSubrace(characterSubrace);

		CharacterDimension characterDimension = createCharacterDimension(character);
		character.setCharacterDimension(characterDimension);

		characterRepository.save(character);
		return character;
	}

	@Override
	public Character createCharacter(CharacterCreateForm form) {
		CharacterBackground criminalBackground = characterBackgroundRepository.findById(2);

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
		character.setCharacterBackground(criminalBackground);
		character.setPersonalCharacteristics(getPersonalCharacteristicsFromBackground(criminalBackground));
		characterRepository.save(character);

		CharacterRace characterRace = createCharacterRace(character);
		character.setCharacterRace(characterRace);

		CharacterSubrace characterSubrace = createCharacterSubrace(character);
		character.setCharacterSubrace(characterSubrace);

		CharacterDimension characterDimension = createCharacterDimension(character);
		character.setCharacterDimension(characterDimension);

		characterRepository.save(character);
		return character;
	}

	private Character createBaseCharacter() {
		CharacterBackground criminalBackground = characterBackgroundRepository.findById(2);

		Character character = new Character();
		character.setName("Grondal");
		character.setLevel(20);
		character.setHitPoints(200);
		character.setHitPointsCurrent(199);
		character.setWounds(1);
		character.setGender(Gender.MALE);
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
		character.setPersonalCharacteristics(getPersonalCharacteristicsFromBackground(criminalBackground));
		return character;
	}

	private CharacterDimension createCharacterDimension(Character character) {
		CharacterDimension characterDimension = new CharacterDimension();
		characterDimension.setCharacter(character);
		characterDimension.setFeets(6);
		characterDimension.setInches(0);
		characterDimension.setPounds(170);
		return characterDimension;
	}

	private CharacterRace createCharacterRace(Character character) {
		Race dwarf = raceRepository.findById(1);
		CharacterRace characterRace = new CharacterRace();
		characterRace.setCharacter(character);
		characterRace.setRace(dwarf);
		List<AbilityModifier> characterRaceAbilityModifiers = new ArrayList<>();
		for(AbilityModifier abilityModifier: dwarf.getRaceAbilityModifiers()) {
			AbilityModifier characterRaceAbilityModifier = new AbilityModifier();
			characterRaceAbilityModifier.setAbilityType(abilityModifier.getAbilityType());
			characterRaceAbilityModifier.setValue(abilityModifier.getValue());
			abilityModifierRepository.save(characterRaceAbilityModifier);
			characterRaceAbilityModifiers.add(characterRaceAbilityModifier);
		}
		characterRace.setAbilityModifiers(characterRaceAbilityModifiers);
		return characterRace;
	}

	private CharacterSubrace createCharacterSubrace(Character character) {
		Subrace hillDwarf = subraceRepository.findById(1);
		CharacterSubrace characterSubrace = new CharacterSubrace();
		characterSubrace.setCharacter(character);
		characterSubrace.setSubrace(hillDwarf);
		List<AbilityModifier> characterSubraceAbilityModifiers = new ArrayList<>();
		for(AbilityModifier abilityModifier: hillDwarf.getSubraceAbilityModifiers()) {
			AbilityModifier characterSubaceAbilityModifier = new AbilityModifier();
			characterSubaceAbilityModifier.setAbilityType(abilityModifier.getAbilityType());
			characterSubaceAbilityModifier.setValue(abilityModifier.getValue());
			abilityModifierRepository.save(characterSubaceAbilityModifier);
			characterSubraceAbilityModifiers.add(characterSubaceAbilityModifier);
		}
		characterSubrace.setAbilityModifiers(characterSubraceAbilityModifiers);
		return characterSubrace;
	}

	private List<PersonalCharacteristic> getPersonalCharacteristicsFromBackground(CharacterBackground characterBackground) {
		List<PersonalCharacteristic> personalCharacteristics = new ArrayList<>();
		personalCharacteristics.add(characterBackground.getTraits().get(0));
		personalCharacteristics.add(characterBackground.getIdeals().get(0));
		personalCharacteristics.add(characterBackground.getBonds().get(0));
		personalCharacteristics.add(characterBackground.getFlaws().get(0));
		return personalCharacteristics;
	}
}
