package com.project.senpai.utils;

import javax.servlet.http.HttpServletRequest;

import com.project.senpai.dto.RegistrationDto;

public class ServletObjectExtractUtil {

	public static RegistrationDto extractRegistrationDto(HttpServletRequest request) {

		String userName = request.getParameter("userName");
		int age = NumberUtil.parseInt(request.getParameter("age"), 0);

		RegistrationDto dto = new RegistrationDto();
		dto.setUserName(userName);
		dto.setAge(age);

		return dto;
	}

}
