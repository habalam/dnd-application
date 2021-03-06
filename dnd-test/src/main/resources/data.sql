--TODO doplnit inicializacne sql scripty (Classifications, ...)
-- Classifications
insert into dnd_classification (dnd_classification_id, type) values(1, 'SKILL');
insert into dnd_classification (dnd_classification_id, type) values(2, 'SKILL');
insert into dnd_classification (dnd_classification_id, type) values(3, 'SKILL');
insert into dnd_classification (dnd_classification_id, type) values(4, 'SKILL');
insert into dnd_classification (dnd_classification_id, type) values(5, 'SKILL');
insert into dnd_classification (dnd_classification_id, type) values(6, 'SKILL');
insert into dnd_classification (dnd_classification_id, type) values(7, 'SKILL');
insert into dnd_classification (dnd_classification_id, type) values(8, 'SKILL');
insert into dnd_classification (dnd_classification_id, type) values(9, 'SKILL');
insert into dnd_classification (dnd_classification_id, type) values(10, 'SKILL');
insert into dnd_classification (dnd_classification_id, type) values(11, 'SKILL');
insert into dnd_classification (dnd_classification_id, type) values(12, 'SKILL');
insert into dnd_classification (dnd_classification_id, type) values(13, 'SKILL');
insert into dnd_classification (dnd_classification_id, type) values(14, 'SKILL');
insert into dnd_classification (dnd_classification_id, type) values(15, 'SKILL');
insert into dnd_classification (dnd_classification_id, type) values(16, 'SKILL');
insert into dnd_classification (dnd_classification_id, type) values(17, 'SKILL');
insert into dnd_classification (dnd_classification_id, type) values(18, 'SKILL');
insert into dnd_classification (dnd_classification_id, type) values(19, 'LANGUAGE');
insert into dnd_classification (dnd_classification_id, type) values(20, 'LANGUAGE');
insert into dnd_classification (dnd_classification_id, type) values(21, 'LANGUAGE');
insert into dnd_classification (dnd_classification_id, type) values(22, 'LANGUAGE');
insert into dnd_classification (dnd_classification_id, type) values(23, 'LANGUAGE');
insert into dnd_classification (dnd_classification_id, type) values(24, 'LANGUAGE');
insert into dnd_classification (dnd_classification_id, type) values(25, 'LANGUAGE');
insert into dnd_classification (dnd_classification_id, type) values(26, 'LANGUAGE');
insert into dnd_classification (dnd_classification_id, type) values(27, 'LANGUAGE');
insert into dnd_classification (dnd_classification_id, type) values(28, 'LANGUAGE');
insert into dnd_classification (dnd_classification_id, type) values(29, 'LANGUAGE');
insert into dnd_classification (dnd_classification_id, type) values(30, 'LANGUAGE');
insert into dnd_classification (dnd_classification_id, type) values(31, 'LANGUAGE');
insert into dnd_classification (dnd_classification_id, type) values(32, 'LANGUAGE');
insert into dnd_classification (dnd_classification_id, type) values(33, 'LANGUAGE');
insert into dnd_classification (dnd_classification_id, type) values(34, 'LANGUAGE');
insert into dnd_classification (dnd_classification_id, type) values(35, 'LANGUAGE');
insert into dnd_classification (dnd_classification_id, type) values(36, 'DMG_TYPE');
insert into dnd_classification (dnd_classification_id, type) values(37, 'RESISTENCE');
insert into dnd_classification (dnd_classification_id, type) values(38, 'WEAPON_TYPE');
insert into dnd_classification (dnd_classification_id, type) values(39, 'WEAPON_TYPE');
insert into dnd_classification (dnd_classification_id, type) values(40, 'WEAPON_TYPE');
insert into dnd_classification (dnd_classification_id, type) values(41, 'WEAPON_TYPE');
insert into dnd_classification (dnd_classification_id, type) values(42, 'TOOL');
insert into dnd_classification (dnd_classification_id, type) values(43, 'TOOL');
insert into dnd_classification (dnd_classification_id, type) values(44, 'TOOL');
insert into dnd_classification (dnd_classification_id, type) values(45, 'ARMOR_TYPE');
insert into dnd_classification (dnd_classification_id, type) values(46, 'ARMOR_TYPE');

insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (1, 'en', 'Athletics', 'Your Strength (Athletics) check covers difficult situations you encounter while climbing, jumping, or swimming. Examples include the following activities: • You attempt to climb a sheer or slippery cliff, avoid hazards while scaling a wall, or cling to a surface while something is trying to knock you off. • You try to jump an unusually long distance or pull off a stunt midjump. • You struggle to swim or stay afloat in treacherous currents, storm-tossed waves, or areas of thick seaweed. Or another creature tries to push or pull you underwater or otherwise interfere with your swimming.');
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (2, 'en', 'Acrobatics', 'Your Dexterity (Acrobatics) check covers your attempt to stay on your feet in a tricky situation, such as when you’re trying to run across a sheet of ice, balance on a tightrope, or stay upright on a rocking ship’s deck. The DM might also call for a Dexterity (Acrobatics) check to see if you can perform acrobatic stunts, including dives, rolls, somersaults, and flips.');
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (3, 'en', 'Sleight of Hand', 'Whenever you attempt an act of legerdemain or manual trickery, such as planting something on someone else or concealing an object on your person, make a Dexterity (Sleight of Hand) check. The DM might also call for a Dexterity (Sleight of Hand) check to determine whether you can lift a coin purse off another person or slip something out of another person’s pocket.');
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (4, 'en', 'Stealth', 'Make a Dexterity (Stealth) check when you attempt to conceal yourself from enemies, slink past guards, slip away without being noticed, or sneak up on someone without being seen or heard.');
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (5, 'en', 'Arcana', 'Your Intelligence (Arcana) check measures your ability to recall lore about spells, magic items, eldritch symbols, magical traditions, the planes of existence, and the inhabitants of those planes.');
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (6, 'en', 'History', 'Your Intelligence (History) check measures your ability to recall lore about historical events, legendary people, ancient kingdoms, past disputes, recent wars, and lost civilizations.');
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (7, 'en', 'Investigation', 'When you look around for clues and make deductions based on those clues, you make an Intelligence (Investigation) check. You might deduce the location of a hidden object, discern from the appearance of a wound what kind of weapon dealt it, or determine the weakest point in a tunnel that could cause it to collapse. Poring through ancient scrolls in search of a hidden fragment of knowledge might also call for an Intelligence (Investigation) check.');
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (8, 'en', 'Nature', 'Your Intelligence (Nature) check measures your ability to recall lore about terrain, plants and animals, the weather, and natural cycles.');
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (9, 'en', 'Religion', 'Your Intelligence (Religion) check measures your ability to recall lore about deities, rites and prayers, religious hierarchies, holy symbols, and the practices of secret cults.');
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (10, 'en', 'Animal Handling', 'When there is any question whether you can calm down a domesticated animal, keep a mount from getting spooked, or intuit an animal’s intentions, the DM might call for a Wisdom (Animal Handling) check. You also make a Wisdom (Animal Handling) check to control your mount when you attempt a risky maneuver');
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (11, 'en', 'Insight', 'Your Wisdom (Insight) check decides whether you can determine the true intentions of a creature, such as when searching out a lie or predicting someone’s next move. Doing so involves gleaning clues from body language, speech habits, and changes in mannerisms.');
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (12, 'en', 'Medicine', 'A Wisdom (Medicine) check lets you try to stabilize a dying companion or diagnose an illness.');
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (13, 'en', 'Perception', 'Your Wisdom (Perception) check lets you spot, hear, or otherwise detect the presence of something. It measures your general awareness of your surroundings and the keenness of your senses. For example, you might try to hear a conversation through a closed door, eavesdrop under an open window, or hear monsters moving stealthily in the forest. Or you might try to spot things that are obscured or easy to miss, whether they are orcs lying in ambush on a road, thugs hiding in the shadows of an alley, or candlelight under a closed secret door.');
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (14, 'en', 'Survival', 'The DM might ask you to make a Wisdom (Survival) check to follow tracks, hunt wild game, guide your group through frozen wastelands, identify signs that owlbears live nearby, predict the weather, or avoid quicksand and other natural hazards.');
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (15, 'en', 'Deception', 'Your Charisma (Deception) check determines whether you can convincingly hide the truth, either verbally or through your actions. This deception can encompass everything from misleading others through ambiguity to telling outright lies. Typical situations include trying to fast-talk a guard, con a merchant, earn money through gambling, pass yourself off in a disguise, dull someone’s suspicions with false assurances, or maintain a straight face while telling a blatant lie.');
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (16, 'en', 'Intimidation', 'When you attempt to influence someone through overt threats, hostile actions, and physical violence, the DM might ask you to make a Charisma (Intimidation) check. Examples include trying to pry information out of a prisoner, convincing street thugs to back down from a confrontation, or using the edge of a broken bottle to convince a sneering vizier to reconsider a decision.');
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (17, 'en', 'Performance', 'Your Charisma (Performance) check determines how well you can delight an audience with music, dance, acting, storytelling, or some other form of entertainment.');
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (18, 'en', 'Persuasion', 'When you attempt to influence someone or a group of people with tact, social graces, or good nature, the DM might ask you to make a Charisma (Persuasion) check. Typically, you use persuasion when acting in good faith, to foster friendships, make cordial requests, or exhibit proper etiquette. Examples of persuading others include convincing a chamberlain to let your party see the king, negotiating peace between warring tribes, or inspiring a crowd of townsfolk.');
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (19, 'en', 'Common', null);
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (20, 'en', 'Dwarvish', null);
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (21, 'en', 'Elvish', null);
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (22, 'en', 'Giant', null);
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (23, 'en', 'Gnomish', null);
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (24, 'en', 'Goblin', null);
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (25, 'en', 'Halfling', null);
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (26, 'en', 'Orc', null);
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (27, 'en', 'Abyssal', null);
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (28, 'en', 'Celestial', null);
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (29, 'en', 'Draconic', null);
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (30, 'en', 'Deep Speech', null);
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (31, 'en', 'Infernal', null);
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (32, 'en', 'Primordial', null);
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (33, 'en', 'Sylvan', null);
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (34, 'en', 'Undercommon', null);
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (35, 'en', 'ANY', null);
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (36, 'en', 'Poison', null);
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (37, 'en', 'Poison', null);
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (38, 'en', 'Battleaxe', null);
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (39, 'en', 'Handaxe', null);
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (40, 'en', 'Throwing hammer', null);
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (41, 'en', 'Warhammer', null);
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (42, 'en', 'Smith''s tools', null);
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (43, 'en', 'Brewer''s supplies', null);
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (44, 'en', 'Mason'' tools', null);
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (45, 'en', 'Light armor', null);
insert into dnd_classification_l (dnd_classification_id, lang_code, name, description) values (46, 'en', 'Medium armor', null);

