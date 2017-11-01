package com.project.senpai.utils;

public enum FormAction {

	SUBMIT, BACK, CONFIRM;

	public static FormAction valueOfAction(String actionStr) {

		if (StringUtil.isBlank(actionStr)) {
			return null;
		}

		actionStr = actionStr.trim().toUpperCase();

		FormAction action =  null;
		
		try {
			action = FormAction.valueOf(actionStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return action;
		
	}
}
