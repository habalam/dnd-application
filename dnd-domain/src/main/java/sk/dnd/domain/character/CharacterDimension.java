package sk.dnd.domain.character;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import sk.dnd.domain.infra.BaseObject;

@Entity
@Table(name = "DND_CHARACTER_DIMENSION")
public class CharacterDimension extends BaseObject<Integer> {

	private Character character;

	private int feets;
	private int inches;
	private int pounds;

	@Id
	@Column(name = "DND_CHARACTER_ID", nullable = false, unique = true)
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
		if(character != null) {
			setId(character.getId());
		}
	}

	@NotNull
	@Column(name = "FEETS", nullable = false)
	public int getFeets() {
		return feets;
	}

	public void setFeets(int feets) {
		this.feets = feets;
	}

	@NotNull
	@Column(name = "INCHES", nullable = false)
	public int getInches() {
		return inches;
	}

	public void setInches(int inches) {
		this.inches = inches;
	}

	@NotNull
	@Column(name = "POUNDS", nullable = false)
	public int getPounds() {
		return pounds;
	}

	public void setPounds(int pounds) {
		this.pounds = pounds;
	}
}
