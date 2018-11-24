package com.bjdreamtech.dmt.util;
 
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
 
 
/**
 * DMT3DESUtil {3DES加密解密的工具类 }
 * @author duanwu
 */
public class DMT3DESUtil {
 
    //定义加密算法，有DES、DESede(即3DES)、Blowfish
    private static final String Algorithm = "DESede";    
    private static final String PASSWORD_CRYPT_KEY = "SKDGJWEIWJOISDJAJGAIJFLAKDJFAIEJFOAIDJF";
    
    
    /**
     * 加密字符串方法
     * @param str 加密字符串
     * @return 
     */
    public static String encryptMode(String str) {
        try {
             SecretKey deskey = new SecretKeySpec(build3DesKey(PASSWORD_CRYPT_KEY), Algorithm);    //生成密钥
             Cipher c1 = Cipher.getInstance(Algorithm);    //实例化负责加密/解密的Cipher工具类
             c1.init(Cipher.ENCRYPT_MODE, deskey);    //初始化为加密模式
             return new BASE64Encoder().encode(c1.doFinal(str.getBytes()));
         } catch (java.security.NoSuchAlgorithmException e1) {
             e1.printStackTrace();
         } catch (javax.crypto.NoSuchPaddingException e2) {
             e2.printStackTrace();
         } catch (java.lang.Exception e3) {
             e3.printStackTrace();
         }
         return null;
     }
    
    
    /**
     * 解密字符串函数
     * @param str 待解密字符串
     * @return
     */
    public static String decryptMode(String str) {      
        try {
            SecretKey deskey = new SecretKeySpec(build3DesKey(PASSWORD_CRYPT_KEY), Algorithm);
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.DECRYPT_MODE, deskey);    //初始化为解密模式
            return new String(c1.doFinal(new BASE64Decoder().decodeBuffer(str)));
        } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
        return null;
     }
    
    /**
     * 加密字节数组方法
     * @param str 加密字节数组
     * @return 
     */
    public static byte[] encryptMode(byte[] str) {
        try {
             SecretKey deskey = new SecretKeySpec(build3DesKey(PASSWORD_CRYPT_KEY), Algorithm);    //生成密钥
             Cipher c1 = Cipher.getInstance(Algorithm);    //实例化负责加密/解密的Cipher工具类
             c1.init(Cipher.ENCRYPT_MODE, deskey);    //初始化为加密模式
             return c1.doFinal();
         } catch (java.security.NoSuchAlgorithmException e1) {
             e1.printStackTrace();
         } catch (javax.crypto.NoSuchPaddingException e2) {
             e2.printStackTrace();
         } catch (java.lang.Exception e3) {
             e3.printStackTrace();
         }
         return null;
     }
    
    
    /**
     * 解密字节数组函数
     * @param str 待解密字节数组
     * @return
     */
    public static byte[] decryptMode(byte[] str) {      
        try {
            SecretKey deskey = new SecretKeySpec(build3DesKey(PASSWORD_CRYPT_KEY), Algorithm);
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.DECRYPT_MODE, deskey);    //初始化为解密模式
            return c1.doFinal(str);
        } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
        return null;
     }
    
    
    /*
     * 根据字符串生成密钥字节数组 
     * @param keyStr 密钥字符串
     * @return 
     * @throws UnsupportedEncodingException
     */
    public static byte[] build3DesKey(String keyStr) throws UnsupportedEncodingException{
        byte[] key = new byte[24];    //声明一个24位的字节数组，默认里面都是0
        byte[] temp = keyStr.getBytes("UTF-8");    //将字符串转成字节数组
        
        /*
         * 执行数组拷贝
         * System.arraycopy(源数组，从源数组哪里开始拷贝，目标数组，拷贝多少位)
         */
        if(key.length > temp.length){
            //如果temp不够24位，则拷贝temp数组整个长度的内容到key数组中
            System.arraycopy(temp, 0, key, 0, temp.length);
        }else{
            //如果temp大于24位，则拷贝temp数组24个长度的内容到key数组中
            System.arraycopy(temp, 0, key, 0, key.length);
        }
        return key;
    } 
    
    public static void main(String[] args) throws IOException {
//		byte[] b = new byte[4];
//		b[1] = '1';
//		b[2] = '2';
//		b[3] = '3';
//		b[0] = '4';
//		byte[] c = encryptMode(b);
//		byte[] d = decryptMode(c);
//		System.out.println(b.length);
//		System.out.println(encryptMode(b).length);
//		System.out.println(decryptMode(encryptMode(b)).length);
    	System.out.println(encryptMode("543419507@qq.com"));
    	System.out.println(encryptMode("13720882475"));
    	
	}
}