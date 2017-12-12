package sk.dnd.domain.character;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

@Embeddable
public class PersonalCharacteristicLocalePk implements Serializable, Comparable<PersonalCharacteristicLocalePk> {

	private String langCode;
	private Integer personalCharactericId;

	@NotNull
	@Column(name = "LANG_CODE", nullable = false)
	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	@NotNull
	@Column(name = "DND_PERSONAL_CHARACTERISTIC_ID")
	public Integer getPersonalCharactericId() {
		return personalCharactericId;
	}

	public void setPersonalCharactericId(Integer personalCharactericId) {
		this.personalCharactericId = personalCharactericId;
	}

	@Override
	public int compareTo(PersonalCharacteristicLocalePk other) {
		return ComparisonChain.start()
			.compare(personalCharactericId, other.getPersonalCharactericId())
			.compare(langCode, other.getLangCode())
			.result();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(personalCharactericId, langCode);
	}

	@Override
	public boolean equals(Object obj) {
		return this == obj
			|| obj instanceof PersonalCharacteristicLocalePk
			&& Objects.equal(personalCharactericId, ((PersonalCharacteristicLocalePk) obj).getPersonalCharactericId())
			&& Objects.equal(langCode, ((PersonalCharacteristicLocalePk) obj).getLangCode());
	}
}
