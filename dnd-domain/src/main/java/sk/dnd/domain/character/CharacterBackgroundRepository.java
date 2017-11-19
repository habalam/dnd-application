package sk.dnd.domain.character;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CharacterBackgroundRepository extends CrudRepository<CharacterBackground, Integer> {

	public CharacterBackground findById(Integer id);
}
