package com.bjdreamtech.dmt.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * Excel导出工具
 * 
 * @author duanwu
 * 
 */
public class DMTExcelUtil {
	
	/**
	 * 导出EXCEL方法
	 * @param fileName 导出文件名称
	 * @param head 导出数据头部显示
	 * @param key 导出数据键
	 * @param list 导出数据集
	 * @return
	 */
	public static HSSFWorkbook exportExcel(String fileName, String[] head, String[] key,
			List<Map<String, Object>> list) {
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet(fileName);
		// 设置表格默认列宽度为15
		sheet.setDefaultColumnWidth(15);
		// 生成一个样式
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置这些样式
		style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 生成一个字体
		HSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.VIOLET.index);
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 把字体应用到当前的样式
		style.setFont(font);
		// 生成并设置另一个样式
		HSSFCellStyle style2 = workbook.createCellStyle();
		style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 生成另一个字体
		HSSFFont font2 = workbook.createFont();
		font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		// 把字体应用到当前的样式
		style2.setFont(font2);

		// 声明一个画图的顶级管理器
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		// 定义注释的大小和位置,详见文档
		HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,
				0, 0, 0, (short) 4, 2, (short) 6, 5));
		// 设置注释内容
		comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
		// 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
		comment.setAuthor("leno");

		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);
		for (int i = 0; i < head.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(style);
			HSSFRichTextString text = new HSSFRichTextString(head[i]);
			cell.setCellValue(text);
		}

		// 遍历集合数据，产生数据行
		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow(i + 1);
			//取出每行的数据
			Map<String,Object> data = list.get(i);
			for(int j=0;j<key.length;j++){
				HSSFCell cell = row.createCell(j);
				cell.setCellStyle(style2);
				Object val = data.get(key[j]);
				String value = "";
				if(val!=null){
					value = val.toString();
				}
				Pattern p = Pattern.compile("^//d+(//.//d+)?$");
				Matcher matcher = p.matcher(value);
				if (matcher.matches()) {
					// 是数字当作double处理
					cell.setCellValue(Double.parseDouble(value));
				} else {
					HSSFRichTextString richString = new HSSFRichTextString(value);
					HSSFFont font3 = workbook.createFont();
					font3.setColor(HSSFColor.BLUE.index);
					richString.applyFont(font3);
					cell.setCellValue(richString);
				}
			}
			
		}
		return workbook;
	}
	
	/**
	 * 导入EXCEL方法
	 * @param in,fileName 导入文件名称
	 * @return list  Excel中的数据集合
	 * @throws Exception 
	 */
	public static List<List<Object>> readExcelData(XSSFWorkbook work) throws Exception {  
		List<List<Object>> list = null;  

            if(null == work){  
                throw new Exception("创建Excel工作薄为空！");  
            } 
               
            Sheet sheet = null;  
            Row row = null;  
            Cell cell = null;  
              
            list = new ArrayList<List<Object>>();  
            //遍历Excel中所有的sheet  
//            for (int i = 0; i < work.getNumberOfSheets(); i++) {  
                sheet = work.getSheetAt(0);  
                if(sheet==null){
                	throw new Exception("表格为空！"); 
                	}  
                  
                //遍历当前sheet中的所有行  
//               int i2 =sheet.getLastRowNum();
                for (int j = 1; j <= sheet.getLastRowNum(); j++) {  
                    row = sheet.getRow(j);  
                    if(row==null||row.getFirstCellNum()==j){continue;}  
                      
                    //遍历所有的列  
                    List<Object> li = new ArrayList<Object>();  
                    for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {  
                        cell = row.getCell(y);  
                        if(cell!=null){
                        	//li中存放每一行的数据
                            li.add(getCellValue(cell));  
                        }else if(cell==null){
                        	li.add(""); 
                        }
                    }  
                    list.add(li);  
                }  
//            }  
               
         
        return list;  
    } 
	
	
    /** 
     * 描述：对表格中数值进行格式化 
     * @param cell 
     * @return 
     */  
    public  static Object getCellValue(Cell cell){  
        Object value = null;  
        DecimalFormat df = new DecimalFormat("0");  //格式化number String字符  
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");  //日期格式化  
        DecimalFormat df2 = new DecimalFormat("0.00");  //格式化数字  
          //根据不同的数据类型进行格式化
//        int a = cell.getCellType();
        switch (cell.getCellType()) {  
	        case Cell.CELL_TYPE_STRING:  
	            value = cell.getRichStringCellValue().getString();  
	            break;  
	        case Cell.CELL_TYPE_NUMERIC:  
	            if("General".equals(cell.getCellStyle().getDataFormatString())){  
	                value = df.format(cell.getNumericCellValue());  
	            }else if("m/d/yy".equals(cell.getCellStyle().getDataFormatString())){ 
	            	//时间判断根据实际输入的格式再定
	                value = sdf.format(cell.getDateCellValue());  
	            }else{  
	                value = df2.format(cell.getNumericCellValue());  
	            }  
	            break;  
	        case Cell.CELL_TYPE_BOOLEAN:  
	            value = cell.getBooleanCellValue();  
	            break;  
	        case Cell.CELL_TYPE_BLANK:  
	            value = "";  
	            break;  
	        default:  
	            break;  
	      }  
        return value;  
    }  
    
    
	public static void main(String[] args) {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for(int i=0;i<10;i++){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("name", "张三"+i);
			map.put("age", 20+i);
			map.put("clazz", "软件三班");
			list.add(map);
		}
		String[] head = new String[]{"姓名","年龄","班级"};
		String[] key = new String[]{"name","age","clazz"};
		DMTExcelUtil.exportExcel("班级信息表", head, key, list);
	}
}
