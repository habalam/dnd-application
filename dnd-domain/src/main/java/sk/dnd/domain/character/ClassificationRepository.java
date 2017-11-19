package sk.dnd.domain.character;

import org.springframework.data.repository.CrudRepository;

public interface ClassificationRepository extends CrudRepository<Classification, Integer> {

	public Classification findById(Integer id);
}
