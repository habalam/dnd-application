package sk.dnd.domain.character.race;

import org.springframework.data.repository.CrudRepository;

/**
 * SubraceRepository.
 *
 * @author habala
 */
public interface SubraceRepository extends CrudRepository<Subrace, Integer> {

	Subrace findById(Integer id);
}