-- Personal Characteristics
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (1, 'PERSONALITY_TRAIT');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (2, 'PERSONALITY_TRAIT');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (3, 'PERSONALITY_TRAIT');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (4, 'PERSONALITY_TRAIT');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (5, 'PERSONALITY_TRAIT');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (6, 'PERSONALITY_TRAIT');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (7, 'PERSONALITY_TRAIT');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (8, 'PERSONALITY_TRAIT');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (9, 'IDEAL');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (10, 'IDEAL');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (11, 'IDEAL');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (12, 'IDEAL');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (13, 'IDEAL');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (14, 'IDEAL');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (15, 'BOND');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (16, 'BOND');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (17, 'BOND');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (18, 'BOND');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (19, 'BOND');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (20, 'BOND');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (21, 'FLAW');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (22, 'FLAW');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (23, 'FLAW');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (24, 'FLAW');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (25, 'FLAW');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (26, 'FLAW');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (27, 'PERSONALITY_TRAIT');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (28, 'PERSONALITY_TRAIT');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (29, 'PERSONALITY_TRAIT');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (30, 'PERSONALITY_TRAIT');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (31, 'PERSONALITY_TRAIT');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (32, 'PERSONALITY_TRAIT');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (33, 'PERSONALITY_TRAIT');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (34, 'PERSONALITY_TRAIT');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (35, 'IDEAL');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (36, 'IDEAL');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (37, 'IDEAL');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (38, 'IDEAL');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (39, 'IDEAL');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (40, 'IDEAL');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (41, 'BOND');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (42, 'BOND');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (43, 'BOND');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (44, 'BOND');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (45, 'BOND');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (46, 'BOND');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (47, 'FLAW');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (48, 'FLAW');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (49, 'FLAW');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (50, 'FLAW');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (51, 'FLAW');
insert into DND_PERSONAL_CHARACTERISTIC (dnd_personal_characteristic_id, type) values (52, 'FLAW');

insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (1, 'en', null, 'I dolize a particular hero of my faith, and constantly refer to that person`s deeds and example.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (2, 'en', null, 'I can find common ground between the fiercest enemies, empathizing with them and always working toward peace.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (3, 'en', null, 'I see omens in every event and action. The gods try to speak to us, we just need to listen.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (4, 'en', null, 'Nothing can shake my optimistic attitude.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (5, 'en', null, 'I quote (or misquote) sacred texts and proverbs in almost every situation.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (6, 'en', null, 'I am tolerant (or intolerant) of other faiths and respect (or condemn) the worship of other gods.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (7, 'en', null, 'I’ve enjoyed fine food, drink, and high society among my temple’s elite. Rough living grates on me.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (8, 'en', null, 'I’ve spent so long in the temple that I have little practical experience dealing with people in the outside world.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (9, 'en', 'Tradition', 'The ancient traditions of worship and sacrifice must be preserved and upheld. (Lawful)');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (10, 'en', 'Charity', 'I always try to help those in need, no matter what the personal cost. (Good)');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (11, 'en', 'Change', 'We must help bring about the changes the gods are constantly working in the world. (Chaotic)');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (12, 'en', 'Power', 'I hope to one day rise to the top of my faith’s religious hierarchy. (Lawful)');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (13, 'en', 'Faith', 'I trust that my deity will guide my actions. I have faith that if I work hard, things will go well. (Lawful)');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (14, 'en', 'Aspiration', 'I seek to prove myself worthy of my god’s favor by matching my actions against his or her teachings. (Any)');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (15, 'en', null, 'I would die to recover an ancient relic of my faith that was lost long ago.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (16, 'en', null, 'I will someday get revenge on the corrupt temple hierarchy who branded me a heretic.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (17, 'en', null, 'I owe my life to the priest who took me in when my parents died.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (18, 'en', null, 'Everything I do is for the common people.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (19, 'en', null, 'I will do anything to protect the temple where I served.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (20, 'en', null, 'I seek to preserve a sacred text that my enemies consider heretical and seek to destroy.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (21, 'en', null, 'I judge others harshly, and myself even more severely.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (22, 'en', null, 'I put too much trust in those who wield power within my temple’s hierarchy.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (23, 'en', null, 'My piety sometimes leads me to blindly trust those that profess faith in my god.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (24, 'en', null, 'I am inflexible in my thinking.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (25, 'en', null, 'I am suspicious of strangers and expect the worst of them.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (26, 'en', null, 'Once I pick a goal, I become obsessed with it to the detriment of everything else in my life.');

insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (27, 'en', null, 'I always have a plan for what to do when things go wrong.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (28, 'en', null, 'I am always calm, no matter what the situation. I never raise my voice or let my emotions control me.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (29, 'en', null, 'The first thing I do in a new place is note the locations of everything valuable—or where such things could be hidden.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (30, 'en', null, 'I would rather make a new friend than a new enemy.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (31, 'en', null, 'I am incredibly slow to trust. Those who seem the fairest often have the most to hide.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (32, 'en', null, 'I don’t pay attention to the risks in a situation. Never tell me the odds.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (33, 'en', null, 'The best way to get me to do something is to tell me I can’t do it.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (34, 'en', null, 'I blow up at the slightest insult.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (35, 'en', 'Honor', 'I don’t steal from others in the trade. (Lawful)');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (36, 'en', 'Freedom', 'Chains are meant to be broken, as are those who would forge them. (Chaotic)');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (37, 'en', 'Charity', 'I steal from the wealthy so that I can help people in need. (Good)');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (38, 'en', 'Greed', 'I will do whatever it takes to become wealthy. (Evil)');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (39, 'en', 'People', 'I’m loyal to my friends, not to any ideals, and everyone else can take a trip down the Styx for all I care. (Neutral)');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (40, 'en', 'Redemption', 'There’s a spark of good in everyone. (Good)');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (41, 'en', null, 'I’m trying to pay off an old debt I owe to a generous benefactor.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (42, 'en', null, 'My ill-gotten gains go to support my family.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (43, 'en', null, 'Something important was taken from me, and I aim to steal it back.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (44, 'en', null, 'I will become the greatest thief that ever lived.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (45, 'en', null, 'I’m guilty of a terrible crime. I hope I can redeem myself for it.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (46, 'en', null, 'Someone I loved died because of I mistake I made. That will never happen again.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (47, 'en', null, 'When I see something valuable, I can’t think about anything but how to steal it.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (48, 'en', null, 'When faced with a choice between money and my friends, I usually choose the money.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (49, 'en', null, 'If there’s a plan, I’ll forget it. If I don’t forget it, I’ll ignore it.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (50, 'en', null, 'I have a “tell” that reveals when I’m lying.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (51, 'en', null, 'I turn tail and run when things look bad.');
insert into DND_PERSONAL_CHARACTERISTIC_L (dnd_personal_characteristic_id, lang_code, name, description) values (52, 'en', null, 'An innocent person is in prison for a crime that I committed. I’m okay with that.');

-- Backgrounds
insert into dnd_background (dnd_background_id, languages_count) values (1, 2);
insert into dnd_background (dnd_background_id, languages_count) values (2, 0);
--insert into dnd_background (dnd_background_id) values (3);
--insert into dnd_background (dnd_background_id) values (4);
--insert into dnd_background (dnd_background_id) values (5);
--insert into dnd_background (dnd_background_id) values (6);
--insert into dnd_background (dnd_background_id) values (7);
--insert into dnd_background (dnd_background_id) values (8);
--insert into dnd_background (dnd_background_id) values (9);
--insert into dnd_background (dnd_background_id) values (10);
--insert into dnd_background (dnd_background_id) values (11);
--insert into dnd_background (dnd_background_id) values (12);
--insert into dnd_background (dnd_background_id) values (13);

insert into DND_BACKGROUND_SKILL (dnd_background_id, dnd_classification_id) values (1, 9);
insert into DND_BACKGROUND_SKILL (dnd_background_id, dnd_classification_id) values (1, 11);
insert into DND_BACKGROUND_TRAIT (dnd_background_id, dnd_personal_characteristic_id) values (1, 1);
insert into DND_BACKGROUND_TRAIT (dnd_background_id, dnd_personal_characteristic_id) values (1, 2);
insert into DND_BACKGROUND_TRAIT (dnd_background_id, dnd_personal_characteristic_id) values (1, 3);
insert into DND_BACKGROUND_TRAIT (dnd_background_id, dnd_personal_characteristic_id) values (1, 4);
insert into DND_BACKGROUND_TRAIT (dnd_background_id, dnd_personal_characteristic_id) values (1, 5);
insert into DND_BACKGROUND_TRAIT (dnd_background_id, dnd_personal_characteristic_id) values (1, 6);
insert into DND_BACKGROUND_TRAIT (dnd_background_id, dnd_personal_characteristic_id) values (1, 7);
insert into DND_BACKGROUND_TRAIT (dnd_background_id, dnd_personal_characteristic_id) values (1, 8);
insert into DND_BACKGROUND_IDEAL (dnd_background_id, dnd_personal_characteristic_id) values (1, 9);
insert into DND_BACKGROUND_IDEAL (dnd_background_id, dnd_personal_characteristic_id) values (1, 10);
insert into DND_BACKGROUND_IDEAL (dnd_background_id, dnd_personal_characteristic_id) values (1, 11);
insert into DND_BACKGROUND_IDEAL (dnd_background_id, dnd_personal_characteristic_id) values (1, 12);
insert into DND_BACKGROUND_IDEAL (dnd_background_id, dnd_personal_characteristic_id) values (1, 13);
insert into DND_BACKGROUND_IDEAL (dnd_background_id, dnd_personal_characteristic_id) values (1, 14);
insert into DND_BACKGROUND_BOND (dnd_background_id, dnd_personal_characteristic_id) values (1, 15);
insert into DND_BACKGROUND_BOND (dnd_background_id, dnd_personal_characteristic_id) values (1, 16);
insert into DND_BACKGROUND_BOND (dnd_background_id, dnd_personal_characteristic_id) values (1, 17);
insert into DND_BACKGROUND_BOND (dnd_background_id, dnd_personal_characteristic_id) values (1, 18);
insert into DND_BACKGROUND_BOND (dnd_background_id, dnd_personal_characteristic_id) values (1, 19);
insert into DND_BACKGROUND_BOND (dnd_background_id, dnd_personal_characteristic_id) values (1, 20);
insert into DND_BACKGROUND_FLAW (dnd_background_id, dnd_personal_characteristic_id) values (1, 21);
insert into DND_BACKGROUND_FLAW (dnd_background_id, dnd_personal_characteristic_id) values (1, 22);
insert into DND_BACKGROUND_FLAW (dnd_background_id, dnd_personal_characteristic_id) values (1, 23);
insert into DND_BACKGROUND_FLAW (dnd_background_id, dnd_personal_characteristic_id) values (1, 24);
insert into DND_BACKGROUND_FLAW (dnd_background_id, dnd_personal_characteristic_id) values (1, 25);
insert into DND_BACKGROUND_FLAW (dnd_background_id, dnd_personal_characteristic_id) values (1, 26);

insert into DND_BACKGROUND_SKILL (dnd_background_id, dnd_classification_id) values (2, 15);
insert into DND_BACKGROUND_SKILL (dnd_background_id, dnd_classification_id) values (2, 4);
insert into DND_BACKGROUND_TRAIT (dnd_background_id, dnd_personal_characteristic_id) values (2, 27);
insert into DND_BACKGROUND_TRAIT (dnd_background_id, dnd_personal_characteristic_id) values (2, 28);
insert into DND_BACKGROUND_TRAIT (dnd_background_id, dnd_personal_characteristic_id) values (2, 29);
insert into DND_BACKGROUND_TRAIT (dnd_background_id, dnd_personal_characteristic_id) values (2, 30);
insert into DND_BACKGROUND_TRAIT (dnd_background_id, dnd_personal_characteristic_id) values (2, 31);
insert into DND_BACKGROUND_TRAIT (dnd_background_id, dnd_personal_characteristic_id) values (2, 32);
insert into DND_BACKGROUND_TRAIT (dnd_background_id, dnd_personal_characteristic_id) values (2, 33);
insert into DND_BACKGROUND_TRAIT (dnd_background_id, dnd_personal_characteristic_id) values (2, 34);
insert into DND_BACKGROUND_IDEAL (dnd_background_id, dnd_personal_characteristic_id) values (2, 35);
insert into DND_BACKGROUND_IDEAL (dnd_background_id, dnd_personal_characteristic_id) values (2, 36);
insert into DND_BACKGROUND_IDEAL (dnd_background_id, dnd_personal_characteristic_id) values (2, 37);
insert into DND_BACKGROUND_IDEAL (dnd_background_id, dnd_personal_characteristic_id) values (2, 38);
insert into DND_BACKGROUND_IDEAL (dnd_background_id, dnd_personal_characteristic_id) values (2, 39);
insert into DND_BACKGROUND_IDEAL (dnd_background_id, dnd_personal_characteristic_id) values (2, 40);
insert into DND_BACKGROUND_BOND (dnd_background_id, dnd_personal_characteristic_id) values (2, 41);
insert into DND_BACKGROUND_BOND (dnd_background_id, dnd_personal_characteristic_id) values (2, 42);
insert into DND_BACKGROUND_BOND (dnd_background_id, dnd_personal_characteristic_id) values (2, 43);
insert into DND_BACKGROUND_BOND (dnd_background_id, dnd_personal_characteristic_id) values (2, 44);
insert into DND_BACKGROUND_BOND (dnd_background_id, dnd_personal_characteristic_id) values (2, 45);
insert into DND_BACKGROUND_BOND (dnd_background_id, dnd_personal_characteristic_id) values (2, 46);
insert into DND_BACKGROUND_FLAW (dnd_background_id, dnd_personal_characteristic_id) values (2, 47);
insert into DND_BACKGROUND_FLAW (dnd_background_id, dnd_personal_characteristic_id) values (2, 48);
insert into DND_BACKGROUND_FLAW (dnd_background_id, dnd_personal_characteristic_id) values (2, 49);
insert into DND_BACKGROUND_FLAW (dnd_background_id, dnd_personal_characteristic_id) values (2, 50);
insert into DND_BACKGROUND_FLAW (dnd_background_id, dnd_personal_characteristic_id) values (2, 51);
insert into DND_BACKGROUND_FLAW (dnd_background_id, dnd_personal_characteristic_id) values (2, 52);

insert into DND_BACKGROUND_L (dnd_background_id, lang_code, name, description, feature_name, feature_description) values (1, 'en', 'Acolyte', 'You have spent your life in the service of a temple to a specific god or pantheon of gods. You act as an intermediary between the realm of the holy and the mortal world, performing sacred rites and offering sacrifices in order to conduct worshipers into the presence of the divine. You are not necessarily a cleric—performing sacred rites is not the same thing as channeling divine power. Choose a god, a pantheon of gods, or some other quasidivine being, and work with your DM to detail the nature of your religious service. Appendix B contains a sample pantheon, from the Forgotten Realms setting. Were you a lesser functionary in a temple, raised from childhood to assist the priests in the sacred rites? Or were you a high priest who suddenly experienced a call to serve your god in a different way? Perhaps you were the leader of a small cult outside of any established temple structure, or even an occult group that served a fiendish master that you now deny.', 'Shelter of the Faithful', 'As an acolyte, you command the respect of those who share your faith, and you can perform the religious ceremonies of your deity. You and your adventuring companions can expect to receive free healing and care at a temple, shrine, or other established presence of your faith, though you must provide any material components needed for spells. Those who share your religion will support you (but only you) at a modest lifestyle. You might also have ties to a specific temple dedicated to your chosen deity or pantheon, and you have a residence there. This could be the temple where you used to serve, if you remain on good terms with it, or a temple where you have found a new home. While near your temple, you can call upon the priests for assistance, provided the assistance you ask for is not hazardous and you remain in good standing with your temple.');
insert into DND_BACKGROUND_L (dnd_background_id, lang_code, name, description, feature_name, feature_description) values (1, 'sk', 'Akolyta', 'You have spent your life in the service of a temple to a specific god or pantheon of gods. You act as an intermediary between the realm of the holy and the mortal world, performing sacred rites and offering sacrifices in order to conduct worshipers into the presence of the divine. You are not necessarily a cleric—performing sacred rites is not the same thing as channeling divine power. Choose a god, a pantheon of gods, or some other quasidivine being, and work with your DM to detail the nature of your religious service. Appendix B contains a sample pantheon, from the Forgotten Realms setting. Were you a lesser functionary in a temple, raised from childhood to assist the priests in the sacred rites? Or were you a high priest who suddenly experienced a call to serve your god in a different way? Perhaps you were the leader of a small cult outside of any established temple structure, or even an occult group that served a fiendish master that you now deny.', 'Shelter of the Faithful', 'As an acolyte, you command the respect of those who share your faith, and you can perform the religious ceremonies of your deity. You and your adventuring companions can expect to receive free healing and care at a temple, shrine, or other established presence of your faith, though you must provide any material components needed for spells. Those who share your religion will support you (but only you) at a modest lifestyle. You might also have ties to a specific temple dedicated to your chosen deity or pantheon, and you have a residence there. This could be the temple where you used to serve, if you remain on good terms with it, or a temple where you have found a new home. While near your temple, you can call upon the priests for assistance, provided the assistance you ask for is not hazardous and you remain in good standing with your temple.');
insert into DND_BACKGROUND_L (dnd_background_id, lang_code, name, description, feature_name, feature_description) values (2, 'en', 'Criminal', 'You are an experienced criminal with a history of breaking the law. You have spent a lot of time among other criminals and still have contacts within the criminal underworld. You’re far closer than most people to the world of murder, theft, and violence that pervades the underbelly of civilization, and you have survived up to this point by flouting the rules and regulations of society', 'Criminal Contact', 'You have a reliable and trustworthy contact who acts as your liaison to a network of other criminals. You know how to get messages to and from your contact, even over great distances; specifically, you know the local messengers, corrupt caravan masters, and seedy sailors who can deliver messages for you.');
insert into DND_BACKGROUND_L (dnd_background_id, lang_code, name, description, feature_name, feature_description) values (2, 'sk', 'Zločinec', 'You are an experienced criminal with a history of breaking the law. You have spent a lot of time among other criminals and still have contacts within the criminal underworld. You’re far closer than most people to the world of murder, theft, and violence that pervades the underbelly of civilization, and you have survived up to this point by flouting the rules and regulations of society', 'Criminal Contact', 'You have a reliable and trustworthy contact who acts as your liaison to a network of other criminals. You know how to get messages to and from your contact, even over great distances; specifically, you know the local messengers, corrupt caravan masters, and seedy sailors who can deliver messages for you.');

-- CharacterBackground specialities
insert into DND_BACKGROUND_SPECIALITY (DND_BACKGROUND_SPECIALITY_ID, dnd_background_id, lang_code, name, description) values (1, 2, 'en', 'Criminal Speciality', 'There are many kinds of criminals, and within a thieves’ guild or similar criminal organization, individual members have particular specialties. Even criminals who operate outside of such organizations have strong preferences for certain kinds of crimes over others. Choose the role you played in your criminal life, or roll on the table below.');

insert into DND_BACKGROUND_SPECIALITY_VALUE (dnd_background_speciality_id, value) values (1, 'Blackmailer');
insert into DND_BACKGROUND_SPECIALITY_VALUE (dnd_background_speciality_id, value) values (1, 'Burglar');
insert into DND_BACKGROUND_SPECIALITY_VALUE (dnd_background_speciality_id, value) values (1, 'Enforcer');
insert into DND_BACKGROUND_SPECIALITY_VALUE (dnd_background_speciality_id, value) values (1, 'Fence');
insert into DND_BACKGROUND_SPECIALITY_VALUE (dnd_background_speciality_id, value) values (1, 'Highway robber');
insert into DND_BACKGROUND_SPECIALITY_VALUE (dnd_background_speciality_id, value) values (1, 'Hired killer');
insert into DND_BACKGROUND_SPECIALITY_VALUE (dnd_background_speciality_id, value) values (1, 'Pickpocket');
insert into DND_BACKGROUND_SPECIALITY_VALUE (dnd_background_speciality_id, value) values (1, 'Smuggler');

-- Ability modifiers
insert into DND_ABILITY_MODIFIER (dnd_ability_modifier_id, ability_type, value) values (1, 'CONSTITUTION', 2);
insert into DND_ABILITY_MODIFIER (dnd_ability_modifier_id, ability_type, value) values (2, 'WISDOM', 1);
insert into DND_ABILITY_MODIFIER (dnd_ability_modifier_id, ability_type, value) values (3, 'STRENGTH', 2);

insert into DND_FEATURE_EFFECT_CLASSIFICATION (dnd_feature_effect_id, dnd_classification_id) values (1, 36);
insert into DND_FEATURE_EFFECT_CLASSIFICATION (dnd_feature_effect_id, dnd_classification_id) values (2, 37);
insert into DND_FEATURE_EFFECT_CLASSIFICATION (dnd_feature_effect_id, dnd_classification_id) values (3, 38);
insert into DND_FEATURE_EFFECT_CLASSIFICATION (dnd_feature_effect_id, dnd_classification_id) values (3, 39);
insert into DND_FEATURE_EFFECT_CLASSIFICATION (dnd_feature_effect_id, dnd_classification_id) values (3, 40);
insert into DND_FEATURE_EFFECT_CLASSIFICATION (dnd_feature_effect_id, dnd_classification_id) values (3, 41);
insert into DND_FEATURE_EFFECT_CLASSIFICATION (dnd_feature_effect_id, dnd_classification_id) values (4, 42);
insert into DND_FEATURE_EFFECT_CLASSIFICATION (dnd_feature_effect_id, dnd_classification_id) values (4, 43);
insert into DND_FEATURE_EFFECT_CLASSIFICATION (dnd_feature_effect_id, dnd_classification_id) values (4, 44);
insert into DND_FEATURE_EFFECT_CLASSIFICATION (dnd_feature_effect_id, dnd_classification_id) values (5, 6);
insert into DND_FEATURE_EFFECT_CLASSIFICATION (dnd_feature_effect_id, dnd_classification_id) values (7, 45);
insert into DND_FEATURE_EFFECT_CLASSIFICATION (dnd_feature_effect_id, dnd_classification_id) values (7, 46);

-- RACES
-- Dwarf
insert into DND_RACE (dnd_race_id, size, speed, darkvision) values (1, 'MEDIUM', 25, 'Y');

insert into DND_RACE_L (dnd_race_id, lang_code, name, age, alignment, size, description) values (1, 'en', 'Dwarf', 'Dwarves mature at the same rate as humans, but they’re considered young until they reach the age of 50. On average, they live about 350 years.',
'Most dwarves are lawful, believing firmly in the benefits of a well-ordered society. They tend toward good as well, with a strong sense of fair play and a belief that everyone deserves to share in the benefits of a just order.',
' Dwarves stand between 4 and 5 feet tall and average about 150 pounds.',
'Test description');
insert into DND_RACE_L (dnd_race_id, lang_code, name, age, alignment, size, description) values (1, 'sk', 'Trpaslík',
'Trpaslíci dospievajú v rovnakom veku ako ľudia, ale za maladých sú považovaný kým nedosiahnu 50 rokov. V priemere sa dožívajú okolo 350 rokov.',
'Väčšina trpaslíkov je zákonná, pevne veriaca vo výhody dobre organizovanej spoločnosti. Rovnako tiahnu k dobru, so silným zmyslom pre fair play a vierov, že každý si zaslúži zdielať výhody spravodlivého poriadku.',
'Trpaslíci merajú medzi 4 a 5 stomapy a priemerne vážia okolo 150 libier.',
'Test description');

insert into DND_RACE_ABILITY_MODIFIER (dnd_race_id, dnd_ability_modifier_id) values (1, 1);
insert into DND_RACE_LANGUAGE (dnd_race_id, dnd_classification_id) values (1, 20);

insert into DND_FEATURE (dnd_feature_id) values (1);
insert into DND_FEATURE (dnd_feature_id) values (2);
insert into DND_FEATURE (dnd_feature_id) values (3);
insert into DND_FEATURE (dnd_feature_id) values (4);

insert into DND_FEATURE_L (dnd_feature_id, lang_code, name, description) values (1, 'en', 'Dwarven Resilience',
'You have advantage on saving throws against poison, and you have resistance against poison damage.');
insert into DND_FEATURE_L (dnd_feature_id, lang_code, name, description) values (2, 'en', 'Dwarven Combat Training',
'You have proficiency with the battleaxe, handaxe, light hammer, and warhammer.');
insert into DND_FEATURE_L (dnd_feature_id, lang_code, name, description) values (3, 'en', 'Tool Proficiency',
'You gain proficiency with the artisan’s tools of your choice: smith’s tools, brewer’s supplies, or mason’s tools.');
insert into DND_FEATURE_L (dnd_feature_id, lang_code, name, description) values (4, 'en', 'Stonecunning',
'Whenever you make an Intelligence (History) check related to the origin of stonework, you are considered proficient in the History skill and add double your proficiency bonus to the check, instead of your normal proficiency bonus.');

insert into DND_RACE_FEATURE (dnd_race_id, dnd_feature_id) values (1, 1);
insert into DND_RACE_FEATURE (dnd_race_id, dnd_feature_id) values (1, 2);
insert into DND_RACE_FEATURE (dnd_race_id, dnd_feature_id) values (1, 3);
insert into DND_RACE_FEATURE (dnd_race_id, dnd_feature_id) values (1, 4);

-- Subraces
insert into DND_SUBRACE (dnd_subrace_id, dnd_race_id) values (1, 1);
insert into DND_SUBRACE (dnd_subrace_id, dnd_race_id) values (2, 1);

insert into DND_SUBRACE_L (dnd_subrace_id, lang_code, name, description) values (1, 'en', 'Hill Dwarf',
'As a hill dwarf, you have keen senses, deep intuition, and remarkable resilience. The gold dwarves of Faerûn in their mighty southern kingdom are hill dwarves, as are the exiled Neidar and the debased Klar of Krynn in the Dragonlance setting.');
insert into DND_SUBRACE_L (dnd_subrace_id, lang_code, name, description) values (1, 'sk', 'Horský trpaslík',
'Ako horský trpaslík ste silný a robustný, navyknutý na ťažký život v drsnom prostredí. Ste pravedepodobne pomerne vysoký (na trpaslíka) a inklinujete skôr k svetlejšiemu sfarbeniu. Štítový trpaslíci severného Faerunu, ako aj vládnuci Hylarský klan a šľachtický Daewarský klan z Dračej Kopije patria medzi horských trpaslíkov.');
insert into DND_SUBRACE_L (dnd_subrace_id, lang_code, name, description) values (2, 'en', 'Mountain Dwarf',
'As a mountain dwarf, you’re strong and hardy, accustomed to a difficult life in rugged terrain. You’re probably on the tall side (for a dwarf), and tend toward lighter coloration. The shield dwarves of northern Faerûn, as well as the ruling Hylar clan and the noble Daewar clan of Dragonlance, are mountain dwarves.');
insert into DND_SUBRACE_L (dnd_subrace_id, lang_code, name, description) values (2, 'sk', 'Kopcový trpaslík',
'Ako kopcový trpaslík máte ostré zmysly, rozvinuté podvedomie a pozoruhodnú húževnatosť. Zlatí trpaslíci z Faerunu vo svojom mocnom južnom kráľovstve sú kopcoví trpaslíci, ako aj vyhostení Neidari a odvrhnutí Klari z Krynnu v prostredí Dračej Kopije.');

insert into DND_FEATURE_EFFECT (dnd_feature_effect_id, dnd_feature_id, feature_effect_type, values_to_select, value) values
(1, 1, 'ADVANTAGE_SAVING_THROW', 0, null);
insert into DND_FEATURE_EFFECT (dnd_feature_effect_id, dnd_feature_id, feature_effect_type, values_to_select, value) values
(2, 1, 'RESISTANCE', 0, null);
insert into DND_FEATURE_EFFECT (dnd_feature_effect_id, dnd_feature_id, feature_effect_type, values_to_select, value) values
(3, 2, 'PROFICIENCY_WEAPON', 0, null);
insert into DND_FEATURE_EFFECT (dnd_feature_effect_id, dnd_feature_id, feature_effect_type, values_to_select, value) values
(4, 3, 'PROFICIENCY_TOOL', 1, null);
insert into DND_FEATURE_EFFECT (dnd_feature_effect_id, dnd_feature_id, feature_effect_type, values_to_select, value) values
(5, 4, 'PROFICIENCY_DOUBLED', 0, null);

insert into DND_SUBRACE_ABILITY_MODIFIER (dnd_subrace_id, dnd_ability_modifier_id) values (1, 2);
insert into DND_SUBRACE_ABILITY_MODIFIER (dnd_subrace_id, dnd_ability_modifier_id) values (2, 3);

insert into DND_FEATURE (dnd_feature_id) values (5);
insert into DND_FEATURE (dnd_feature_id) values (6);

insert into DND_FEATURE_L (dnd_feature_id, lang_code, name, description) values (5, 'en', 'Dwarven Toughness',
'Your hit point maximum increases by 1, and it increases by 1 every time you gain a level.');
insert into DND_FEATURE_L (dnd_feature_id, lang_code, name, description) values (6, 'en', 'Dwarven Armor Training',
'You have proficiency with light and medium armor.');

insert into DND_FEATURE_EFFECT (dnd_feature_effect_id, dnd_feature_id, feature_effect_type, values_to_select, value) values
(6, 5, 'HIT_POINTS_PER_LEVEL', 0, 1);
insert into DND_FEATURE_EFFECT (dnd_feature_effect_id, dnd_feature_id, feature_effect_type, values_to_select, value) values
(7, 6, 'PROFICIENCY_ARMOR', 0, null);

insert into DND_SUBRACE_FEATURE (dnd_subrace_id, dnd_feature_id) values (1, 5);
insert into DND_SUBRACE_FEATURE (dnd_subrace_id, dnd_feature_id) values (2, 6);

insert into DND_SUBRACE_PHYSIOGNOMY (dnd_subrace_id, base_height, base_weight, height_modifier, height_modifier_multiplier,
weight_modifier, weight_modifier_multiplier) values (1, 44, 115, 4, 2, 6, 2);
insert into DND_SUBRACE_PHYSIOGNOMY (dnd_subrace_id, base_height, base_weight, height_modifier, height_modifier_multiplier,
weight_modifier, weight_modifier_multiplier) values (2, 48, 130, 4, 2, 6, 2);

-- Sequencers
insert into sys_sequence (seq_name, seq_count) values ('DND_CLASSIFICATION_ID', 1000000);
insert into sys_sequence (seq_name, seq_count) values ('DND_BACKGROUND_ID', 1000000);
insert into sys_sequence (seq_name, seq_count) values ('DND_PERSONAL_CHARACTERISTIC_ID', 1000000);
insert into sys_sequence (seq_name, seq_count) values ('DND_BACKGROUND_SPECIALITY_ID', 1000000);
insert into sys_sequence (seq_name, seq_count) values ('DND_ABILITY_MODIFIER_ID', 1000000);