package com.bjdreamtech.dmt.format;

import java.util.List;
import java.util.Map;

import com.bjdreamtech.dmt.util.DMT3DESUtil;

/**
 * 单条数据和List中数据解密工具
 * @author duanwu
 *
 */
public class DMTDESDataFormatter {

	/**
	 * 解密集合中的某个字段数据
	 * @param list
	 * @param key
	 * @param copyKey
	 */
	public static void formatTimeList(List<Map<String,Object>> list,String key){
		for(int i=0;i<list.size();i++){
			for(String k:list.get(i).keySet()){
				if(k.equals(key)){
					String date = (String) list.get(i).get(k);
					list.get(i).put(key, DMT3DESUtil.decryptMode(date));
					break;
				}
			}
		}
	}
	
	/**
	 * 解密Map中的某个字段数据
	 * @param map
	 * @param key
	 * @param copyKey
	 */
	public static void formatTime(Map<String,Object> map,String key){
		for(String k:map.keySet()){
			if(k.equals(key)){
				String data = (String) map.get(k);
				map.put(key, DMT3DESUtil.decryptMode(data));
				break;
			}
		}
	}
}
