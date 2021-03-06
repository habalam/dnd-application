package sk.dnd.domain.character.subrace;

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

	@Override
	public List<Subrace> listAllWithCurrentLocale(String currentLangCode) {
		List<Subrace> subraces = new ArrayList<>();
		for(Subrace subrace: subraceRepository.findAll()) {
			subrace.setCurrentLocale(currentLangCode);
			subraces.add(subrace);
		}
		return subraces;
	}

	@Override
	public List<Subrace> listSubracesForRaceWithCurrentLocale(Integer raceId, String currentLangCode) {
		List<Subrace> subraces = new ArrayList<>();
		for(Subrace subrace: subraceRepository.findByRaceId(raceId)) {
			subrace.setCurrentLocale(currentLangCode);
			subraces.add(subrace);
		}
		return subraces;
	}
}
