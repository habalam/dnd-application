package sk.dnd.service.character.jsonmapping;

import com.fasterxml.jackson.annotation.JsonBackReference;
import sk.dnd.domain.character.race.Feature;

/**
 * FeatureEffectJsonMapping.
 *
 * @author habala
 */
public interface FeatureEffectJsonMapping {

	@JsonBackReference
	Feature getFeature();
}
