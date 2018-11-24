package com.bjdreamtech.dmt.util;

/**
 * SQL参数字符串转义类
 * @author duanwu
 *
 */
public class DMTSqlTransferUtil {
	
	/**
	 * 将SQL参数中的%和_进行转义，对于模糊查询的参数需要使用此方法进行转义
	 * @param param
	 * @return
	 */
	public static String transfer(String param){
		param = param.replaceAll("%", "\\\\%");
		//param = param.replaceAll("_", "\\\\_");
		return "%"+param+"%";
	}

}
