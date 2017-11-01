package sk.dnd.domain.character;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import sk.dnd.domain.util.DndConsts;

@Embeddable
public class CharacterBackgroundLocalePk implements Comparable<CharacterBackgroundLocalePk>, Serializable {

	private Integer characterBackgroundId;
	private String langCode;

	@NotNull
	@Column(name = "DND_CHARACTER_BACKGROUND_ID", nullable = false, updatable = false, insertable = false)
	public Integer getCharacterBackgroundId() {
		return characterBackgroundId;
	}

	public void setCharacterBackgroundId(Integer characterBackgroundId) {
		this.characterBackgroundId = characterBackgroundId;
	}

	@NotNull
	@Column(name = "LANG_CODE", nullable = false, length = DndConsts.LANG_CODE_LEN)
	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	@Override
	public int compareTo(CharacterBackgroundLocalePk o) {
		return 0;
	}
}
