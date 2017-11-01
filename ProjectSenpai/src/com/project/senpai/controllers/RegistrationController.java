package com.project.senpai.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.senpai.dto.RegistrationDto;
import com.project.senpai.listeners.FormValidationListener;
import com.project.senpai.resolvers.ValidationResolver;
import com.project.senpai.resolvers.ViewContentResolver;
import com.project.senpai.resolvers.ViewContentResolver.BaseTemplate;
import com.project.senpai.utils.FormAction;
import com.project.senpai.utils.ServletObjectExtractUtil;
import com.project.senpai.utils.ServletUtil;
import com.project.senpai.utils.SessionUtil;
import com.project.senpai.utils.StringUtil;
import com.project.senpai.validators.RegistrationValidator;
import com.project.senpai.validators.BusinessValidator.ErrorHolder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebServlet(urlPatterns="/registration")
public class RegistrationController extends HttpServlet{

	private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

	private static final long serialVersionUID = -856655444657324181L;

	private static final String SESS_ATTR_REGISTRATION_DTO = "registrationDto";
	private static final String SESS_ATTR_REGISTRATION_DTO_VALIDATED = "registrationDtoValid";
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	
	/*######################################### ALL PRIVATE METHODS BELOW #########################################*/
	
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
				
		final String actionStr = (String) request.getParameter("action");
		
		if("GET".equalsIgnoreCase(request.getMethod()) || StringUtil.isBlank(actionStr)){
			ViewContentResolver.invokePage(request, response, "/registration/form", BaseTemplate.PUBLIC_ACCESS);
			logger.info("process :: rendering Registration Form");
			return;
		}
		
		/*Reach here means Form Submission*/
		
		FormAction formAction = FormAction.valueOfAction(actionStr);
		
		if(formAction == null){
			ViewContentResolver.invokePage(request, response, "/registration/form", BaseTemplate.PUBLIC_ACCESS);
			return;
		}
		
		logger.info("process :: action = {} ", formAction);
		
		switch (formAction) {
			case SUBMIT: processSubmit(request, response);
				break;
				
			case BACK: processBack(request, response);
				break;
				
			case CONFIRM: processConfirm(request, response);
				break;
	
			default:
				ViewContentResolver.invokePage(request, response, "/registration/form", BaseTemplate.PUBLIC_ACCESS);
		}
		
	}
	

	private void processSubmit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			
		RegistrationDto registrationDto = ServletObjectExtractUtil.extractRegistrationDto(request);
		
		request.getSession().setAttribute(SESS_ATTR_REGISTRATION_DTO, registrationDto);
		
		ErrorHolder errorHolder = 
				ValidationResolver.getInstance(
						FormValidationListener.getInstance(request)).validate(new RegistrationValidator(), registrationDto);
		
		if(errorHolder.hasError()){
			ViewContentResolver.invokePage(request, response, "/registration/form", BaseTemplate.PUBLIC_ACCESS);
			return ;				
		}
		
		SessionUtil.removeAttributes(request.getSession(), SESS_ATTR_REGISTRATION_DTO);
		
		request.getSession().setAttribute(SESS_ATTR_REGISTRATION_DTO_VALIDATED, registrationDto);
		
		ViewContentResolver.invokePage(request, response, "/registration/formConfirm", BaseTemplate.PUBLIC_ACCESS);
		
	}
	
	
	private void processBack(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ViewContentResolver.invokePage(request, response, "/registration/form", BaseTemplate.PUBLIC_ACCESS);
	}
	
	
	private void processConfirm(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		
		RegistrationDto registrationDto = SessionUtil.loadObject(RegistrationDto.class, SESS_ATTR_REGISTRATION_DTO_VALIDATED, request.getSession());
		
		if(registrationDto == null){
			ViewContentResolver.invokePage(request, response, "/registration/form", BaseTemplate.PUBLIC_ACCESS);
			return;
		}
		
		request.getSession().setAttribute(RegistrationAckController.SESS_ATTR_REGISTRATION_DTO, registrationDto);
	
		SessionUtil.removeAttributes(request.getSession(), SESS_ATTR_REGISTRATION_DTO_VALIDATED);
		
		ServletUtil.redirectInternalResource(request, response, "/registrationack");
	}
	
}
