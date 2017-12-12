package sk.dnd.domain.character;

import org.springframework.data.repository.CrudRepository;

public interface CharacterBackgroundRepository extends CrudRepository<CharacterBackground, Integer> {

	CharacterBackground findById(Integer id);
}
