package sk.dnd.service.character.jsonmapping;

import com.fasterxml.jackson.annotation.JsonBackReference;
import sk.dnd.domain.character.subrace.Subrace;

public interface SubraceLocaleJsonMapping {

	@JsonBackReference
	Subrace getSubrace();
}
