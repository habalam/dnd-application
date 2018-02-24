package sk.dnd.domain.character.subrace;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * SubraceRepository.
 *
 * @author habala
 */
public interface SubraceRepository extends CrudRepository<Subrace, Integer> {

	Subrace findById(Integer id);

	List<Subrace> findByRaceId(Integer raceId);
}
