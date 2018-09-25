package sk.dnd.service.character.jsonmapping;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import sk.dnd.domain.character.subrace.Subrace;

public interface RaceJsonMapping {

	@JsonIgnore
	List<Subrace> getSubraces();
}
