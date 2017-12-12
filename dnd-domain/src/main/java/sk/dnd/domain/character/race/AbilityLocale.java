package sk.dnd.domain.character.race;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "DND_ABILITY_L")
public class AbilityLocale {

	private AbilityLocalePk abilityLocalePk;

	private String name;
	private String description;

	private Ability ability;

	@EmbeddedId
	public AbilityLocalePk getAbilityLocalePk() {
		return abilityLocalePk;
	}

	public void setAbilityLocalePk(AbilityLocalePk abilityLocalePk) {
		this.abilityLocalePk = abilityLocalePk;
	}

	public void setLangCode(String langCode) {
		if(getAbilityLocalePk() == null) {
			setAbilityLocalePk(new AbilityLocalePk());
		}
		getAbilityLocalePk().setLangCode(langCode);
	}

	@NotNull
	@ManyToOne
	@JoinColumn(name = "DND_ABILITY_ID", nullable = false, updatable = false, insertable = false)
	public Ability getAbility() {
		return ability;
	}

	public void setAbility(Ability ability) {
		this.ability = ability;
		if (ability != null) {
			setAbilityId(ability.getId());
		}
	}

	private void setAbilityId(Integer abilityId) {
		if (getAbilityLocalePk() == null) {
			setAbilityLocalePk(new AbilityLocalePk());
		}
		getAbilityLocalePk().setAbilityId(abilityId);
	}

	@NotNull
	@Column(name = "NAME", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull
	@Column(name = "DESCRIPTION", nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
