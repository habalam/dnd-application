package sk.dnd.domain.character;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import sk.dnd.domain.infra.BaseObject;
import sk.dnd.domain.character.support.ProfessionType;

@Entity
@Table(name = "DND_CHARACTER_PROFESSION")
@Cacheable
public class CharacterProfession extends BaseObject<Integer>{

	private int level;
	private ProfessionType professionType;
	private Character character;

	@Id
	@Column(name = "DND_CHARACTER_PROFESSION_ID", nullable = false, unique = true)
	@GeneratedValue(generator = "DND_CHARACTER_PROFESSION_GEN")
	@GenericGenerator(name = "DND_CHARACTER_PROFESSION_GEN",
		strategy = "sk.dnd.domain.infra.PoolIdGenerator",
		parameters = {
			@Parameter(name = "table", value = "SYS_SEQUENCE"),
			@Parameter(name = "primary_key_column", value = "SEQ_NAME"),
			@Parameter(name = "value_column", value = "SEQ_COUNT"),
			@Parameter(name = "primary_key_value", value = "DND_CHARACTER_PROFESSION_ID"),
			@Parameter(name = "pool_size", value = "20")
		})
	public Integer getId() {
		return super.getId();
	}

	@NotNull
	@Column(name = "LEVEL", nullable = false)
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "PROFESSION_TYPE", nullable = false)
	public ProfessionType getProfessionType() {
		return professionType;
	}

	public void setProfessionType(ProfessionType professionType) {
		this.professionType = professionType;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "DND_CHARACTER_ID", nullable = false)
	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}
}
