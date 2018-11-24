package com.bjdreamtech.dmt.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间转换工具
 * @author duanwu
 *
 */
public class DMTDateUtil {
	
	/**
	 * 将当前时间转换成yyyyMMddHHmmss格式，方便存储数据库
	 * @param date
	 * @return
	 */
	public static String parseDate(){
		return parse("yyyyMMddHHmmss");
	}
	
	/**
	 * 根据传入的日期格式将当前时间进行格式化
	 * @param format 日期格式
	 * @return
	 */
	public static String parse(String format){
		return new SimpleDateFormat(format).format(new Date());
	}
	
	/**
	 * 将当前时间转换成yyyyMMddHHmmssfff格式，流水号使用
	 * @param date
	 * @return
	 */
	public static String parseDateDetail(){
		return parse("yyyyMMddHHmmssSSS");
	}
	
	/**
	 * 将给定时间转换成yyyyMMddHHmmss格式，方便存储数据库
	 * @param date
	 * @return
	 */
	public static String parseDate(Date date){
		return new SimpleDateFormat("yyyyMMddHHmmss").format(date);
	}
	
	/**
	 * 将不带格式的时间字符串转换成带格式的字符串
	 * yyyyMMddHHmmssSSS to yyyy-MM-dd HH:mm:ss
	 * @param dateStr
	 * @return
	 */
	public static String packDate(String dateStr){
		if(dateStr!=null&&!dateStr.equals(""))
			return new String(dateStr.substring(0,4)+"-"+dateStr.substring(4,6)+"-"+dateStr.substring(6,8)+" "+dateStr.substring(8,10)+":"+dateStr.substring(10,12)+":"+dateStr.substring(12,14));
		else
			return "";
	}
	
	/**
	 * 将不带格式的时间字符串转换成带格式的字符串
	 * yyyyMMdd to yyyy-MM-dd
	 * @param dateStr
	 * @return
	 */
	public static String packDateShort(String dateStr){
		if(dateStr!=null&&!dateStr.equals(""))
			return new String(dateStr.substring(0,4)+"-"+dateStr.substring(4,6)+"-"+dateStr.substring(6,8));
		else
			return "";
	}

	/**
	 * 将不带格式的时间字符串转换成带格式的字符串
	 * yyyyMMddHHmmss to yyyy-MM-dd HH:mm:ss
	 * @param dateStr
	 * @return
	 */
	public static String packDateChina(String dateStr){
		if(!dateStr.equals(""))
			return new String(dateStr.substring(0,4)+"年"+dateStr.substring(4,6)+"月"+dateStr.substring(6,8)+"日");
		else
			return "";
	}
	
	public static void main(String[] args) {
		for(int i=0;i<100000;i++){
			System.out.println(parseDateDetail());
		}
	}
	/**
	 * 将不带格式的时间字符串转换成带格式的字符串
	 * yyyyMM to yyyy-MM
	 * @param dateStr
	 * @return
	 */
	public static String packDateMonth(String dateStr) {
		if(dateStr!=null&&!dateStr.equals(""))
			return new String(dateStr.substring(0,4)+"-"+dateStr.substring(4,6));
		else
			return "";
	}
	
}
