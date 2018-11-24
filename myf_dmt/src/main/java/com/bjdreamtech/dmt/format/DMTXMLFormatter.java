package com.bjdreamtech.dmt.format;

import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.bjdreamtech.dmt.handler.DMTDOMHandler;

/**
 * XML格式化工具
 * 
 * @author duanwu
 * 
 */
public class DMTXMLFormatter {
	
	/**
	 * 将xml文件解析成List对象
	 * @param filePath 文件路径
	 * @param nodeName 节点名称
	 * @return
	 */
	public static List<Map<String, String>> parseXMLFile(String filePath, String nodeName) {
		try {
			// 创建一个解析XML的工厂对象
			SAXParserFactory parserFactory = SAXParserFactory.newInstance();
			// 创建一个解析XML的对象
			SAXParser parser = parserFactory.newSAXParser();
			// 创建一个解析助手类
			DMTDOMHandler handler = new DMTDOMHandler(nodeName);
			parser.parse(filePath, handler);
			return handler.getList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return null;

	}
	
}
