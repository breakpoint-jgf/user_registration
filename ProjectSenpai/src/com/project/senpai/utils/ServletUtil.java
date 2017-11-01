package com.project.senpai.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author JaysonGF
 */
public class ServletUtil {

	/**
	 * @param request
	 * @param response
	 * @param urlPatterns
	 * @throws IOException
	 */
	public static void redirectInternalResource(HttpServletRequest request, HttpServletResponse response, String urlPatterns) throws IOException{
		response.sendRedirect(request.getContextPath()+urlPatterns);
	}
}
