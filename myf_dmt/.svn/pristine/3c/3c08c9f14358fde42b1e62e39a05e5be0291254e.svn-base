package com.bjdreamtech.dmt.format;

import java.util.List;

import com.alibaba.fastjson.JSONObject;


/**
 * JSON格式化工具
 * 
 * @author duanwu
 * 
 */
public class DMTJSONFormatter{
	
	
	/**
	 * 将json字符串转换成bean对象
	 * @param json
	 * @return
	 */
	public static <T> T parseToBean(String json,Class<T> clazz){
		return JSONObject.parseObject(json,clazz);
	}
	
	/**
	 * 将对象转换成json字符串
	 * @param obj
	 * @return
	 */
	public static  String parseToJson(Object obj){
		return  JSONObject.toJSONString(obj);
	}
	
	/**
	 * 将json字符串转换成对象数组
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> parseToArray(String json, Class<T> clazz){
		return JSONObject.parseArray(json, clazz);
	}
	
	
}
