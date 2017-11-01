package com.project.senpai.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.project.senpai.utils.StringUtil;

public class ErrorMessageTag extends TagSupport {

	private static final long serialVersionUID = -4770451374282521565L;

	private String fieldName;

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	


	public int doStartTag() throws JspException {
		
		String errorMessage = (String) pageContext.getRequest().getAttribute(fieldName);
		
		if (StringUtil.isBlank(errorMessage)) {
			return EVAL_BODY_INCLUDE;
		}
		
		try {
			pageContext.getOut().print("<span class='error'>" + errorMessage + "</span>");
		} catch (Exception e) {
			throw new JspException(e.toString());
		}

		return EVAL_BODY_INCLUDE;
	}

	
	
	@Override
    public int doEndTag() throws JspException {
        return EVAL_BODY_INCLUDE;
    }
}
