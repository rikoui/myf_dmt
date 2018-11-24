package com.bjdreamtech.dmt.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.bjdreamtech.dmt.bean.DMTResultBean;
import com.bjdreamtech.dmt.format.DMTJSONFormatter;

/**
 * 异常解析器
 * @author duanwu
 *
 */
public class DMTAsyncExceptionResolver implements
        HandlerExceptionResolver {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
 
    public ModelAndView resolveException(HttpServletRequest request,
            HttpServletResponse response, Object object, Exception exception) {
        // JSON格式返回的异常解析器，主要使用于纯后台project
        try {
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            // 为安全起见，只有业务异常我们对前端可见，否则统一归为系统异常
            String message = "";
            if (exception instanceof DMTBusinessException) {
                message = exception.getMessage();
            } else {
                message = "系统异常";
            }
            writer.write(DMTJSONFormatter.parseToJson(new DMTResultBean("1",message,"")));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}