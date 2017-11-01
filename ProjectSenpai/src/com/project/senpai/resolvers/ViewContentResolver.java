package com.project.senpai.resolvers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewContentResolver {
	
	public static enum BaseTemplate {
		PUBLIC_ACCESS,
		PRIVATE_ACCESS
	}
	
	
	
	/**
	 * @param request
	 * @param response
	 * @param pagePath -  path of JSP relative to /WEB-INF/. No need to include extesion JSP. 
	 * @param baseTemplate
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void invokePage(HttpServletRequest request, HttpServletResponse response, String pagePath, BaseTemplate baseTemplate) throws ServletException, IOException{
		
		String template = (BaseTemplate.PRIVATE_ACCESS.equals(baseTemplate))? 
				"/WEB-INF/templates/private_base.jsp" : "/WEB-INF/templates/public_base.jsp";
		
		request.setAttribute("pageContent", "/WEB-INF/"+pagePath+".jsp");
		request.getRequestDispatcher(template).forward(request, response);
	
	}
	
}
