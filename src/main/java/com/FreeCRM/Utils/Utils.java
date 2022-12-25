package com.FreeCRM.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.support.PageFactory;

import com.BASE.Base;

public class Utils extends Base{
	
	public static long pageLoadTimeout = 5;
	public static long implicitTimeout = 5;
	public static Workbook book;
	public static Sheet sheet;
	
	public Utils() {
		PageFactory.initElements(driver, this);
	}
	
	
	public static Object[][] getContactNameFromSheet(String sheetname){
		
		FileInputStream file = null;
		try{
			file = new FileInputStream("/Users/honasa/Downloads/contacts.xlsx");
			
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		}
		catch(InvalidFormatException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetname);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			for(int j=0; j<sheet.getRow(i).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
}
