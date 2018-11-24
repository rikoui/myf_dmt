package com.bjdreamtech.dmt.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

public class DMTSendMsgHttp {
	
	static Logger log = Logger.getLogger(DMTSendMsgHttp.class);
	
	public final String a="";
	public static String http(final String url, final Map<String, String> params) {
		// public static StringBuffer buffer;
		log.info("发送短信！");
new Thread(new Runnable() {
	
	@Override
	public void run() {
		httpSend(url,params);
		
	}
}).start();
		
		return null;
	}
	
	private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6',
		'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };


	public  String md5(String text) {
		MessageDigest msgDigest = null;

		try {
			msgDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException(
					"System doesn't support MD5 algorithm.");
		}

		try {
			msgDigest.update(text.getBytes("utf-8"));

		} catch (UnsupportedEncodingException e) {

			throw new IllegalStateException(
				"System doesn't support your  EncodingException.");

		}

		byte[] bytes = msgDigest.digest();

		String md5Str = new String(encodeHex(bytes));

		return md5Str;
	}

	public static char[] encodeHex(byte[] data) {

		int l = data.length;

		char[] out = new char[l << 1];

		// two characters form the hex value.
		for (int i = 0, j = 0; i < l; i++) {
			out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];
			out[j++] = DIGITS[0x0F & data[i]];
			}

			return out;
		}
	public static String httpSend(String url, Map<String, String> params){
		URL u = null;
		HttpURLConnection con = null;

		// 构建请求参数

		StringBuffer sb = new StringBuffer();
		try {
			if (params != null) {
				for (Entry<String, String> e : params.entrySet()) {
					sb.append(e.getKey());
					sb.append("=");
					sb.append(e.getValue());
					sb.append("&");
				}
				sb.substring(0, sb.length() - 1);
			}
		} catch (Exception e) {
			
		}

		// 尝试发送请求
		try {
			u = new URL(url);
			con = (HttpURLConnection) u.openConnection();
			// 网络超时时间
			con.setConnectTimeout(60000);

			con.setRequestMethod("POST");
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setUseCaches(false);
			con.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			OutputStreamWriter osw = new OutputStreamWriter(
					con.getOutputStream(), "UTF-8");
			osw.write(sb.toString());
			osw.flush();
			osw.close();
		} catch (IOException e) {
			 System.out.println("当前网络已经断开！请尝试重新连接网络……");
			 log.info("当前网络已经断开！请尝试重新连接网络……");
			// e.printStackTrace();

		} finally {
			if (con != null) {
				con.disconnect();
			}

		}

		// 读取返回内容
		StringBuffer buffer = new StringBuffer();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					con.getInputStream(), "UTF-8"));
			String temp;
			while ((temp = br.readLine()) != null) {
				buffer.append(temp);
				buffer.append("\n");
			}
		} catch (Exception e) {
			log.info("读取返回异常");
			buffer = buffer.append("NetWorkConnectionFailed!");
		}
		log.info("短信发送完成！");
		return buffer.toString();
	
	}

}
