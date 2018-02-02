package sk.dnd.domain.character.background;

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
@Table(name = "DND_BACKGROUND_L")
public class BackgroundLocale implements Serializable {

	private BackgroundLocalePk backgroundLocalePk;

	private String name;
	private String description;
	private String featureName;
	private String featureDescription;

	private Background background;

	@EmbeddedId
	public BackgroundLocalePk getBackgroundLocalePk() {
		return backgroundLocalePk;
	}

	public void setBackgroundLocalePk(BackgroundLocalePk backgroundLocalePk) {
		this.backgroundLocalePk = backgroundLocalePk;
	}

	public void setLangCode(String langCode) {
		if(getBackgroundLocalePk() == null) {
			setBackgroundLocalePk(new BackgroundLocalePk());
		}
		getBackgroundLocalePk().setLangCode(langCode);
	}

	@NotNull
	@Column(name = "NAME", length = DndConsts.BACKGROUND_NAME_LEN)
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
	@JoinColumn(name = "DND_BACKGROUND_ID", nullable = false, insertable = false, updatable = false)
	public Background getBackground() {
		return background;
	}

	public void setBackground(Background background) {
		this.background = background;
		if(background != null) {
			setBackgroundId(background.getId());
		}
	}

	private void setBackgroundId(Integer backgroundId) {
		if (getBackgroundLocalePk() == null) {
			setBackgroundLocalePk(new BackgroundLocalePk());
		}
		getBackgroundLocalePk().setBackgroundId(backgroundId);
	}

	@NotNull
	@Column(name = "FEATURE_NAME")
	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	@NotNull
	@Column(name = "FEATURE_DESCRIPTION")
	@Lob
	public String getFeatureDescription() {
		return featureDescription;
	}

	public void setFeatureDescription(String featureDescription) {
		this.featureDescription = featureDescription;
	}
}
