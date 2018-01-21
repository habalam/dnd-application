package sk.dnd.domain.character.race;

import java.util.List;

public interface RaceRepositoryCustom {

	Race findById(Integer id);

	List<Race> listAll();
}
