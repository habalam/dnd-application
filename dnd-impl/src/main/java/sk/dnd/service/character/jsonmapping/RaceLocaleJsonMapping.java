package sk.dnd.service.character.jsonmapping;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import sk.dnd.domain.character.race.Race;
import sk.dnd.domain.character.race.RaceLocalePk;

public interface RaceLocaleJsonMapping {

	@JsonBackReference
	Race getRace();

	@JsonIgnore
	RaceLocalePk getRaceLocalePk();

}
