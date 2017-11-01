package com.project.senpai.listeners;

import com.project.senpai.validators.BusinessValidator.ErrorHolder;

public interface ValidationListener {

	public void execute(ErrorHolder errorHolder);
	
}
