package com.project.senpai.utils;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

public class SessionUtil {

	public static <T> T loadObject(Class<T> cls, String key, HttpSession session) {

		try {

			Object obj = session.getAttribute(key);

			if (obj == null) {
				return null;
			}
			return cls.cast(obj);

		} catch (Exception e) {
			throw new ClassCastException("Unable to cast Session Attribute = "
					+ key);
		}

	}

	public static void removeAttributes(HttpSession session, String... attrKeys) {

		if (attrKeys == null || attrKeys.length <= 0) {
			return;
		}

		try {

			for (String attrKey : attrKeys) {
				if (StringUtils.isBlank(attrKey)) {
					continue;
				}
				session.removeAttribute(attrKey);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
