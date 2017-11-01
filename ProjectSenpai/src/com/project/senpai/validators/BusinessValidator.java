package com.project.senpai.validators;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface BusinessValidator<T>{

	public static class ErrorField implements Serializable{

		private static final long serialVersionUID = 3145440063658180997L;

		private ErrorField() {
		}

		public static ErrorField newInstance(String fieldName,String errorCode, String errorMessage) {

			ErrorField instance = new ErrorField();

			instance.fieldName = fieldName;
			instance.errorCode = errorCode;
			instance.errorMessage = errorMessage;

			return instance;
		}
		
		
		public static ErrorField newInstance(String fieldName, String errorMessage) {

			ErrorField instance = new ErrorField();

			instance.fieldName = fieldName;
			instance.errorMessage = errorMessage;

			return instance;
		}

		private String fieldName;

		private String errorCode;

		private String errorMessage;

		public String getFieldName() {
			return fieldName;
		}

		public String getErrorCode() {
			return errorCode;
		}

		public String getErrorMessage() {
			return errorMessage;
		}

	}
	
	
	public class ErrorHolder {
		
		private List<ErrorField> errorFields;
		
		public boolean hasError(){
			if(errorFields == null || errorFields.isEmpty()){
				return false;
			} return true;
		}
		
		
		public void addError(ErrorField errorField){
			if(errorField == null){
				return;
			}
			if(this.errorFields == null){
				this.errorFields = new ArrayList<BusinessValidator.ErrorField>();
			}
			this.errorFields.add(errorField);
		}
		
		
		public List<ErrorField> getErrorFields(){
			if(this.errorFields == null){
				return Collections.unmodifiableList(new ArrayList<BusinessValidator.ErrorField>());
			} return Collections.unmodifiableList(this.errorFields);
		}
		
		
	}
	
	
	public ErrorHolder validate(T object);

}
