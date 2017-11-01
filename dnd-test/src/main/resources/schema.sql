DROP TABLE IF EXISTS sys_sequence;
DROP TABLE IF EXISTS dnd_player_character;
DROP TABLE IF EXISTS dnd_character_profession;

CREATE TABLE dnd_character (
	dnd_character_id        NUMBER(10),
	name                    VARCHAR2(100)   CONSTRAINT dnd_character_nn01 NOT NULL,
	level                   NUMBER(2)       CONSTRAINT dnd_character_nn02 NOT NULL,
	hit_points              NUMBER(3)       CONSTRAINT dnd_character_nn03 NOT NULL,
	temporaty_hit_points    NUMBER(3),
    race                    VARCHAR2(10)    CONSTRAINT dnd_character_nn04 NOT NULL,
    subrace                 VARCHAR2(20),
    strength                NUMBER(2)       CONSTRAINT dnd_character_nn05 NOT NULL,
    dexterity               NUMBER(2)       CONSTRAINT dnd_character_nn06 NOT NULL,
    constitution            NUMBER(2)       CONSTRAINT dnd_character_nn07 NOT NULL,
    wisdom                  NUMBER(2)       CONSTRAINT dnd_character_nn08 NOT NULL,
    intelligence            NUMBER(2)       CONSTRAINT dnd_character_nn09 NOT NULL,
    charisma                NUMBER(2)       CONSTRAINT dnd_character_nn10 NOT NULL,
    allignment              VARCHAR2(15)    CONSTRAINT dnd_character_nn11 NOT NULL,
    experience_points       NUMBER(6),
    inspired                VARCHAR2(1)     CONSTRAINT dnd_character_cc01 CHECK (inspired in ('Y', 'N')),
    origin                  CLOB,
	CONSTRAINT dnd_character_pk PRIMARY KEY (dnd_character_id)
);

ALTER TABLE dnd_character ADD CONSTRAINT dnd_character_cc01 CHECK (level <= 20);

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

ALTER TABLE dnd_character_equipment ADD CONSTRAINT dnd_character_equipment_fk FOREIGN KEY (dnd_character_id) REFERENCES dnd_character (dnd_character_id);

create table SYS_SEQUENCE (
	SEQ_NAME    VARCHAR2(1000)  CONSTRAINT sys_sequence_nn01 NOT NULL,
 	SEQ_COUNT   NUMBER(12)      CONSTRAINT sys_sequence_nn02 NOT NULL
);

INSERT INTO SYS_SEQUENCE VALUES ('DND_CHARACTER_ID', 1000000);
INSERT INTO SYS_SEQUENCE VALUES ('DND_CHARACTER_PROFESSION_ID', 1000000);