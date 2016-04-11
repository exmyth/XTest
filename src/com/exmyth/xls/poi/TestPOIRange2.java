package com.exmyth.xls.poi;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestPOIRange2 {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		FileOutputStream fos=new FileOutputStream("D:\\test.xlsx");  
        
		XSSFWorkbook wb=new XSSFWorkbook();  
          
		XSSFSheet sheet=wb.createSheet();  
          
        //在sheet里增加合并单元格  
		/* 
		 * 设定合并单元格区域范围 
		 *  firstRow  0-based 
		 *  lastRow   0-based 
		 *  firstCol  0-based 
		 *  lastCol   0-based 
		 */  
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 0));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 1, 1));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 2, 2));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 3, 5));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 6, 8));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 9, 9));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 10, 10));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 11, 11));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 12, 12));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 13, 13));
          
        Row row = sheet.createRow(0);
        
        String[] header = new String[]{"姓名","工号","部门",
				"迟到","","","早退","","",
				"旷工（天）","请假（小时）","出差（天）","出勤（天）","工作时长"};
        Cell cell = null;
        for(int i = 0; i < 14; i++){
        	if(i/3==1&&i%3!=0){
        		continue;
        	}
        	if(i>6&&(i-6)/6==1&&(i-6)%3!=0){
        		continue;
        	}
        	cell = row.createCell(i);
        	cell.setCellValue(header[i]);
        }
        row = sheet.createRow(1);
        cell = row.createCell(3);
        cell.setCellValue("分钟");
        cell = row.createCell(4);
        cell.setCellValue("小时");
        cell = row.createCell(5);
        cell.setCellValue("次数");
        cell = row.createCell(6);
        cell.setCellValue("分钟");
        cell = row.createCell(7);
        cell.setCellValue("小时");
        cell = row.createCell(8);
        cell.setCellValue("次数");
        wb.write(fos);  
        fos.close();  
	}
}
