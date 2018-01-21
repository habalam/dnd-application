package sk.dnd.domain.character.race;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "DND_FEATURE_L")
public class FeatureLocale {

	private FeatureLocalePk featureLocalePk;

	private String name;
	private String description;

	private Feature feature;

	@EmbeddedId
	public FeatureLocalePk getFeatureLocalePk() {
		return featureLocalePk;
	}

	public void setFeatureLocalePk(FeatureLocalePk featureLocalePk) {
		this.featureLocalePk = featureLocalePk;
	}

	public void setLangCode(String langCode) {
		if(getFeatureLocalePk() == null) {
			setFeatureLocalePk(new FeatureLocalePk());
		}
		getFeatureLocalePk().setLangCode(langCode);
	}

	@NotNull
	@ManyToOne
	@JoinColumn(name = "DND_FEATURE_ID", nullable = false, updatable = false, insertable = false)
	public Feature getFeature() {
		return feature;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
		if (feature != null) {
			setFeatureId(feature.getId());
		}
	}

	private void setFeatureId(Integer abilityId) {
		if (getFeatureLocalePk() == null) {
			setFeatureLocalePk(new FeatureLocalePk());
		}
		getFeatureLocalePk().setFeatureId(abilityId);
	}

	@NotNull
	@Column(name = "NAME", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull
	@Column(name = "DESCRIPTION", nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
