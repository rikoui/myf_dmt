package com.bjdreamtech.dmt.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import redis.clients.jedis.Jedis;

import com.bjdreamtech.dmt.util.DMTConfigUtil;
import com.bjdreamtech.dmt.util.DMTRedisUtil;


/**
 * 初始化Redis数据库监听器
 * @author duanwu
 *
 */
public class DMTRedisListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		//链接redis数据库
		if(DMTConfigUtil.REDIS_OPEN.equals("true")){
			DMTRedisUtil.jedis = new Jedis(DMTConfigUtil.REDIS_ADDRESS,Integer.parseInt(DMTConfigUtil.REDIS_PORT));
		}
	}

}
