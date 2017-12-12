package sk.dnd.domain.character.race;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import sk.dnd.domain.character.support.AbilityType;
import sk.dnd.domain.infra.BaseObject;

@Entity
@Table(name = "DND_ABILITY_MODIFIER")
public class AbilityModifier extends BaseObject<Integer>{

	private AbilityType abilityType;
	private int value;

	@Override
	@Id
	@Column(name = "DND_ABILITY_MODIFIER_ID", nullable = false)
	@GeneratedValue(generator = "DND_RACE_GEN")
	@GenericGenerator(name = "DND_RACE_GEN",
		strategy = "sk.dnd.domain.infra.PoolIdGenerator",
		parameters = {
			@Parameter(name = "table", value = "SYS_SEQUENCE"),
			@Parameter(name = "primary_key_column", value = "SEQ_NAME"),
			@Parameter(name = "value_columen", value = "SEQ_VALUE"),
			@Parameter(name = "primary_key_value", value = "DND_ABILITY_MODIFIER_ID"),
			@Parameter(name = "pool_size", value = "20")
		})
	public Integer getId() {
		return super.getId();
	}

	@NotNull
	@Column(name = "ABILITY_TYPE", nullable = false)
	@Enumerated(EnumType.STRING)
	public AbilityType getAbilityType() {
		return abilityType;
	}

	public void setAbilityType(AbilityType abilityType) {
		this.abilityType = abilityType;
	}

	@NotNull
	@Column(name = "VALUE", nullable = false)
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
