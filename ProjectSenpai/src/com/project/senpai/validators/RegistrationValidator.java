package com.project.senpai.validators;

import com.project.senpai.dto.RegistrationDto;
import com.project.senpai.utils.StringUtil;

public class RegistrationValidator implements BusinessValidator<RegistrationDto>{

	

	@Override
	public ErrorHolder validate(RegistrationDto dto) {
		
		ErrorHolder errorHolder = new ErrorHolder();
		
		doValidation(errorHolder, dto);
		
		return errorHolder;
	}
	
	
	private void doValidation(ErrorHolder errorHolder, RegistrationDto dto){
		
		if(StringUtil.isBlank(dto.getUserName())){
			errorHolder.addError(ErrorField.newInstance("userName", "User Name can't be empty"));
		}
		
		if(dto.getAge() <= 0){
			errorHolder.addError(ErrorField.newInstance("age", "Age is required"));
		}
		
	}
	
}
