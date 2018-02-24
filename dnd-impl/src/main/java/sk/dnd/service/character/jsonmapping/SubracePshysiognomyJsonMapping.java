package sk.dnd.service.character.jsonmapping;

import com.fasterxml.jackson.annotation.JsonBackReference;
import sk.dnd.domain.character.subrace.Subrace;
import sk.dnd.domain.character.subrace.SubraceLocale;

/**
 * SubracePshysiognomyJsonMapping.
 *
 * @author habala
 */
public interface SubracePshysiognomyJsonMapping {

	@JsonBackReference
	Subrace getSubrace();
}
