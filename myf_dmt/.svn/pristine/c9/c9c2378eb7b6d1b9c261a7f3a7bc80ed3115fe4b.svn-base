package com.bjdreamtech.dmt.format;

import java.util.List;
import java.util.Map;

import com.bjdreamtech.dmt.util.DMTDateUtil;

/**
 * 时间格式转换器，转换一条或者一个集合中所有对象的时间格式
 * @author duanwu
 *
 */
public class DMTTimeFormatter {

	/**
	 * 转换一条数据中的时间格式 yyyyMMddHHmmss
	 * @param map 需要转换的数据对象
	 * @param key 需要转换的时间key
	 * @param copyKey 转换后新增的key名
	 */
	public static void formatTime(Map<String,Object> map,String key,String copyKey){
		for(String k:map.keySet()){
			if(k.equals(key)){
				String time = (String) map.get(k);
				String timestr = DMTDateUtil.packDate(time.substring(0, 14));
				map.put(copyKey, timestr);
				break;
			}
		}
	}
	
	/**
	 * 转换一条数据中的时间格式 yyyyMMdd
	 * @param map 需要转换的数据对象
	 * @param key 需要转换的时间key
	 * @param copyKey 转换后新增的key名
	 */
	public static void formatTimeShort(Map<String,Object> map,String key,String copyKey){
		for(String k:map.keySet()){
			if(k.equals(key)){
				String time = (String) map.get(k);
				String timestr = DMTDateUtil.packDateShort(time.substring(0, 8));
				map.put(copyKey, timestr);
				break;
			}
		}
	}
	
	/**
	 * 转换一条数据中的时间格式 yyyy年MM月dd日
	 * @param map 需要转换的数据对象
	 * @param key 需要转换的时间key
	 * @param copyKey 转换后新增的key名
	 */
	public static void formatTimeChina(Map<String,Object> map,String key,String copyKey){
		for(String k:map.keySet()){
			if(k.equals(key)){
				String time = (String) map.get(k);
				String timestr = DMTDateUtil.packDateChina(time.substring(0, 8));
				map.put(copyKey, timestr);
				break;
			}
		}
	}
	
	/**
	 * 转换一个集合数据中的时间格式yyyyMMddHHmmss
	 * @param list 需要转换的集合数据
	 * @param key 需要转换的时间key
	 * @param copyKey 转换后新增的key名
	 */
	public static void formatTimeList(List<Map<String,Object>> list,String key, String copyKey){
		for(int i=0;i<list.size();i++){
			for(String k:list.get(i).keySet()){
				if(k.equals(key)){
					String time = (String) list.get(i).get(k);
					String timestr = DMTDateUtil.packDate(time.substring(0, 14));
					list.get(i).put(copyKey, timestr);
					break;
				}
			}
		}
	}
	
	/**
	 * 转换一个集合数据中的时间格式yyyyMMdd
	 * @param list 需要转换的集合数据
	 * @param key 需要转换的时间key
	 * @param copyKey 转换后新增的key名
	 */
	public static void formatTimeListShort(List<Map<String,Object>> list,String key, String copyKey){
		for(int i=0;i<list.size();i++){
			for(String k:list.get(i).keySet()){
				if(k.equals(key)){
					String time = (String) list.get(i).get(k);
					String timestr = DMTDateUtil.packDateShort(time.substring(0, 8));
					list.get(i).put(copyKey, timestr);
					break;
				}
			}
		}
	}
	
	/**
	 * 转换一个集合数据中的时间格式yyyyMM
	 * @param list 需要转换的集合数据
	 * @param key 需要转换的时间key
	 * @param copyKey 转换后新增的key名
	 */
	public static void formatTimeListMonth(List<Map<String,Object>> list,String key, String copyKey){
		for(int i=0;i<list.size();i++){
			for(String k:list.get(i).keySet()){
				if(k.equals(key)){
					String time = (String) list.get(i).get(k);
					String timestr = DMTDateUtil.packDateMonth(time.substring(0,6));
					list.get(i).put(copyKey, timestr);
					break;
				}
			}
		}
	}
	
	/**
	 * 转换一个集合数据中的日期格式
	 * @param list 需要转换的集合数据
	 * @param key 需要转换的日期key
	 * @param copyKey 转换后新增的key名
	 */
	public static void formatDateList(List<Map<String,Object>> list,String key, String copyKey){
		for(int i=0;i<list.size();i++){
			for(String k:list.get(i).keySet()){
				if(k.equals(key)){
					String date = (String) list.get(i).get(k);
					String datestr = DMTDateUtil.packDateChina(date);
					list.get(i).put(copyKey, datestr);
					break;
				}
			}
		}
	}

	/**
	 * 将带格式的时间字符串转换成不带格式的时间字符串
	 * @param time
	 * @return
	 */
	public static String parseTime(String time){
		return time.replaceAll("-", "").replaceAll(" ", "").replaceAll(":", "");
	}
	/**
	 * 将带格式的时间字符串转换成不带格式的时间字符串并将时间位数不足14的后面补0
	 * @param time
	 * @return
	 */
	public static String formatTime(String time){
		time = time.replaceAll("-", "").replaceAll(" ", "").replaceAll(":", "");
		String s = time;
		if(time.length()<14){
			for(int i=0;i<14-time.length();i++){
				s = s+"0";
			}
		}
		return s;
	}
}
