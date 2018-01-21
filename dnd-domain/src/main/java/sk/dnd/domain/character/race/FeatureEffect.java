package sk.dnd.domain.character.race;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import sk.dnd.domain.character.Classification;
import sk.dnd.domain.infra.BaseObject;

@Entity
@Table(name = "DND_FEATURE_EFFECT")
public class FeatureEffect extends BaseObject<Integer> {

	private Feature feature;

	private FeatureEffectType featureType;
	private List<Classification> classificationsToSelect;   //pre pripad vyberu nutnosti vyberu z mnoziny objektov/classifications
	private Integer valuesToSelect; //počet koľko objektov sa vyberá z kolekcie vyššie
	private Integer value;  // pri niektorých FeatureEffectType bude stačiť tento type + hodnota

	@Id
	@Column(name = "DND_FEATURE_EFFECT_ID", nullable = false)
	@GeneratedValue(generator = "DND_FEATURE_EFFECT_GEN")
	@GenericGenerator(name = "DND_FEATURE_EFFECT_GEN",
		strategy = "sk.dnd.domain.infra.PoolIdGenerator",
		parameters = {
			@Parameter(name = "table", value = "SYS_SEQUENCE"),
			@Parameter(name = "primary_key_column", value = "SEQ_NAME"),
			@Parameter(name = "value_columen", value = "SEQ_VALUE"),
			@Parameter(name = "primary_key_value", value = "DND_FEATURE_EFFECT_ID"),
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

	@NotNull
	@Column(name = "FEATURE_EFFECT_TYPE", nullable = false)
	@Enumerated(EnumType.STRING)
	public FeatureEffectType getFeatureType() {
		return featureType;
	}

	public void setFeatureType(FeatureEffectType featureType) {
		this.featureType = featureType;
	}

	@ManyToMany
	@JoinTable(name = "DND_FEATURE_EFFECT_CLASSIFICATION",
		joinColumns = @JoinColumn(name = "DND_FEATURE_EFFECT_ID"),
		inverseJoinColumns = @JoinColumn(name = "DND_CLASSIFICATION_ID")
	)
	public List<Classification> getClassificationsToSelect() {
		return classificationsToSelect;
	}

	public void setClassificationsToSelect(List<Classification> classificationsToSelect) {
		this.classificationsToSelect = classificationsToSelect;
	}

	@Column(name = "VALUES_TO_SELECT")
	public Integer getValuesToSelect() {
		return valuesToSelect;
	}

	public void setValuesToSelect(Integer valuesToSelect) {
		this.valuesToSelect = valuesToSelect;
	}

	@Column(name = "VALUE")
	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
