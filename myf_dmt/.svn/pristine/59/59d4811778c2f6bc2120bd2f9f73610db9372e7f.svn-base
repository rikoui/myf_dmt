package com.bjdreamtech.dmt.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 配置文件工具，加载特定的配置文件数据
 * @author duanwu
 *
 */
public class DMTConfigUtil {
	//是否连接redis数据库
	public static String REDIS_OPEN;
	//redis数据库IP地址
	public static String REDIS_ADDRESS;
	//redis数据端口
	public static String REDIS_PORT; 
	//系统所使用数据库（oracle/mysql）
	public static String CONFIG_DATABASE;
	//是否开启单点登录
	public static String CONFIG_SINGLESIGNON;
	//系统图片存储路径
	public static String CONFIG_FILEPATH;
	//系统访问路径
	public static String SYSTEM_PATH;
	//FTP文件目录
	public static String SFTP_PATH;
	//短信网关URL
	public static String PHONE_URL;
	//短信网关账号
	public static String PHONE_ACCOUNT;
	//短信网关密码
	public static String PHONE_PWD;
	//邮箱服务器
	public static String EMAIL_SMTP;
	//邮箱账号
	public static String EMAIL_ACCOUNT;
	//邮箱密码
	public static String EMAIL_PWD;
	//邮箱端口
	public static String EMAIL_PORT;
	//邮箱验证
	public static String EMAIL_AUTH;

	
	//个人报销文件上传地址 CONFIG_FILEPATH 
	public static String CONFIGL_TICKET_PERSONAL;
	//config.salary
	public static String CONFIG_SALARY;
	/**
	 * 初始化方法，系统启动的时候加载config.xml配置文件中的内容
	 */
	public static void initMethod(){
		try {
			Properties prop = new Properties();
			InputStream in = DMTConfigUtil.class.getResourceAsStream("/config.properties");
			prop.load(in);
			REDIS_OPEN = prop.getProperty("redis.open");
			REDIS_ADDRESS = prop.getProperty("redis.address");
			REDIS_PORT = prop.getProperty("redis.port");
			CONFIG_DATABASE = prop.getProperty("config.database");
			CONFIG_SINGLESIGNON = prop.getProperty("config.singlesignon");
			CONFIG_FILEPATH = prop.getProperty("config.filePath");
			
			CONFIGL_TICKET_PERSONAL = prop.getProperty("configl.ticket.personal");
			CONFIG_SALARY=prop.getProperty("config.salary");
			
			SYSTEM_PATH = prop.getProperty("config.systemPath");
			SFTP_PATH = prop.getProperty("config.sftpPath");
			EMAIL_SMTP = prop.getProperty("email.smtp");
			EMAIL_ACCOUNT = prop.getProperty("email.account");
			EMAIL_PWD = prop.getProperty("email.pwd");
			EMAIL_PORT = prop.getProperty("email.port");
			EMAIL_AUTH = prop.getProperty("email.auth");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
