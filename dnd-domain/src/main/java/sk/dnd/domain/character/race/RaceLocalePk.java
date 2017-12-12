package sk.dnd.domain.character.race;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

@Embeddable
public class RaceLocalePk implements Serializable, Comparable<RaceLocalePk> {

	private Integer raceId;
	private String langCode;

	@NotNull
	@Column(name = "DND_RACE_ID", nullable = false, updatable = false, insertable = false)
	public Integer getRaceId() {
		return raceId;
	}

	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
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
	public int compareTo(RaceLocalePk other) {
		return ComparisonChain.start().compare(raceId, other.getRaceId()).compare(langCode, other.getLangCode()).result();
	}

	@Override
	public boolean equals(Object obj) {
		return this == obj ||
			obj instanceof RaceLocalePk &&
				Objects.equal(raceId, ((RaceLocalePk) obj).getRaceId()) &&
				Objects.equal(langCode, ((RaceLocalePk) obj).getLangCode());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(raceId, langCode);
	}
}
