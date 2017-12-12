DROP TABLE IF EXISTS sys_sequence;
DROP TABLE IF EXISTS dnd_classification;
DROP TABLE IF EXISTS dnd_player_character;
DROP TABLE IF EXISTS dnd_character_profession;

create table DND_CLASSIFICATION (
	DND_CLASSIFICATION_ID   NUMBER(10),
	TYPE                    VARCHAR2(20)    CONSTRAINT dnd_classification_nn01 NOT NULL,
	CONSTRAINT dnd_classification_pk PRIMARY KEY (dnd_classification_id)
);

create table DND_CLASSIFICATION_L (
	DND_CLASSIFICATION_ID   NUMBER(10),
	LANG_CODE               VARCHAR2(2),
	NAME                    VARCHAR2(20),
	DESCRIPTION             CLOB,
	CONSTRAINT dnd_classification_l_pk PRIMARY KEY (DND_CLASSIFICATION_ID, LANG_CODE)
);
ALTER TABLE DND_CLASSIFICATION_L ADD CONSTRAINT dnd_classification_l_fk01 FOREIGN KEY (DND_CLASSIFICATION_ID) REFERENCES DND_CLASSIFICATION (DND_CLASSIFICATION_ID);

create table DND_CHARACTER_BACKGROUND (
	DND_CHARACTER_BACKGROUND_ID NUMBER(10),
	LANGUAGES_COUNT             NUMBER(1),
	CONSTRAINT dnd_character_background_pk PRIMARY KEY (DND_CHARACTER_BACKGROUND_ID)
);

create table DND_CHARACTER_BACKGROUND_L (
	DND_CHARACTER_BACKGROUND_ID NUMBER(10),
	LANG_CODE                   VARCHAR2(2),
	NAME                        VARCHAR2(20),
	DESCRIPTION                 CLOB,
	FEATURE_NAME                VARCHAR2(30),
	FEATURE_DESCRIPTION         CLOB,
	CONSTRAINT dnd_character_background_l_pk PRIMARY KEY (DND_CHARACTER_BACKGROUND_ID, LANG_CODE)
);

create table DND_PERSONAL_CHARACTERISTIC (
	DND_PERSONAL_CHARACTERISTIC_ID NUMBER(10),
	TYPE                           VARCHAR2(20),
	CONSTRAINT dnd_personal_characteristic_pk PRIMARY KEY (DND_PERSONAL_CHARACTERISTIC_ID)
);

create table DND_PERSONAL_CHARACTERISTIC_L (
	DND_PERSONAL_CHARACTERISTIC_ID  NUMBER(10),
	LANG_CODE                       VARCHAR2(2),
	NAME                            VARCHAR2(20),
	DESCRIPTION                     CLOB,
	CONSTRAINT dnd_personal_characteristic_l_pk PRIMARY KEY (DND_PERSONAL_CHARACTERISTIC_ID, LANG_CODE)
);

create table DND_CHARACTER_BACKGROUND_SPECIALITY (
	DND_CHARACTER_BACKGROUND_SPECIALITY_ID  NUMBER(10),
	DND_CHARACTER_BACKGROUND_ID             NUMBER(10),
	LANG_CODE                               VARCHAR2(2),
	NAME                                    VARCHAR2(20),
	DESCRIPTION                             CLOB,
	CONSTRAINT dnd_character_background_speciality_pk PRIMARY KEY (DND_CHARACTER_BACKGROUND_SPECIALITY_ID)
);
ALTER TABLE DND_CHARACTER_BACKGROUND_SPECIALITY ADD CONSTRAINT dnd_character_background_speciality_fk01 FOREIGN KEY (DND_CHARACTER_BACKGROUND_ID) REFERENCES DND_CHARACTER_BACKGROUND (DND_CHARACTER_BACKGROUND_ID);

create table DND_CHARACTER_BACKGROUND_SPECIALITY_VALUE (
	DND_CHARACTER_BACKGROUND_SPECIALITY_ID  NUMBER(10),
	VALUE                                   VARCHAR2(30)
);

create table DND_CHARACTER_BACKGROUND_SKILL (
	DND_CHARACTER_BACKGROUND_ID NUMBER(10),
	DND_CLASSIFICATION_ID       NUMBER(10)
);

create table DND_CHARACTER_BACKGROUND_TRAIT (
	DND_CHARACTER_BACKGROUND_ID     NUMBER(10),
	DND_PERSONAL_CHARACTERISTIC_ID  NUMBER(10),
);

create table DND_CHARACTER_BACKGROUND_IDEAL (
	DND_CHARACTER_BACKGROUND_ID     NUMBER(10),
	DND_PERSONAL_CHARACTERISTIC_ID  NUMBER(10)
);

create table DND_CHARACTER_BACKGROUND_BOND (
	DND_CHARACTER_BACKGROUND_ID     NUMBER(10),
	DND_PERSONAL_CHARACTERISTIC_ID  NUMBER(10)
);

