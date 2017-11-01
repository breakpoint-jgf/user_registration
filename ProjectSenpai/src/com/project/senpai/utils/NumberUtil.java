package com.project.senpai.utils;

public class NumberUtil {

	public static int parseInt(String numStr, int defaultVal) {

		try {
			return Integer.parseInt(numStr);
		} catch (Exception ignore) {
			/* understood not parsable */
			return defaultVal;
		}

	}

}
