package com.bjdreamtech.dmt.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.binary.Hex;

import sun.misc.BASE64Encoder;

public class Md5 {

	
		MessageDigest alg;

		public Md5( ) {
			try {
				alg = MessageDigest.getInstance( "MD5" );
			} catch( Exception ex ) {
				ex.printStackTrace( );
			}
		}

		public byte[] encrypt( String key ) {
			return computeDigest( key.getBytes( ) );
		}

		public byte[] computeDigest( byte[] b ) {
			try {
				alg.reset( );
				alg.update( b );
				byte[] hash = alg.digest( ); // 得到摘要
				return hash;
			} catch( Exception ex ) {
				ex.printStackTrace( );
				return null;
			}
		

	}

		public static String postMt()  throws Exception{
            PrintWriter printWriter = null;                                
            BufferedReader bufferedReader = null;
            String responseResult = "";
            HttpURLConnection httpURLConnection = null;                    //创建HttpURLConnection
               String [] DestTerminalId ={"13240713626"};
            //Post数据类
            CHIFMtSmsSubmit submit = new CHIFMtSmsSubmit( );            //手机号码（最大 21 位），集合表示。
            submit.setDest_terminal_Id( DestTerminalId );  
            //需要状态报告
            submit.setRegistered_Delivery(1);
            submit.setMsg_level(9);
            //手机号码（最大 21 位），集合表示。
            submit.setMsg_Fmt(15);
            
            
            String MsgContent="【用友供应链】testing";
            byte[] msg_content = MsgContent.getBytes("GBK");            //GBK编码转化
            submit.setMsg_Content(msg_content);                            //短信内容，使用 Msg_Fmt 编码编码为 Byte[]。
            String json = submit.toJson();                                //对象转化为Json

            try {
                String time = new SimpleDateFormat( "yyyyMMddHHmmss" ).format( new Date( ));            //时间戳yyyyMMddHHmmss
                String token = Hex.encodeHexString( new Md5( ).encrypt( "100098" + time + "hVl4F4G6" ) );    //拼接Token
 System.out.println(time+":time");
 System.out.println(token+":token");
 
                URL realUrl = new URL("http://118.178.117.163/chif10" + "/mtsms/"+"100098"+"/"+token);                            //拼接URL
                // 打开和URL之间的连接
                httpURLConnection = (HttpURLConnection) realUrl.openConnection();

                String str = "100098" + ":" + time;
                byte[] datas = str.getBytes("GBK");
                BASE64Encoder Base64 = new BASE64Encoder();
                String authorization = new String(Base64.encode(datas));//Base64加密
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
	
	public static void main(String [] args){
		try {
			postMt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

