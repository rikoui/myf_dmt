package com.bjdreamtech.dmt.format;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.bjdreamtech.dmt.util.DMTMoneyUtil;

/**
 * @author zhanglei
 * 
 * 金额格式化转换
 */
public class DMTMoneyFormatter {

	
	/**
	 * 三位，三位000,000,000
	 * 转换一个集合数据中的金额格式
	 * @param list 需要转换的集合数据（String）
	 * @param key 需要转换的key
	 * @param copyKey 转换后新增的key名
	 */
	public static void formatMoneyList(List<Map<String,Object>> list,String key, String copyKey){
		for(int i=0;i<list.size();i++){
			for(String k:list.get(i).keySet()){
				if(k.equals(key)){
					String money =  String.valueOf(list.get(i).get(k));
					String moneyChg = DMTMoneyUtil.moneyFormat(money);
					list.get(i).put(copyKey, moneyChg);
					break;
				}
			}
		}
	}
	
	/**
	 * 三位，三位000,000,000
	 * 转换一个集合数据中的金额格式
	 * @param list 需要转换的集合数据（BigDecimal）
	 * @param key 需要转换的key
	 * @param copyKey 转换后新增的key名
	 */
	public static void formatBigDecimalMoneyList(List<Map<String,Object>> list,String key, String copyKey){
		for(int i=0;i<list.size();i++){
			for(String k:list.get(i).keySet()){
				if(k.equals(key)){
					if(list.get(i).get(k)==null||"".equals(list.get(i).get(k))){
						list.get(i).put(copyKey, "");	
					}else{
					BigDecimal money =  (BigDecimal) list.get(i).get(k);
					String moneyChg = DMTMoneyUtil.moneyFormat(money);
					list.get(i).put(copyKey, moneyChg);
					}
					break;
				}
			}
		}
	}
	
	/**
	 * 三位，三位000,000,000
	 * 转换一个map数据中的金额格式
	 * @param Map 需要转换的集合数据（BigDecimal）
	 * @param key 需要转换的key
	 * @param copyKey 转换后新增的key名
	 */
	public static void formatBigDecimalMoneyMap(Map<String,Object> map,String key,String copyKey){
		for(String k:map.keySet()){
			if(k.equals(key)){
				if(map.get(k)==null||"".equals(map.get(k))){
					map.put(copyKey, "");
				}else{
				BigDecimal money = new BigDecimal(map.get(k).toString());
				String moneyChg = DMTMoneyUtil.moneyFormat(money);
				map.put(copyKey, moneyChg);
			    }
				break;
			}
		}
	}
	
	/**
	 * 三位，三位000,000,000
	 * 转换一个map数据中的金额格式
	 * @param Map 需要转换的集合数据（String）
	 * @param key 需要转换的key
	 * @param copyKey 转换后新增的key名
	 */
	public static void formatMoneyMap(Map<String,Object> map,String key,String copyKey){
		for(String k:map.keySet()){
			if(k.equals(key)){
				String money = String.valueOf(map.get(k));
				String moneyChg = DMTMoneyUtil.moneyFormat(money);
				map.put(copyKey, moneyChg);
				break;
			}
		}
	}
	
}
