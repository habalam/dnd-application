package sk.dnd.domain.util;

import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;

public final class LangUtils {

	public static final String LANG_CODE_SK = "sk";
	public static final String LANG_CODE_EN = "en";

	private LangUtils() {
		throw new AssertionError();
	}

	public static String getCurrentLangCode() {
		Locale locale = LocaleContextHolder.getLocale();
		if(locale != null) {
			return locale.getLanguage();
		}
		return LangUtils.LANG_CODE_SK;
	}

	public static String getOtherLanguage() {
		String currentLocale = LocaleContextHolder.getLocale().getLanguage();
		if(LANG_CODE_SK.equals(currentLocale)) {
			return LANG_CODE_EN;
		}
		else return LANG_CODE_SK;
	}
}
