package sk.dnd.domain.character.background;

import org.springframework.data.repository.CrudRepository;

public interface BackgroundRepository extends CrudRepository<Background, Integer> {

	Background findById(Integer id);
}
