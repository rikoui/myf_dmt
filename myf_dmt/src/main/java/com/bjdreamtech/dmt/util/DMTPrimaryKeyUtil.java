package com.bjdreamtech.dmt.util;

import java.util.UUID;

/**
 * 主键生成工具
 * 使用UUID做主键，兼容所有数据库
 * @author duanwu
 *
 */
public class DMTPrimaryKeyUtil {
	
	/**
	 * 获取主键
	 * @param pre 主键前缀
	 * @return
	 */
	public static String getPrimaryKey(String pre){
		if(pre.length()>8) return null;
		UUID uuid = UUID.randomUUID();
		return pre + uuid.toString().replaceAll("-", "").toUpperCase();
	}
	
	public static void main(String[] args) {
		System.out.println(getPrimaryKey("PRE"));
	}
}