create table DND_CHARACTER_BACKGROUND_FLAW (
	DND_CHARACTER_BACKGROUND_ID     NUMBER(10),
	DND_PERSONAL_CHARACTERISTIC_ID  NUMBER(10)
);

CREATE TABLE dnd_character (
	dnd_character_id        NUMBER(10),
	name                    VARCHAR2(100)   CONSTRAINT dnd_character_nn01 NOT NULL,
	level                   NUMBER(2)       CONSTRAINT dnd_character_nn02 NOT NULL,
	hit_points              NUMBER(3)       CONSTRAINT dnd_character_nn03 NOT NULL,
	temporary_hit_points    NUMBER(3),
	hit_points_current      NUMBER(3)       CONSTRAINT dnd_character_nn13 NOT NULL,
	wounds                  NUMBER(1)       CONSTRAINT dnd_character_nn14 NOT NULL,
    strength                NUMBER(2)       CONSTRAINT dnd_character_nn05 NOT NULL,
    dexterity               NUMBER(2)       CONSTRAINT dnd_character_nn06 NOT NULL,
    constitution            NUMBER(2)       CONSTRAINT dnd_character_nn07 NOT NULL,
    wisdom                  NUMBER(2)       CONSTRAINT dnd_character_nn08 NOT NULL,
    intelligence            NUMBER(2)       CONSTRAINT dnd_character_nn09 NOT NULL,
    charisma                NUMBER(2)       CONSTRAINT dnd_character_nn10 NOT NULL,
    gender                  VARCHAR2(6)     CONSTRAINT dnd_character_nn11 NOT NULL,
    allignment              VARCHAR2(15)    CONSTRAINT dnd_character_nn12 NOT NULL,
    experience_points       NUMBER(6),
    inspired                VARCHAR2(1)     CONSTRAINT dnd_character_cc01 CHECK (inspired in ('Y', 'N')),
    dnd_character_background_id     NUMBER(10) CONSTRAINT dnd_character_nn13 NOT NULL,
    origin                  CLOB,
	CONSTRAINT dnd_character_pk PRIMARY KEY (dnd_character_id)
);
ALTER TABLE DND_CHARACTER ADD CONSTRAINT dnd_character_fk01 FOREIGN KEY (dnd_character_background_id) REFERENCES dnd_character_background (dnd_character_background_id);
ALTER TABLE DND_CHARACTER ADD CONSTRAINT dnd_character_cc01 CHECK (level <= 20);

CREATE TABLE dnd_character_dimension (
	dnd_character_id    NUMBER(10),
	feets               NUMBER(2)   CONSTRAINT dnd_character_dimension_nn01 NOT NULL,
	inches              NUMBER(2)   CONSTRAINT dnd_character_dimension_nn02 NOT NULL,
	pounds              NUMBER(3)   CONSTRAINT dnd_character_dimension_nn03 NOT NULL,
	CONSTRAINT dnd_character_dimension_pk PRIMARY KEY (dnd_character_id)
);

CREATE TABLE DND_CHARACTER_PERTONALITY_CHARACTERISTIC (
	DND_CHARACTER_ID                NUMBER(10),
	DND_PERSONAL_CHARACTERISTIC_ID  NUMBER(10)
);

CREATE TABLE dnd_character_profession (
	dnd_character_profession_id NUMBER(10),
	dnd_character_id            NUMBER(10),
	level                       NUMBER(2)       CONSTRAINT dnd_character_profession_nn01 NOT NULL,
	profession_type             VARCHAR2(10)    CONSTRAINT dnd_character_profession_nn02 NOT NULL,
	CONSTRAINT dnd_character_profession_pk PRIMARY KEY (dnd_character_profession_id)
);
ALTER TABLE dnd_character_profession ADD CONSTRAINT dnd_character_profession_fk FOREIGN KEY (dnd_character_id) REFERENCES dnd_character (dnd_character_id);

CREATE TABLE dnd_character_equipment (
	dnd_character_equipment_id  NUMBER(10),
	dnd_character_id            NUMBER(10),
	CONSTRAINT dnd_character_equipment_pk PRIMARY KEY (dnd_character_equipment_id)
);

ALTER TABLE dnd_character_equipment ADD CONSTRAINT dnd_character_equipment_fk01 FOREIGN KEY (dnd_character_id) REFERENCES dnd_character (dnd_character_id);

CREATE TABLE DND_ABILITY_MODIFIER (
	DND_ABILITY_MODIFIER_ID NUMBER(10),
	ABILITY_TYPE            VARCHAR2(12)    CONSTRAINT dnd_ability_modifier_nn01 NOT NULL,
	VALUE                   NUMBER(2)       CONSTRAINT dnd_ability_modifier_nn02 NOT NULL,
	CONSTRAINT dnd_ability_modifier_pk PRIMARY KEY (DND_ABILITY_MODIFIER_ID)
);

