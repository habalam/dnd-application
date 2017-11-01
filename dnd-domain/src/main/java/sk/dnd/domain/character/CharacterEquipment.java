package sk.dnd.domain.character;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import sk.dnd.domain.infra.BaseObject;

/**
 * CharacterEquipment.
 *
 * @author habala
 */
@Entity
@Table(name = "DND_CHARACTER_EQUIPMENT")
public class CharacterEquipment extends BaseObject<Integer> {

	private Character character;

	@Id
	@Column(name = "DND_CHARACTER_EQUIPMENT_ID")
	@GeneratedValue(generator = "DND_CHARACTER_EQUIPMENT_GEN")
	@GenericGenerator(name = "DND_CHARACTER_EQUIPMENT_GEN",
		strategy = "sk.dnd.domain.infra.PoolIdGenerator",
		parameters = {
			@Parameter(name = "table", value = "SYS_SEQUENCE"),
			@Parameter(name = "primary_key_column", value = "SEQ_NAME"),
			@Parameter(name = "value_column", value = "SEQ_COUNT"),
			@Parameter(name = "primary_key_value", value = "DND_CHARACTER_EQUIPMENT_ID"),
			@Parameter(name = "pool_size", value = "20")
		}
	)
	public Integer getId() {
		return super.getId();
	}

	@JoinColumn(name = "DND_CHARACTER_ID", nullable = false)
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}
}
