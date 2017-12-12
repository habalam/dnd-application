package sk.dnd.domain.character;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import sk.dnd.domain.character.race.AbilityModifier;
import sk.dnd.domain.character.race.Subrace;
import sk.dnd.domain.infra.BaseObject;

@Entity
@Table(name = "DND_CHARACTER_SUBRACE")
public class CharacterSubrace extends BaseObject<Integer> {

	//TODO probably mandatory add of skills, languages, proficiences, resistences, ...
	private Subrace subrace;
	private List<AbilityModifier> abilityModifiers;
	private Character character;

	@Id
	@Column(name = "DND_CHARACTER_ID")
	@Override
	public Integer getId() {
		return super.getId();
	}

	@NotNull
	@OneToOne
	@PrimaryKeyJoinColumn
	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
		if (character != null) {
			setId(character.getId());
		}
	}

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DND_SUBRACE_ID", nullable = false)
	public Subrace getSubrace() {
		return subrace;
	}

	public void setSubrace(Subrace subrace) {
		this.subrace = subrace;
	}

	@OneToMany
	@JoinTable(name = "DND_CHARACTER_SUBRACE_ABILITY_MODIFIER",
		joinColumns = @JoinColumn(name = "DND_CHARACTER_ID"),
		inverseJoinColumns = @JoinColumn(name = "DND_ABILITY_MODIFIER_ID")
	)
	public List<AbilityModifier> getAbilityModifiers() {
		return abilityModifiers;
	}

	public void setAbilityModifiers(List<AbilityModifier> abilityModifiers) {
		this.abilityModifiers = abilityModifiers;
	}
}
