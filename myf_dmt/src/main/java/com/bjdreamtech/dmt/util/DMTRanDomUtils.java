package com.bjdreamtech.dmt.util;

import java.util.Random;

/**
 * @author wp
 * @since 2016-12-26
 * 生成随机数工具类
 */
public  class DMTRanDomUtils {
	
	static String [] arr ={"a","b","c","d","e","f","g","h","i","j",
			"k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

	/**
	 * @return
	 * 8位字母+数字，随机密码
	 */
	public static String  pwdRandom(){
		
		StringBuilder str=new StringBuilder();//定义变长字符串

		Random random=new Random();
		//数字位数
		int a = random.nextInt(7)%7 + 1;
		
		//随机生成数字，并添加到字符串
		for(int i=0;i<a;i++){
		    str.append(random.nextInt(7));
		}
		//随机生成字母
		for(int i = 0;i<8-a;i++  ){
			int b = random.nextInt(25)%25 + 1;
			str.append(arr[b]);
		}
		return str.toString();
	}
	
	/**
	 * @return
	 * 生成随机账号
	 * sys+8位数字
	 */
	public static String accountRandom(){
		
		StringBuilder str=new StringBuilder();//定义变长字符串

		Random random=new Random();
		
		//随机生成数字，并添加到字符串
		for(int i=0;i<8;i++){
		    str.append(random.nextInt(10));
		}
		
		return "sys"+str.toString();
	}
	
}
