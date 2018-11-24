package com.bjdreamtech.dmt.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang.StringUtils;

/**
 * 处理XSS跨站脚本攻击
 * 
 * @author duanwu
 * 
 */
public class DMTRequest extends HttpServletRequestWrapper {
	
	String method = null;

	public DMTRequest(HttpServletRequest servletRequest) {
        super(servletRequest);
    }
    public String[] getParameterValues(String parameter) {
      String[] values = super.getParameterValues(parameter);
      if (values==null)  {
                  return null;
          }
      int count = values.length;
      String[] encodedValues = new String[count];
      for (int i = 0; i < count; i++) {
                 encodedValues[i] = cleanXSS(values[i]);
       }
      return encodedValues;
    }
    public String getParameter(String parameter) {
          String value = super.getParameter(parameter);
          if (value == null) {
                 return null;
                  }
          return cleanXSS(value);
    }
    public String getHeader(String name) {
        String value = super.getHeader(name);
        if (value == null)
            return null;
        return cleanXSS(value);
    }
    private String cleanXSS(String value) {
    	if(StringUtils.isEmpty(value)){
    		return "";
    	}
        value = value.replaceAll( "\"", "" ).replaceAll("\'", "").replaceAll( "<", "" ).replaceAll(">", "");
        value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
        value = value.replaceAll("script", "");
        return value;
    }


}
