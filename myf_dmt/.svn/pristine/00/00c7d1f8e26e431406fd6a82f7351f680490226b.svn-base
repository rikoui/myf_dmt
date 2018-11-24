package com.bjdreamtech.dmt.util;

/**
 * 正则校验工具
 * @author duanwu
 *
 */
public class DMTRegexUtil {
	
	/**
	 * 手机号
	 */
	public static final String PHONE = "^1(3[0-9]|4[57]|5[0-35-9]|8[0-9]|7[0-9])\\d{8}$";
	
	/**
	 * 电话号码
	 */
	public static final String TEL = "0\\d{2,3}-\\d{5,9}|0\\d{2,3}-\\d{5,9}";
	
	/**
	 * 中文
	 */
	public static final String CHINESE = "^[\u4e00-\u9fa5]{0,}$";
	
	/**
	 * 数字
	 */
	public static final String NUMBER = "^[0-9]*$";
	
	/**
	 * 金额
	 */
	public static final String MONEY = "^(([1-9]\\d{0,9})|0)(\\.\\d{1,2})?$";
	
	/**
	 * 不为0的正整数
	 */
	public static final String INTEGER1 = "^([1-9][0-9]*){1,3}$";
	
	/**
	 * 非负整数
	 */
	public static final String INTEGER2 = "^[1-9]\\d*|0$";
	
	/**
	 * 英文字母
	 */
	public static final String LETTER = "^[A-Za-z]+$";
	
	/**
	 * 字母或者数字
	 */
	public static final String LETTER_NUMBER = "^[A-Za-z0-9]+$";
	
	/**
	 * 数字、字母、下划线
	 */
	public static final String LETTER_NUMBER_LINE = "^\\w+$";
	
	/**
	 * EMail
	 */
	public static final String EMAIL = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
	
	/**
	 * 网址
	 */
	public static final String INTERNET = "^(http|https)://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$";
	
	/**
	 * 身份证号码
	 */
	public static final String CERTNO = "^([0-9]){7,18}(x|X)?$";
	
	/**
	 * 百分比
	 */
	public static final String PERCENT = "^(100|([1-9]?[0-9]{1}))(\\.[0-9]{1}[0-9]?)?$";
	
	/**
	 * 密码：6-12个数字和字母的组合
	 */
	public static final String PASSWORD = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$";
	
	/**
	 * 校验给定字符串是否满足给定正则
	 * @param str
	 * @param expression
	 * @return
	 */
	public static boolean matches(String str,String expression){
		if(str.matches(expression))
			return true;
		return false;
	}  
	
	public static void main(String[] args) {
		String amt = "https://www.baidu.com";
		System.out.println(amt.matches(INTERNET));
	}

}
