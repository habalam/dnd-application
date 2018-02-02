package sk.dnd.domain.character.background;

import java.util.List;

public interface BackgroundRepositoryCustom {

	Background findById(Integer id);

	List<Background> listAllWithCurrentLocale(String currentLangCode);
}
