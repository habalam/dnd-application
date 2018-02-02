package sk.dnd.domain.character.background;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import sk.dnd.domain.util.DndConsts;

@Embeddable
public class BackgroundLocalePk implements Comparable<BackgroundLocalePk>, Serializable {

	private Integer backgroundId;
	private String langCode;

	@NotNull
	@Column(name = "DND_BACKGROUND_ID", nullable = false, updatable = false, insertable = false)
	public Integer getBackgroundId() {
		return backgroundId;
	}

	public void setBackgroundId(Integer backgroundId) {
		this.backgroundId = backgroundId;
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
	public int compareTo(BackgroundLocalePk other) {
		return ComparisonChain.start()
			.compare(backgroundId, other.getBackgroundId())
			.compare(langCode, other.getLangCode())
			.result();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(backgroundId, langCode);
	}

	@Override
	public boolean equals(Object obj) {
		return this == obj
			|| obj instanceof BackgroundLocalePk
			&& Objects.equal(backgroundId, ((BackgroundLocalePk) obj).getBackgroundId())
			&& Objects.equal(langCode, ((BackgroundLocalePk) obj).getLangCode());
	}
}
