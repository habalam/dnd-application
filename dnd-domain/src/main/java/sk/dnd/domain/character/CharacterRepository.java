package sk.dnd.domain.character;

import org.springframework.data.repository.CrudRepository;

/**
 * CharacterRepository.
 *
 * @author habala
 */
public interface CharacterRepository extends CrudRepository<Character, Integer> {

	Character findByName(String characterName);

	Character findById(Integer chracterId);
}
