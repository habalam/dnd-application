package sk.dnd.domain.character.race;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

@Embeddable
public class FeatureLocalePk implements Serializable, Comparable<FeatureLocalePk> {

	private Integer featureId;
	private String langCode;

	@NotNull
	@Column(name = "DND_FEATURE_ID", nullable = false)
	public Integer getFeatureId() {
		return featureId;
	}

	public void setFeatureId(Integer featureId) {
		this.featureId = featureId;
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
	public int compareTo(FeatureLocalePk other) {
		return ComparisonChain.start()
			.compare(featureId, other.getFeatureId())
			.compare(langCode, other.getLangCode())
			.result();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(featureId, langCode);
	}

	@Override
	public boolean equals(Object obj) {
		return this == obj || obj instanceof FeatureLocalePk
			&& Objects.equal(featureId, ((FeatureLocalePk) obj).getFeatureId())
			&& Objects.equal(langCode, ((FeatureLocalePk) obj).getLangCode());
	}
}
