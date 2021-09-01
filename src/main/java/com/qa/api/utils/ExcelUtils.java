package com.qa.api.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtils {
	static XSSFWorkbook wb;
	static XSSFSheet ws;
	@DataProvider(name="testdataforcall")
	public Object[][] testdataforcall()
	{
		Object[][] data= new Object[1][2];
	try {		
		wb= new XSSFWorkbook("./Dataprovider/TestData.xlsx");
		ws = wb.getSheet("Sheet1");
		//int maxrows= ws.getPhysicalNumberOfRows();
	DataFormatter formatter = new DataFormatter();
	data[0][0]=formatter.formatCellValue(ws.getRow(0).getCell(0));
	data[0][1]=formatter.formatCellValue(ws.getRow(0).getCell(1));

		}
	catch(Exception e)
	{
		System.out.println(e.getStackTrace());
		System.out.println(e.getMessage());
	}
	return data;
	}
}