CREATE TABLE DND_ABILITY (
	DND_ABILITY_ID  NUMBER(10),
	CONSTRAINT dnd_ability_pk PRIMARY KEY (DND_ABILITY_ID)
);

CREATE TABLE DND_ABILITY_L (
	DND_ABILITY_ID  NUMBER(10),
	LANG_CODE       VARCHAR2(2),
	NAME            VARCHAR2(50),
	DESCRIPTION     CLOB,
	CONSTRAINT dnd_ability_l_pk PRIMARY KEY (DND_ABILITY_ID, LANG_CODE)
);

-- RACE
CREATE TABLE DND_RACE (
	DND_RACE_ID     NUMBER(10),
	SIZE            VARCHAR2(7) CONSTRAINT dnd_race_nn01 NOT NULL,
	SPEED           NUMBER(2)   CONSTRAINT dnd_race_nn02 NOT NULL,
	DARKVISION      VARCHAR2(1) CONSTRAINT dnd_race_cc01 CHECK (DARKVISION in ('Y', 'N')),
	CONSTRAINT dnd_race_pk PRIMARY KEY (DND_RACE_ID)
);

CREATE TABLE DND_RACE_L (
 	DND_RACE_ID NUMBER(10),
 	LANG_CODE   VARCHAR2(2),
 	NAME        VARCHAR2(50),
 	AGE         VARCHAR2(500),
 	ALIGNMENT   VARCHAR2(500),
 	SIZE        VARCHAR2(500),
 	DESCRIPTION VARCHAR2(500),
 	CONSTRAINT dnd_race_l_pk PRIMARY KEY (DND_RACE_ID, LANG_CODE)
);

CREATE TABLE DND_RACE_ABILITY_MODIFIER (
	DND_RACE_ID             NUMBER(10),
	DND_ABILITY_MODIFIER_ID NUMBER(10)
);

CREATE TABlE DND_RACE_ABILITY (
	DND_RACE_ID     NUMBER(10),
	DND_ABILITY_ID  NUMBER(10)
);

CREATE TABLE DND_CHARACTER_RACE_ABILITY_MODIFIER (
	DND_CHARACTER_ID        NUMBER(10),
	DND_ABILITY_MODIFIER_ID NUMBER(10)
);

CREATE TABLE DND_CHARACTER_RACE (
	DND_CHARACTER_ID    NUMBER(10),
	DND_RACE_ID         NUMBER(10)  CONSTRAINT dnd_character_race_nn01 NOT NULL,
	CONSTRAINT dnd_character_race_pk PRIMARY KEY (DND_CHARACTER_ID)
);

-- SUBRACE
CREATE TABLE DND_SUBRACE (
	DND_SUBRACE_ID  NUMBER(10),
	DND_RACE_ID     NUMBER(10),
	CONSTRAINT dnd_subrace_pk PRIMARY KEY (DND_SUBRACE_ID)
);

CREATE TABLE DND_SUBRACE_L (
	DND_SUBRACE_ID  NUMBER(10),
	LANG_CODE       VARCHAR2(2),
	NAME            VARCHAR2(50),
	DESCRIPTION     VARCHAR2(500),
	CONSTRAINT dnd_subrace_l_pk PRIMARY KEY (DND_SUBRACE_ID, LANG_CODE)
);

CREATE TABLE DND_SUBRACE_ABILITY_MODIFIER (
	DND_SUBRACE_ID              NUMBER(10),
	DND_ABILITY_MODIFIER_ID     NUMBER(10)
);

CREATE TABLE DND_SUBRACE_ABILITY (
	DND_SUBRACE_ID  NUMBER(10),
	DND_ABILITY_ID  NUMBER(10)
);

CREATE TABLE DND_CHARACTER_SUBRACE_ABILITY_MODIFIER (
	DND_CHARACTER_ID        NUMBER(10),
	DND_ABILITY_MODIFIER_ID NUMBER(10)
);

CREATE TABLE DND_CHARACTER_SUBRACE (
	DND_CHARACTER_ID    NUMBER(10),
	DND_SUBRACE_ID      NUMBER(10)  CONSTRAINT dnd_character_subrace_nn01 NOT NULL,
	CONSTRAINT dnd_character_subrace_pk PRIMARY KEY (DND_CHARACTER_ID)
);


create table SYS_SEQUENCE (
	SEQ_NAME    VARCHAR2(1000)  CONSTRAINT sys_sequence_nn01 NOT NULL,
 	SEQ_COUNT   NUMBER(12)      CONSTRAINT sys_sequence_nn02 NOT NULL
);

INSERT INTO SYS_SEQUENCE VALUES ('DND_CHARACTER_ID', 1000000);
INSERT INTO SYS_SEQUENCE VALUES ('DND_CHARACTER_PROFESSION_ID', 1000000);