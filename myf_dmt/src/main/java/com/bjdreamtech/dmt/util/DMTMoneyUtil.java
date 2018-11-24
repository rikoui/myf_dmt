package com.bjdreamtech.dmt.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author zhanglei
 * 
 *  金额格式化转换
 */
public class DMTMoneyUtil {
	/**
	 * 金额格式化
	 * 传入字符串
	 */
	public static String  moneyFormat(String str){
		if("".equals(str)||str==null){
			return "";
		}
		String temp ="";
		//如果没有小数点
		if(str.indexOf(".")==-1){
			temp=".00";
		}if(str.indexOf(".")!=-1&&str.substring(str.indexOf(".")+1,str.length()).length()==1){
			temp ="0";
		}if(str.indexOf(".")!=-1&&str.substring(str.length()-1, str.length()).equals("0")){
			temp="0";
		}if("00".equals(str.substring(str.indexOf(".")+1,str.length()))){
			temp=".00";
		}
		if("0".equals(str.substring(str.indexOf(".")+1,str.length()))){
			temp=".00";
		}
		
		
		
		NumberFormat format = new DecimalFormat("#,###.####");
	    return format.format(Double.valueOf(str).doubleValue())+temp;
	}

	
	/**
	 * 金额格式化
	 * BigDecimal转换
	 */
	public static String  moneyFormat(BigDecimal str){
		//转成字符串
		String strChg = String.valueOf(str);
		if("".equals(strChg)||strChg==null){
			return "";
		}
		String temp ="";
		//如果没有小数点
		if(strChg.indexOf(".")==-1){
			temp=".00";
		}if(strChg.indexOf(".")!=-1&&strChg.substring(strChg.indexOf(".")+1,strChg.length()).length()==1){
			temp ="0";
		}if(strChg.indexOf(".")!=-1&&strChg.substring(strChg.length()-1, strChg.length()).equals("0")){
			temp="0";
		}if("00".equals(strChg.substring(strChg.indexOf(".")+1,strChg.length()))){
			temp=".00";
		}
		if("0".equals(strChg.substring(strChg.indexOf(".")+1,strChg.length()))){
			temp=".00";
		}
		
		NumberFormat format = new DecimalFormat("#,###.####");
	    return format.format(Double.valueOf(str.toString()).doubleValue())+temp;
	}
	
	
    
    
}
