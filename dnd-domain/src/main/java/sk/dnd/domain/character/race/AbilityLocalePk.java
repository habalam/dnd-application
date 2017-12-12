package sk.dnd.domain.character.race;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

@Embeddable
public class AbilityLocalePk implements Serializable, Comparable<AbilityLocalePk> {

	private Integer abilityId;
	private String langCode;

	@NotNull
	@Column(name = "DND_ABILITY_ID", nullable = false)
	public Integer getAbilityId() {
		return abilityId;
	}

	public void setAbilityId(Integer abilityId) {
		this.abilityId = abilityId;
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
	public int compareTo(AbilityLocalePk other) {
		return ComparisonChain.start()
			.compare(abilityId, other.getAbilityId())
			.compare(langCode, other.getLangCode())
			.result();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(abilityId, langCode);
	}

	@Override
	public boolean equals(Object obj) {
		return this == obj || obj instanceof AbilityLocalePk
			&& Objects.equal(abilityId, ((AbilityLocalePk) obj).getAbilityId())
			&& Objects.equal(langCode, ((AbilityLocalePk) obj).getLangCode());
	}
}
