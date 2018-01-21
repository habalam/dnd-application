package sk.dnd.domain.character.race;

import java.util.List;

public interface SubraceRepositoryCustom {

	Subrace findById(Integer id);

	List<Subrace> listAll();
}
