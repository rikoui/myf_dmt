package com.bjdreamtech.dmt.util;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/** 
 * GET方式提交时处理中文乱码
 *  
 * @author duanwu
 *  
 */  
public class EncodingHttpServletRequest extends HttpServletRequestWrapper  
{  
    private HttpServletRequest request;  
    private String encoding;  
  
    public EncodingHttpServletRequest(HttpServletRequest request)  
    {  
        super(request);  
        this.request = request;  
    }  
  
    public EncodingHttpServletRequest(HttpServletRequest request,String encoding)  
    {  
        super(request);  
        this.request = request;  
        this.encoding = encoding;  
          
    }  
    @Override  
    public String getParameter(String name)  
    {  
        String value = request.getParameter(name);  
        if (null != value)  
        {  
            try  
            {  
                value = new String(value.getBytes("ISO-8859-1"), encoding);  
            }  
            catch (UnsupportedEncodingException e)  
            {  
                e.printStackTrace();  
            }  
        }  
        return value;  
    }  
  
}  
