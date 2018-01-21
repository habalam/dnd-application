package sk.dnd.domain.character;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import sk.dnd.domain.character.race.Feature;
import sk.dnd.domain.infra.BaseObject;

@Entity
@Table(name = "DND_CHARACTER_FEATURE")
public class CharacterFeature extends BaseObject<Integer> {

	private Feature feature;
	private List<CharacterFeatureEffect> featureEffects;

	@Override
	@Id
	@Column(name = "DND_CHARACTER_FEATURE_ID", nullable = false, unique = true)
	@GeneratedValue(generator = "DND_CHARACTER_FEATURE_GEN")
	@GenericGenerator(name = "DND_CHARACTER_FEATURE_GEN",
		strategy = "sk.dnd.domain.infra.PoolIdGenerator",
		parameters = {
			@Parameter(name = "table", value = "SYS_SEQUENCE"),
			@Parameter(name = "primary_key_column", value = "SEQ_NAME"),
			@Parameter(name = "value_column", value = "SEQ_COUNT"),
			@Parameter(name = "primary_key_value", value = "DND_CHARACTER_FEATURE_ID"),
			@Parameter(name = "pool_size", value = "20")
		}
	)
	public Integer getId() {
		return super.getId();
	}

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DND_FEATURE_ID", nullable = false)
	public Feature getFeature() {
		return feature;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
	}

	@OneToMany(mappedBy = "characterFeature")
	public List<CharacterFeatureEffect> getFeatureEffects() {
		return featureEffects;
	}

	public void setFeatureEffects(List<CharacterFeatureEffect> featureEffects) {
		this.featureEffects = featureEffects;
	}
}
