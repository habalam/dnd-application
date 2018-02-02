package sk.dnd.domain.character.subrace;

import java.util.List;

public interface SubraceRepositoryCustom {

	Subrace findById(Integer id);

	List<Subrace> listAll();

	List<Subrace> listAllWithCurrentLocale(String currentLangCode);
}
