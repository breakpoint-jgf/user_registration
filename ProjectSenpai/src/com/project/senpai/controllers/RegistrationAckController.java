package com.project.senpai.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.senpai.dto.RegistrationDto;
import com.project.senpai.resolvers.ViewContentResolver;
import com.project.senpai.resolvers.ViewContentResolver.BaseTemplate;
import com.project.senpai.utils.ServletUtil;
import com.project.senpai.utils.SessionUtil;


@WebServlet(urlPatterns="/registrationack")
public class RegistrationAckController extends HttpServlet{

	private static final long serialVersionUID = -856655444657324181L;

	private static final Logger logger = LoggerFactory.getLogger(RegistrationAckController.class);
	
	public static final String SESS_ATTR_REGISTRATION_DTO = "registrationDtoAck";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		RegistrationDto dto = SessionUtil.loadObject(RegistrationDto.class, "registrationDtoAck", request.getSession());
		
		if(dto == null){
			ServletUtil.redirectInternalResource(request, response, "/registration");
			return;
		}	
		
		ViewContentResolver.invokePage(request, response, "/registration/formAck", BaseTemplate.PUBLIC_ACCESS);
		
	}
	

	
	
	
	
	
}
