package sk.dnd.domain.character.background;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BackgroundRepositoryCustomImpl implements BackgroundRepositoryCustom {

	@Autowired
	private BackgroundRepository characterBackgroundRepository;

	public Background findById(Integer id) {
		return characterBackgroundRepository.findById(id);
	}

	@Override
	public List<Background> listAllWithCurrentLocale(String currentLangCode) {
		List<Background> characterBackgrounds = new ArrayList<>();
		for(Background background: characterBackgroundRepository.findAll()) {
			background.setCurrentLocale(currentLangCode);
			characterBackgrounds.add(background);
		}
		return characterBackgrounds;
	}
}
