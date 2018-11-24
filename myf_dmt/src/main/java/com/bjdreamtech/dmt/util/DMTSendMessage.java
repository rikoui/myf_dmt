package com.bjdreamtech.dmt.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Service;

import com.bjdreamtech.dmt.util.CHIFMtSmsSubmit;
import com.bjdreamtech.dmt.util.Md5;

import sun.misc.BASE64Encoder;

public class DMTSendMessage {
		
		public static Properties props = new Properties();

		/*
		 * subject 邮件主题 content 邮件内容 user 发送者名称 SMTP 服务器 fromAccount 发送者账号 Pwd 发送者密码
		 * toAccount 收件人账号
		 */
		public static String sendEmailMessage(final String subject, final String content, final String userName, final String smtp, final String fromAccount,
				final String pwd, final String toAccount) {
			new Thread(new Runnable() {
				public void run() {
					props.put("mail.smtp.auth", "true");// 需要做验证
					props.put("mail.smtp.host", smtp);// smtp主机名
					props.put("mail.password", pwd); // 邮件密码
					props.put("mail.sendAddress", fromAccount); // 发件方地址
					props.put("mail.senderName", userName);// 邮件发送人名称
					// 邮件安全验证
					PopupAuthenticator pop = new PopupAuthenticator();
					pop.performCheck(props.getProperty("mail.sendAddress"), props.getProperty("mail.password")); // 填写用户名及密码
					Session sendMailSession = Session.getInstance(props, pop);
					Message newMessage = new MimeMessage(sendMailSession);
					try {
						// 发送方名称地址
						newMessage.setFrom(
								new InternetAddress(props.getProperty("mail.sendAddress"), props.getProperty("mail.senderName")));
						newMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toAccount)); // 接收方邮件地址
						newMessage.setSentDate(new Date());
						// 主题
						newMessage.setSubject(subject);
						// 发送内容
						newMessage.setContent(content, "text/html;charset=utf-8");
						Transport.send(newMessage);
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
			}).start();
			
			return null;
		}

		
		/* wp
		 * 易云平台
		 * 
		 */
		public String sendPhoneMessage(String content, String url, String sendAccount, String pwd, String phone) {

			PrintWriter printWriter = null;
			BufferedReader bufferedReader = null;
			String responseResult = "";
			HttpURLConnection httpURLConnection = null; // 创建HttpURLConnection
			String[] DestTerminalId = { phone };
			// Post数据类
			CHIFMtSmsSubmit submit = new CHIFMtSmsSubmit(); // 手机号码（最大 21 位），集合表示。
			submit.setDest_terminal_Id(DestTerminalId);
			// 需要状态报告
			submit.setRegistered_Delivery(1);
			submit.setMsg_level(9);
			// 手机号码（最大 21 位），集合表示。
			submit.setMsg_Fmt(15);
			String MsgContent = content;
			byte[] msg_content = null;
			try {
				msg_content = MsgContent.getBytes("GBK");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // GBK编码转化
			submit.setMsg_Content(msg_content); // 短信内容，使用 Msg_Fmt 编码编码为 Byte[]。
			String json = submit.toJson(); // 对象转化为Json

			try {
				String time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()); // 时间戳yyyyMMddHHmmss
				String token = Hex.encodeHexString(new Md5().encrypt(sendAccount + time + pwd)); // 拼接Token
				URL realUrl = new URL(url + sendAccount + "/" + token); // 拼接URL
				// 打开和URL之间的连接
				httpURLConnection = (HttpURLConnection) realUrl.openConnection();
				String str = sendAccount + ":" + time;
				byte[] datas = str.getBytes("GBK");
				BASE64Encoder Base64 = new BASE64Encoder();
				String authorization = new String(Base64.encode(datas));// Base64加密
				// 设置通用的请求属性
				httpURLConnection.setRequestProperty("accept", "application/json");
				httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
				httpURLConnection.setRequestProperty("Authorization", authorization);
				httpURLConnection.setDoOutput(true);
				httpURLConnection.setDoInput(true);
				// 获取URLConnection对象对应的输出流
				printWriter = new PrintWriter(httpURLConnection.getOutputStream());
				// 发送请求参数
				printWriter.write(json);
				// flush输出流的缓冲
				printWriter.flush();
				// 根据ResponseCode判断连接是否成功
				int responseCode = httpURLConnection.getResponseCode();
				System.out.println(responseCode);
				if (responseCode != 200) {
					responseResult = " Error===" + responseCode;
				}
				// 定义BufferedReader输入流来读取URL的ResponseData
				bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					responseResult += line;
				}
				System.out.println(responseResult);
			} catch (Exception e) {
				responseResult = "send post request error!" + e;
			} finally {
				httpURLConnection.disconnect();
				try {
					if (printWriter != null) {
						printWriter.close();
					}
					if (bufferedReader != null) {
						bufferedReader.close();
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}

			}
			return responseResult;
		}
		/*public static void main(String[] args) {
			String emailContent = "尊敬的，您好！您的金猫银猫商户系统登录名为：，密码为：，请及时登录到系统对初始用户名和密码进行修改。";
			String eres = DMTSendMessage.sendEmailMessage("商户管理员账号创建成功通知", emailContent, "金猫银猫商户系统", 
					"smtp.163.com", "huangqiangsg@163.com", "52hj1314", "1094595578@qq.com");
		}*/
	}

	class PopupAuthenticator extends Authenticator {
		String username = null;
		String password = null;

		public PopupAuthenticator() {
		}

		public PasswordAuthentication performCheck(String user, String pass) {
			username = user;
			password = pass;
			return getPasswordAuthentication();
		}

		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
		}
	}


