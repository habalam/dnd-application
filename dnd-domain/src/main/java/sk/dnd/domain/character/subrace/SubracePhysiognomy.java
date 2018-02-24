package sk.dnd.domain.character.subrace;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import sk.dnd.domain.infra.BaseObject;

@Entity
@Table(name = "DND_SUBRACE_PHYSIOGNOMY")
public class SubracePhysiognomy extends BaseObject<Integer>{

	private int baseHeight; //in inches
	private int baseWeight;

	private int heightModifier;
	private int heightModifierMultiplier;

	private int weightModifier;
	private int weightModifierMultiplier;

	private Subrace subrace;

	@Id
	@Column(name = "DND_SUBRACE_ID", nullable = false, unique = true)
	@Override
	public Integer getId() {
		return super.getId();
	}

	@NotNull
	@OneToOne
	@PrimaryKeyJoinColumn
	public Subrace getSubrace() {
		return subrace;
	}

	public void setSubrace(Subrace subrace) {
		this.subrace = subrace;
		if(subrace != null) {
			setId(subrace.getId());
		}
	}

	@NotNull
	@Column(name = "BASE_HEIGHT", nullable = false)
	public int getBaseHeight() {
		return baseHeight;
	}

	public void setBaseHeight(int baseHeight) {
		this.baseHeight = baseHeight;
	}

	@NotNull
	@Column(name = "BASE_WEIGHT", nullable = false)
	public int getBaseWeight() {
		return baseWeight;
	}

	public void setBaseWeight(int baseWeight) {
		this.baseWeight = baseWeight;
	}

	@NotNull
	@Column(name = "HEIGHT_MODIFIER", nullable = false)
	public int getHeightModifier() {
		return heightModifier;
	}

	public void setHeightModifier(int heightModifier) {
		this.heightModifier = heightModifier;
	}

	@NotNull
	@Column(name = "HEIGHT_MODIFIER_MULTIPLIER", nullable = false)
	public int getHeightModifierMultiplier() {
		return heightModifierMultiplier;
	}

	public void setHeightModifierMultiplier(int heightModifierMultiplier) {
		this.heightModifierMultiplier = heightModifierMultiplier;
	}

	@NotNull
	@Column(name = "WEIGHT_MODIFIER", nullable = false)
	public int getWeightModifier() {
		return weightModifier;
	}

	public void setWeightModifier(int weightModifier) {
		this.weightModifier = weightModifier;
	}

	@NotNull
	@Column(name = "WEIGHT_MODIFIER_MULTIPLIER", nullable = false)
	public int getWeightModifierMultiplier() {
		return weightModifierMultiplier;
	}

	public void setWeightModifierMultiplier(int weightModifierMultiplier) {
		this.weightModifierMultiplier = weightModifierMultiplier;
	}
}
