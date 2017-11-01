package com.project.senpai.resolvers;

import com.project.senpai.listeners.ValidationListener;
import com.project.senpai.validators.BusinessValidator;
import com.project.senpai.validators.BusinessValidator.ErrorHolder;

public class ValidationResolver {

	private ValidationListener validationListener;

	private ValidationResolver() {
	}

	public static ValidationResolver getInstance(ValidationListener validationListener) {
		ValidationResolver instance = new ValidationResolver();
		                   instance.validationListener = validationListener;
		return instance;
	}

	public <T> ErrorHolder validate(BusinessValidator<T> validator, T object) {

		ErrorHolder errHolder = validator.validate(object);

		this.validationListener.execute(errHolder);

		return errHolder;
	}

}
