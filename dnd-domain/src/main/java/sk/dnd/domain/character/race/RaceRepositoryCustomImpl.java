package sk.dnd.domain.character.race;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RaceRepositoryCustomImpl implements RaceRepositoryCustom {

	@Autowired
	RaceRepository raceRepository;

	@Override
	public Race findById(Integer id) {
		return raceRepository.findById(id);
	}

	@Override
	public List<Race> listAll() {
		List<Race> racesList = new ArrayList<>();
		for (Race race : raceRepository.findAll()) {
			racesList.add(race);
		}
		return racesList;
	}

	@Override
	public List<Race> listAllWithCurrentLocale(String currentLangCode) {
		List<Race> races = new ArrayList<>();
		for(Race race: raceRepository.findAll()) {
			race.setCurrentLocale(currentLangCode);
			races.add(race);
		}
		return races;
	}
}
