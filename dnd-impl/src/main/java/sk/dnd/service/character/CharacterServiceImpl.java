package sk.dnd.service.character;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.dnd.domain.character.Character;
import sk.dnd.domain.character.CharacterBackground;
import sk.dnd.domain.character.CharacterDimension;
import sk.dnd.domain.character.CharacterRace;
import sk.dnd.domain.character.CharacterRepository;
import sk.dnd.domain.character.CharacterSubrace;
import sk.dnd.domain.character.Classification;
import sk.dnd.domain.character.ClassificationLocale;
import sk.dnd.domain.character.ClassificationRepository;
import sk.dnd.domain.character.background.Background;
import sk.dnd.domain.character.background.BackgroundRepositoryCustom;
import sk.dnd.domain.character.race.AbilityModifier;
import sk.dnd.domain.character.race.AbilityModifierRepository;
import sk.dnd.domain.character.race.FeatureEffect;
import sk.dnd.domain.character.race.FeatureLocale;
import sk.dnd.domain.character.race.Race;
import sk.dnd.domain.character.race.RaceLocale;
import sk.dnd.domain.character.race.RaceRepositoryCustom;
import sk.dnd.domain.character.subrace.Subrace;
import sk.dnd.domain.character.subrace.SubraceLocale;
import sk.dnd.domain.character.subrace.SubracePhysiognomy;
import sk.dnd.domain.character.subrace.SubracePhysiognomyRepository;
import sk.dnd.domain.character.subrace.SubraceRepositoryCustom;
import sk.dnd.domain.character.support.ClassificationType;
import sk.dnd.service.character.jsonmapping.ClassificationLocaleJsonMapping;
import sk.dnd.service.character.jsonmapping.FeatureEffectJsonMapping;
import sk.dnd.service.character.jsonmapping.FeatureLocaleJsonMapping;
import sk.dnd.service.character.jsonmapping.RaceJsonMapping;
import sk.dnd.service.character.jsonmapping.RaceLocaleJsonMapping;
import sk.dnd.service.character.jsonmapping.SubraceJsonMapping;
import sk.dnd.service.character.jsonmapping.SubraceLocaleJsonMapping;
import sk.dnd.service.character.jsonmapping.SubracePhysiognomyJsonMapping;

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

	@Autowired
	private SubracePhysiognomyRepository subracePhysiognomyRepository;

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

	@Override
	public String racesListJsonsWithCurrentLocale(String currentLangCode) {
		List<Race> races = raceRepositoryCustom.listAllWithCurrentLocale(currentLangCode);
		ObjectMapper raceMapper = createRaceJsonMapper();
		try {
			return raceMapper.writeValueAsString(races);
		}
		catch (JsonProcessingException e) {
			//TODO spravit nejaku normalnu custom exception
			e.printStackTrace();
		}
		return null;
	}

	 private ObjectMapper createRaceJsonMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.addMixIn(FeatureLocale.class, FeatureLocaleJsonMapping.class);
		objectMapper.addMixIn(FeatureEffect.class, FeatureEffectJsonMapping.class);
		objectMapper.addMixIn(ClassificationLocale.class, ClassificationLocaleJsonMapping.class);
		objectMapper.addMixIn(RaceLocale.class, RaceLocaleJsonMapping.class);
		objectMapper.addMixIn(Race.class, RaceJsonMapping.class);
		return objectMapper;
	}

	@Override
	public String listSubracesListJsonByRaceWithCurrentLocale(Integer raceId, String currentLangCode) {
		List<Subrace> subraces = subraceRepositoryCustom.listSubracesForRaceWithCurrentLocale(raceId, currentLangCode);
		ObjectMapper objectMapper = createSubraceJsonMapper();
		try {
			return objectMapper.writeValueAsString(subraces);
		}
		catch (JsonProcessingException e) {
			//TODO spravit nejakú normálnu custom exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getSubracePhysiognomyJson(Integer subraceId) {
		SubracePhysiognomy subracePhysiognomy = subracePhysiognomyRepository.findById(subraceId);
		ObjectMapper objectMapper = createSubracePhysiognomyJsonMapper();
		try {
			return objectMapper.writeValueAsString(subracePhysiognomy);
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	private ObjectMapper createSubracePhysiognomyJsonMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.addMixIn(SubracePhysiognomy.class, SubracePhysiognomyJsonMapping.class);
		return objectMapper;
	}

	private ObjectMapper createSubraceJsonMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.addMixIn(SubraceLocale.class, SubraceLocaleJsonMapping.class);
		objectMapper.addMixIn(FeatureLocale.class, FeatureLocaleJsonMapping.class);
		objectMapper.addMixIn(FeatureEffect.class, FeatureEffectJsonMapping.class);
		objectMapper.addMixIn(ClassificationLocale.class, ClassificationLocaleJsonMapping.class);
		objectMapper.addMixIn(SubracePhysiognomy.class, SubracePhysiognomyJsonMapping.class);
		objectMapper.addMixIn(Subrace.class, SubraceJsonMapping.class);
		return objectMapper;
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
