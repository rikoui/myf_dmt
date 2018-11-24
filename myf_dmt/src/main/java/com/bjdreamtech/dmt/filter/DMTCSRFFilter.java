package com.bjdreamtech.dmt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.bjdreamtech.dmt.request.DMTRequest;
import com.bjdreamtech.dmt.util.EncodingHttpServletRequest;
/**
 * 过滤域名
 * @author 
 *
 */
public class DMTCSRFFilter implements Filter{
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		String referer = req.getHeader("referer");
		if(referer!=null && referer.contains("localhost")){
			chain.doFilter(request, response);
		}else{
			//response.setStatus(500);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
