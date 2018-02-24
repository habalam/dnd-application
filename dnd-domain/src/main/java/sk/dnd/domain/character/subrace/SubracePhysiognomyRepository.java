package sk.dnd.domain.character.subrace;

import org.springframework.data.repository.CrudRepository;

public interface SubracePhysiognomyRepository extends CrudRepository<SubracePhysiognomy, Integer> {

	SubracePhysiognomy findById(Integer subraceId);
}
