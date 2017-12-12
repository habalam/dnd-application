package sk.dnd.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sk.dnd.domain.character.Character;
import sk.dnd.domain.character.*;
import sk.dnd.domain.character.race.AbilityModifier;
import sk.dnd.domain.character.race.AbilityModifierRepository;
import sk.dnd.domain.character.race.Race;
import sk.dnd.domain.character.race.RaceRepository;
import sk.dnd.domain.character.race.Subrace;
import sk.dnd.domain.character.race.SubraceRepository;
import sk.dnd.domain.character.support.Allignment;
import sk.dnd.domain.character.support.ClassificationType;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
public class CharacterServiceTest {

	@Autowired
	private CharacterRepository characterRepository;

	@Autowired
	private AbilityModifierRepository abilityModifierRepository;

	@Autowired
	private RaceRepository raceRepository;

	@Autowired
	private SubraceRepository subraceRepository;

	@Autowired
	private CharacterBackgroundRepository characterBackgroundRepository;

	@Autowired
	private ClassificationRepository classificationRepository;

	@Autowired
	private TestEntityManager entityManager;

	private Character character;

	@Before
	public void setUp() {
		/*Classification athleticsSkill = prepareClassification(ClassificationType.SKILL, new String[] {"en"},
			new String[] {"Athletics"}, new String[] {"Strength skill"});
		Classification elvishLanguage = prepareClassification(ClassificationType.LANGUAGE, new String[] {"en"},
			new String[] {"Elvish"}, new String[] {"Evish language"});
		CharacterBackground characterBackground = new CharacterBackground();
		characterBackground.setSkills(Collections.singletonList(athleticsSkill));
		characterBackground.setLanguagesCount(1);
		entityManager.persist(characterBackground);
		Map<String, CharacterBackgroundLocale> characterBackgroundLocales = createCharacterBackgroundLocales(characterBackground,
			new String[] {"en"}, new String[] {"Otlander"}, new String[] {"Outlander description"});
		characterBackground.setLocales(characterBackgroundLocales);*/

		CharacterBackground criminalBackground = characterBackgroundRepository.findById(2);

		character = new Character();
		character.setName("Grondal");
		character.setLevel(20);
		character.setHitPoints(200);
		character.setHitPointsCurrent(199);
		character.setWounds(1);
		character.setStrength(20);
		character.setDexterity(20);
		character.setConstitution(20);
		character.setWisdom(20);
		character.setIntelligence(20);
		character.setCharisma(20);
		character.setExperiencePoints(0);
		character.setGender(Gender.MALE);
		character.setAllignment(Allignment.GOOD_LAWFUL);
		character.setOrigin("Test origin");
		character.setInspired(true);
		character.setCharacterBackground(criminalBackground);
	}

	private Map<String, CharacterBackgroundLocale> createCharacterBackgroundLocales(CharacterBackground characterBackground, String[] langCodes,
		String[] names, String[] descriptions)
	{
		Map<String, CharacterBackgroundLocale> locales = new HashMap<>();
		for (int i = 0; i < langCodes.length; i++) {
			CharacterBackgroundLocale characterBackgroundLocale = new CharacterBackgroundLocale();
			characterBackgroundLocale.setCharacterBackground(characterBackground);
			characterBackgroundLocale.setLangCode(langCodes[i]);
			characterBackgroundLocale.setName(names[i]);
			characterBackgroundLocale.setDescription(descriptions[i]);
			entityManager.persist(characterBackgroundLocale);
			locales.put(langCodes[i], characterBackgroundLocale);
		}
		return locales;
	}

	private Classification prepareClassification(ClassificationType classificationType, String[] langCodes, String[] names,
		String[] descriptions)
	{
		Classification classification = new Classification();
		classification.setType(classificationType);
		entityManager.persist(classification);

		Map<String, ClassificationLocale> locales = new HashMap<>();
		for (int i = 0; i < langCodes.length; i++) {
			ClassificationLocale classificationLocale = new ClassificationLocale();
			classificationLocale.setClassification(classification);
			classificationLocale.setLangCode(langCodes[i]);
			classificationLocale.setName(names[i]);
			classificationLocale.setDescription(descriptions[i]);
			entityManager.persist(classificationLocale);
			locales.put(langCodes[i], classificationLocale);
		}
		classification.setLocales(locales);
		return classification;
	}

	@Test
	public void testCharacterRepositoryStoreCharacter() {
		characterRepository.save(character);

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
		character.setCharacterRace(characterRace);

		Subrace hillDwarf = subraceRepository.findById(1);
		CharacterSubrace characterSubrace = new CharacterSubrace();
		characterSubrace.setCharacter(character);
		characterSubrace.setSubrace(hillDwarf);
		character.setCharacterSubrace(characterSubrace);

		CharacterDimension characterDimension = new CharacterDimension();
		characterDimension.setCharacter(character);
		characterDimension.setFeets(6);
		characterDimension.setInches(0);
		characterDimension.setPounds(170);
		character.setCharacterDimension(characterDimension);
		characterRepository.save(character);

		Character character = characterRepository.findByName("Grondal");
		Assert.assertNotNull(character);
	}
}
