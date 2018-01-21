package sk.dnd.domain.character;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import sk.dnd.domain.character.race.FeatureEffect;
import sk.dnd.domain.infra.BaseObject;

@Entity
@Table(name = "DND_CHARACTER_FEATURE_EFFECT")
public class CharacterFeatureEffect extends BaseObject<Integer> {

	private FeatureEffect featureEffect;
	private CharacterFeature characterFeature;
	private List<Classification> selectedClassifications;

	@Override
	@Id
	@Column(name = "DND_CHARACTER_FEATURE_EFFECT_ID", nullable = false, unique = true)
	@GeneratedValue(generator = "DND_CHARACTER_FEATURE_EFFECT_GEN")
	@GenericGenerator(name = "DND_CHARACTER_FEATURE_EFFECT_GEN",
		strategy = "sk.dnd.domain.infra.PoolIdGenerator",
		parameters = {
			@Parameter(name = "table", value = "SYS_SEQUENCE"),
			@Parameter(name = "primary_key_column", value = "SEQ_NAME"),
			@Parameter(name = "value_column", value = "SEQ_COUNT"),
			@Parameter(name = "primary_key_value", value = "DND_CHARACTER_FEATURE_EFFECT_ID"),
			@Parameter(name = "pool_size", value = "20")
		}
	)
	public Integer getId() {
		return super.getId();
	}

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DND_FEATURE_EFFECT_ID", nullable = false)
	public FeatureEffect getFeatureEffect() {
		return featureEffect;
	}

	public void setFeatureEffect(FeatureEffect featureEffect) {
		this.featureEffect = featureEffect;
	}

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DND_CHARACTER_FEATURE_ID", nullable = false)
	public CharacterFeature getCharacterFeature() {
		return characterFeature;
	}

	public void setCharacterFeature(CharacterFeature characterFeature) {
		this.characterFeature = characterFeature;
	}

	@ManyToMany
	@JoinTable(name = "DND_CHARACTER_FEATURE_EFFECT_CLASSIFICATION",
		joinColumns = @JoinColumn(name = "DND_CHARACTER_FEATURE_EFFECT_ID"),
		inverseJoinColumns = @JoinColumn(name = "DND_CLASSIFICATION_ID")
	)
	public List<Classification> getSelectedClassifications() {
		return selectedClassifications;
	}

	public void setSelectedClassifications(List<Classification> selectedClassifications) {
		this.selectedClassifications = selectedClassifications;
	}
}
