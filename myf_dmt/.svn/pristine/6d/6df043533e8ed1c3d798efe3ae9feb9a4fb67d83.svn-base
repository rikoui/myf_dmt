package com.bjdreamtech.dmt.util;

import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class DMTSFTPUtil {
	static Logger log = Logger.getLogger(DMTSFTPUtil.class);
	
	/**
	 * 获取SFTP连接
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @param identity 证书路径
	 * @param remoteFileName 需下载文件名
	 * @param remoteDir 服务器文件目录
	 * @param localDir 下载本地目录
	 */
	public static void download(String ip,int port,String userName,String password,String identity
			,String remoteFileName,String localDir,String remoteDir){
		JSch jsch = new JSch();
		ChannelSftp cls = null;
		try{
			//设置证书
			if(StringUtils.isNotEmpty(identity)){
				jsch.addIdentity(identity);
			}
			Session session = jsch.getSession(userName, ip, port);
			log.debug("获取session成功");
			session.setPassword(password);// 设置密码
			Properties config = new Properties();
			//config.put("userauth.gssapi-with-mic", "no");
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);// 为Session对象设置properties
			session.setTimeout(30000);// 设置timeout时间
			session.connect();// 通过Session建立链接
			log.debug("Session链接成功");
			Channel channel = session.openChannel("sftp");// 打开SFTP通道
			channel.connect();// 建立SFTP通道的连接
			log.debug("SFTP通道连接成功");
			cls = (ChannelSftp)channel;
			cls.cd(remoteDir); //切换到文件目录
			cls.get(remoteFileName, localDir);//下载文件
			log.debug("下载成功");
		}catch (JSchException e) {
			e.printStackTrace();
		} catch (SftpException e) {
			e.printStackTrace();
			e.printStackTrace();
		}
	}
	
	
}
