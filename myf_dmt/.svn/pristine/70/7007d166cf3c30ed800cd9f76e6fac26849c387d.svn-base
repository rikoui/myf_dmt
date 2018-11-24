package com.bjdreamtech.dmt.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 * 文件操作工具，文件读取和保存
 * @author duanwu
 *
 */
public class DMTFileUtil {
	
	/**
	 * 将文件流保存为文件
	 * @param inputStream 文件字节流
	 * @param FilePath 文件保存路径
	 * @param fileName 保存文件名称
	 */
	public static void saveFile(InputStream inputStream,String filePath,String fileName) throws Exception{
		File file = new File(filePath+fileName);
		FileOutputStream fos = new FileOutputStream(file);
		byte[] b = new byte[1024];
		int length;
		while((length=inputStream.read(b))!=-1){
			fos.write(b,0,length);
		}
		fos.close();
		inputStream.close();
	}

	/**
	 * 通过制定的文件路径将文件封装为ResponseEntity对象
	 * @param filePath
	 * @return
	 * @throws IOException 
	 */
	public static ResponseEntity<byte[]> downloadFile(String filePath) throws IOException {
		String fileName = filePath.substring(filePath.lastIndexOf("/")+1);
		File file=new File(filePath);  
        HttpHeaders headers = new HttpHeaders();    
        headers.setContentDispositionFormData("attachment", fileName);   
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
                                          headers, HttpStatus.CREATED); 
	}
	
	
}
