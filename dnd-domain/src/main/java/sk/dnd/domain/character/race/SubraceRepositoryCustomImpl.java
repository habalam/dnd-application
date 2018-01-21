package sk.dnd.domain.character.race;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SubraceRepositoryCustomImpl implements SubraceRepositoryCustom {

	@Autowired
	SubraceRepository subraceRepository;

	@Override
	public Subrace findById(Integer id) {
		return subraceRepository.findById(id);
	}

	@Override
	public List<Subrace> listAll() {
		List<Subrace> subraces = new ArrayList<>();
		for(Subrace subrace: subraceRepository.findAll()) {
			subraces.add(subrace);
		}
		return subraces;
	}
}
