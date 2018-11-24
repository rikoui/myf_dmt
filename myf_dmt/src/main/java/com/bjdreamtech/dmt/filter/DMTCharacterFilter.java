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
 * 特殊字符过滤器
 * 
 * @author duanwu
 */
public class DMTCharacterFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		// 乱码处理
		if ("GET".equals(request.getMethod())) {
			// GET方式提交时处理提交的参数中文乱码问题
			// 将httpRequest进行包装
//			EncodingHttpServletRequest wrapper = new EncodingHttpServletRequest(
//					request, "UTF-8");
			// XSS跨域脚本攻击
			DMTRequest wrapRequest = new DMTRequest(request);
			chain.doFilter(wrapRequest, res);
		} else {
			// POST方式提交时处理提交的参数中文乱码问题
			request.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			// XSS跨域脚本攻击
			DMTRequest wrapRequest = new DMTRequest(request);
			chain.doFilter(wrapRequest, res);

		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}
