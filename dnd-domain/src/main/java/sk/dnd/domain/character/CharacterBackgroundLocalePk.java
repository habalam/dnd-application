package sk.dnd.domain.character;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
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
	public int compareTo(CharacterBackgroundLocalePk other) {
		return ComparisonChain.start()
			.compare(characterBackgroundId, other.getCharacterBackgroundId())
			.compare(langCode, other.getLangCode())
			.result();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(characterBackgroundId, langCode);
	}

	@Override
	public boolean equals(Object obj) {
		return this == obj
			|| obj instanceof CharacterBackgroundLocalePk
			&& Objects.equal(characterBackgroundId, ((CharacterBackgroundLocalePk) obj).getCharacterBackgroundId())
			&& Objects.equal(langCode, ((CharacterBackgroundLocalePk) obj).getLangCode());
	}
}
