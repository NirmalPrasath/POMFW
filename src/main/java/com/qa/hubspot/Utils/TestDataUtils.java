package com.qa.hubspot.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestDataUtils {
	
public static Workbook book;
public static Sheet sheet;

public static Object[][]getData(String sheetName)
{
	FileInputStream file = null;
	try {
		file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\hubspot\\TestData\\TestData.xlsx");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
	
			book=WorkbookFactory.create(file);
	}
	 catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
	}  catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	sheet=book.getSheet(sheetName);
	
	int row=sheet.getLastRowNum();
	int column=sheet.getRow(0).getLastCellNum();
	System.out.println("Row : "+row);
	
	System.out.println("Column : "+ column);
	
	Object[][]data=new Object[row][column];
	
	for(int i=0;i<row;i++)
	{
		for(int j=0;j<column;j++)
		{
			data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			
		}
	}
	return data;
	
	
}
	
}
