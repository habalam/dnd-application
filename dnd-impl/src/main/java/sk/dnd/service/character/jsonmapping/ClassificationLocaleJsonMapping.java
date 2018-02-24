package sk.dnd.service.character.jsonmapping;

import com.fasterxml.jackson.annotation.JsonBackReference;
import sk.dnd.domain.character.Classification;

/**
 * ClassificationLocaleJsonMapping.
 *
 * @author habala
 */
public interface ClassificationLocaleJsonMapping {

	@JsonBackReference
	Classification getClassification();
}
