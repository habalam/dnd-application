package sk.dnd.domain.character;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import sk.dnd.domain.util.DndConsts;

@Entity
@Table(name = "DND_CHARACTER_BACKGROUND_L")
public class CharacterBackgroundLocale implements Serializable {

	private CharacterBackgroundLocalePk characterBackgroundLocalePk;

	private String name;
	private String description;

	private CharacterBackground characterBackground;

	@EmbeddedId
	public CharacterBackgroundLocalePk getCharacterBackgroundLocalePk() {
		return characterBackgroundLocalePk;
	}

	public void setCharacterBackgroundLocalePk(CharacterBackgroundLocalePk characterBackgroundLocalePk) {
		this.characterBackgroundLocalePk = characterBackgroundLocalePk;
	}

	@NotNull
	@Column(name = "NAME", length = DndConsts.CHARACTER_BACKGROUND_LEN)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull
	@Lob
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@NotNull
	@ManyToOne
	@JoinColumn(name = "DND_CHARACTER_BACKGROUND_ID", nullable = false, insertable = false, updatable = false)
	public CharacterBackground getCharacterBackground() {
		return characterBackground;
	}

	public void setCharacterBackground(CharacterBackground characterBackground) {
		this.characterBackground = characterBackground;
		if(characterBackground != null) {
			setBackgroundId(characterBackground.getId());
		}
	}

	private void setBackgroundId(Integer characterBackgroundId) {
		if (getCharacterBackgroundLocalePk() == null) {
			setCharacterBackgroundLocalePk(new CharacterBackgroundLocalePk());
		}
		getCharacterBackgroundLocalePk().setCharacterBackgroundId(characterBackgroundId);
	}
}
