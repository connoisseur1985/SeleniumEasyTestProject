package com.qa.setp.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class DataProviderExcel {
	
	
	
	public ArrayList<String> getExcelData(String name) throws IOException 
	{
		ArrayList<String> list = new ArrayList<String>();
		FileInputStream fin = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\SeleniumEasyTestProject\\src\\main\\java\\com\\qa\\setp\\data\\"+name+".xls");
		
		HSSFWorkbook wb = new HSSFWorkbook(fin);
		HSSFSheet ws = wb.getSheetAt(0);
		int rows = ws.getPhysicalNumberOfRows();
		
	
		for(int i=0;i<rows;i++) 
		{
			 
			if(!(ws.getRow(i).getCell(0).getStringCellValue().contentEquals("null")))
			{
				list.add(ws.getRow(i).getCell(0).getStringCellValue());
				
			}
			else 
			{
				list.add(" ");
			}
		}
		return list;
	}


}
