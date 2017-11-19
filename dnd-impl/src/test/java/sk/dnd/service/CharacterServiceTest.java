package sk.dnd.service;

import java.util.Collections;
import java.util.HashMap;
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
import sk.dnd.domain.character.CharacterBackground;
import sk.dnd.domain.character.CharacterBackgroundLocale;
import sk.dnd.domain.character.CharacterBackgroundRepository;
import sk.dnd.domain.character.CharacterRepository;
import sk.dnd.domain.character.Classification;
import sk.dnd.domain.character.ClassificationLocale;
import sk.dnd.domain.character.ClassificationRepository;
import sk.dnd.domain.character.support.Allignment;
import sk.dnd.domain.character.support.ClassificationType;
import sk.dnd.domain.character.support.RaceType;
import sk.dnd.domain.character.support.SubraceType;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
public class CharacterServiceTest {

	@Autowired
	private CharacterRepository characterRepository;

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
		character.setCharacterRace(RaceType.DWARF);
		character.setCharacterSubrace(SubraceType.DWARF_HILL);
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
		Character character = characterRepository.findByName("Grondal");
		Assert.assertNotNull(character);
	}
}
