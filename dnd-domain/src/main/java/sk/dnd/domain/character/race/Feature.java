package sk.dnd.domain.character.race;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import sk.dnd.domain.infra.BaseObject;

@Entity
@Table(name = "DND_FEATURE")
public class Feature extends BaseObject<Integer> {

	private Map<String, FeatureLocale> locales;
	private List<FeatureEffect> featureEffects;     //zoznam efektov danej feature - môže ich byť viacero

	@Override
	@Id
	@Column(name = "DND_FEATURE_ID", nullable = false)
	@GeneratedValue(generator = "DND_FEATURE_GEN")
	@GenericGenerator(name = "DND_FEATURE_GEN",
		strategy = "sk.dnd.domain.infra.PoolIdGenerator",
		parameters = {
			@Parameter(name = "table", value = "SYS_SEQUENCE"),
			@Parameter(name = "primary_key_column", value = "SEQ_NAME"),
			@Parameter(name = "value_columen", value = "SEQ_VALUE"),
			@Parameter(name = "primary_key_value", value = "DND_FEATURE_ID"),
			@Parameter(name = "pool_size", value = "20")
		}
	)
	public Integer getId() {
		return super.getId();
	}

	@NotNull
	@OneToMany(mappedBy = "feature", fetch = FetchType.LAZY)
	@MapKey(name = "featureLocalePk.langCode")
	public Map<String, FeatureLocale> getLocales() {
		return locales;
	}

	public void setLocales(Map<String, FeatureLocale> locales) {
		this.locales = locales;
	}

	@OneToMany(mappedBy = "feature", fetch = FetchType.LAZY)
	public List<FeatureEffect> getFeatureEffects() {
		return featureEffects;
	}

	public void setFeatureEffects(List<FeatureEffect> featureEffects) {
		this.featureEffects = featureEffects;
	}
}
