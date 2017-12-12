package sk.dnd.domain.character.race;

import org.springframework.data.repository.CrudRepository;

/**
 * RaceRepository.
 *
 * @author habala
 */
public interface RaceRepository extends CrudRepository<Race, Integer> {

	Race findById(Integer id);
}
