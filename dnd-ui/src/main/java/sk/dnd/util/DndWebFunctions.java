package sk.dnd.util;

import sk.dnd.support.ResourceUtils;

public final class DndWebFunctions {

	private DndWebFunctions() {
		//disable instatiation of class
	}

	public static String enumContextLocalization(Enum<? extends Enum> value) {
		return ResourceUtils.getInstance().enumContextLocalization(value, null);
	}
}
