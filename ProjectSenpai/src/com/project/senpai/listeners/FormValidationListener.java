package com.project.senpai.listeners;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.project.senpai.validators.BusinessValidator.ErrorField;
import com.project.senpai.validators.BusinessValidator.ErrorHolder;

/**
 * 
 * Validation Listener that adds the field names and their respective Error Message to Request Attribute
 * <br>
 * <font color='red'>NOTE: This class is STATEFUL as this requires the CURRENT SERV Request of the User.</font>
 */
public class FormValidationListener implements ValidationListener{

	private HttpServletRequest request;
	
	private FormValidationListener(){
	}
	
	public static FormValidationListener getInstance(HttpServletRequest request){
		FormValidationListener listener = new FormValidationListener();
							   listener.request = request;
		return listener;
	}
	
	@Override
	public void execute(ErrorHolder errorHolder) {
	
		if(!errorHolder.hasError()){
			return;
		}
		
		List<ErrorField> errorfields = errorHolder.getErrorFields();
		
		for(ErrorField ef: errorfields){
			this.request.setAttribute(ef.getFieldName(), ef.getErrorMessage());
		}
		
		cleanUp();
	}
	
	
	private void cleanUp(){
		this.request = null;
	}

}
