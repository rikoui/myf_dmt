package com.bjdreamtech.dmt.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.bjdreamtech.dmt.util.DMTConfigUtil;


/**
 * 系统配置文件读取监听器监听器
 * @author duanwu
 *
 */
public class DMTConfigListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		//加载config.xml文件内容
		DMTConfigUtil.initMethod();
	}

}
