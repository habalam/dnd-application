package sk.dnd.domain.character.race;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

@Embeddable
public class SubraceLocalePk implements Serializable, Comparable<SubraceLocalePk> {

	private Integer subraceId;
	private String langCode;

	@NotNull
	@Column(name = "DND_SUBRACE_ID", nullable = false, updatable = false, insertable = false)
	public Integer getSubraceId() {
		return subraceId;
	}

	public void setSubraceId(Integer subraceId) {
		this.subraceId = subraceId;
	}

	@NotNull
	@Column(name = "LANG_CODE", nullable = false)
	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	@Override
	public int compareTo(SubraceLocalePk o) {
		return ComparisonChain.start().compare(subraceId, o.getSubraceId()).compare(langCode, o.getLangCode()).result();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(subraceId, langCode);
	}

	@Override
	public boolean equals(Object obj) {
		return this == obj || obj instanceof SubraceLocalePk
			&& Objects.equal(subraceId, ((SubraceLocalePk) obj).getSubraceId())
			&& Objects.equal(langCode, ((SubraceLocalePk) obj).getLangCode());
	}
}
