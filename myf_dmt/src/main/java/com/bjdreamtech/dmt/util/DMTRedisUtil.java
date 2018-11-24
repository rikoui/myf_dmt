package com.bjdreamtech.dmt.util;

import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

/**
 * Redis数据库工具类
 * @author duanwu
 *
 */
public class DMTRedisUtil {
	
	public static Jedis jedis;
	
	/**
	 * 存储字符串类型的数据
	 * @param key
	 * @param value
	 */
	public static void insert(String key,String value){
		if(jedis != null){
			jedis.set(key, (String)value);
		}
	}
	
	/**
	 * 存储List类型的数据
	 * @param key
	 * @param value
	 */
	public static void insert(String key,List<String> value){
		if(jedis != null){
			for(String v:value){
				jedis.lpush(key, v);
			}
		}
	}
	
	/**
	 * 存储HashMap类型的数据
	 * @param key
	 * @param value
	 */
	public static void insert(String key,Map<String,String> value){
		if(jedis != null){
			jedis.hmset(key, value);
		}
	}
	
	/**
	 * 获取字符串类型的数据
	 * @param key
	 * @return
	 */
	public static String getString(String key){
		if(jedis != null){
			return jedis.get(key);
		}
		return null;
	}
	
	/**
	 * 获取List类型的数据
	 * @param key
	 * @return
	 */
	public static List<String> getList(String key){
		if(jedis != null){
			return jedis.lrange(key, 0, Integer.MAX_VALUE);
		}
		return null;
	}
	
	/**
	 * 获取HashMap类型的数据
	 * @param key
	 * @return
	 */
	public static Map<String,String> getMap(String key){
		if(jedis != null){
			return jedis.hgetAll(key);
		}
		return null;
	}
	
	/**
	 * 删除数据
	 * @param key
	 */
	public static void del(String key){
		if(jedis !=null){
			jedis.del(key);
		}
	}

}
