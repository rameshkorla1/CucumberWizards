package com.wizards.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WebActions {
	
	public static Properties properties;
	
	public static HashMap<String, String> testData = new HashMap<String, String>();
	
	public static HashMap<String, String> getProperties(String FileName) throws IOException {
		
		HashMap<String, String> KeyValueMap = new HashMap<String, String>();
		File file = new File(FileName);
		FileInputStream fileInput = new FileInputStream(file);
		properties = new Properties();
		properties.load(fileInput);
		fileInput.close();
		
		for(String Key :properties.stringPropertyNames())
		{
			String value = properties.getProperty(Key);
			KeyValueMap.put(Key, value);
		}
		return KeyValueMap;
	}
	
	public static HashMap<String, String> getDataRowKey(String sheetName, String rowKeyword) throws Exception
	{
		HashMap<String, String> inputData = new HashMap<String, String>();	
		FileInputStream File = new FileInputStream(new File("testdata/"));
		XSSFWorkbook workbook = new XSSFWorkbook(File);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		//Get row and column count
		int rowCount = sheet.getPhysicalNumberOfRows();
		int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.print(rowCount + "============"+columnCount);
		//Form HashMap with column name and value
		for(int i=0;i<rowCount;i++)
		{
			if(sheet.getRow(i).getCell(0).toString().equals(rowKeyword))
			{
				for(int k=0;k<columnCount;k++)
				{
					//Reads the cell thats has key:value and splits it into two
					//and then puts into the sheet
					String[] Keyvalue = sheet.getRow(i).getCell(k).getStringCellValue().split(":", 2);
					inputData.put(Keyvalue[0], Keyvalue[1]);
				}
				break;
			}
		}
		workbook.close();
		File.close();
		
		return inputData;
		
	}

	public static HashMap<String, String> getDataRow(String sheetName, String rowKeyword) throws Exception
	{
		HashMap<String, String> inputData = new HashMap<String, String>();	
		FileInputStream File = new FileInputStream(new File("testdata/"));
		XSSFWorkbook workbook = new XSSFWorkbook(File);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		//Get row and column count
		int rowCount = sheet.getPhysicalNumberOfRows();
		int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.print(rowCount + "============"+columnCount);
		//Form HashMap with column name and value
		for(int i=0;i<rowCount;i++)
		{
			if(sheet.getRow(i).getCell(0).toString().equals(rowKeyword))
			{
				for(int k=0;k<columnCount;k++)
				{
					//Reads the cell thats has key:value and splits it into two
					//and then puts into the sheet
					testData.put(sheet.getRow(0).getCell(k).toString(), sheet.getRow(i).getCell(k).getStringCellValue());
				}
				break;
			}
		}
		workbook.close();
		File.close();
		
		return testData;		
	}
	
}
