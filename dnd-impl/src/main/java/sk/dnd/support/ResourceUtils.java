package sk.dnd.support;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

public final class ResourceUtils {

	@Autowired
	private MessageSource messageSource;

	private static final ResourceUtils instance = new ResourceUtils();

	private ResourceUtils() {
		//not instance this class
	}

	public static ResourceUtils getInstance() {
		return instance;
	}

	public String enumContextLocalization(Enum<? extends Enum> enumObject, String... args) {
		Locale currentLocale = LocaleContextHolder.getLocale();
		String localicationKey = "domain.enum." + enumObject.getClass().getSimpleName() + '.' + enumObject;
		return messageSource.getMessage(localicationKey, null, currentLocale);
	}
}
