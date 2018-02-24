package sk.dnd.service.character.jsonmapping;

import com.fasterxml.jackson.annotation.JsonBackReference;
import sk.dnd.domain.character.race.Feature;

public interface FeatureLocaleJsonMapping {

	@JsonBackReference
	Feature getFeature();
}
