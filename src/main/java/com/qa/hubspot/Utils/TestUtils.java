package com.qa.hubspot.Utils;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class TestUtils {
	
	public static void sendKeysEvent(WebElement ele, String val)
	{
		ele.sendKeys(val);
	}
	
	public static void clickEvent(WebElement ele)
	{
		ele.click();
	}
	
	
	public static File getScreenShot(WebDriver driver, String name)
	{
		
		TakesScreenshot tss=(TakesScreenshot) driver;
		
		File source=tss.getScreenshotAs(OutputType.FILE);
		File destination=new File("./Screenshot");
		
		try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destination;
		
		
	}

}
