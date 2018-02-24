package sk.dnd.service.character.jsonmapping;

import com.fasterxml.jackson.annotation.JsonIgnore;
import sk.dnd.domain.character.race.Race;

/**
 * SubraceJsonMapping.
 *
 * @author habala
 */
public interface SubraceJsonMapping {

	@JsonIgnore
	Race getRace();
}
