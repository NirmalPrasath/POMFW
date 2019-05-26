package com.qa.hubspot.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.qa.hubspot.Constant.Constant;

public class waitUtils {
	
	public static WebDriver driver;
	public static WebDriverWait wait;

	public static void shortWait()
	{
		try {
			Thread.sleep(Constant.SHORT_WAIT);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void mediumWait()
	{
		try {
			Thread.sleep(Constant.Medium_WAIT);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void longWait()
	{
		try {
			Thread.sleep(Constant.LONG_Wait);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void waitForVisibilityOfTitle(WebDriver driver, String ti)
	{
	wait=new WebDriverWait(driver, 100);
	wait.until(ExpectedConditions.titleContains(ti));
				
	}
	
	public static void waitForVisibilityOfElement(WebDriver driver, WebElement ele)
	{
	wait=new WebDriverWait(driver, 100);
	wait.until(ExpectedConditions.visibilityOf(ele));
				
	}

	public static void waitForElementToBeClickable(WebDriver driver, WebElement ele)
	{
	wait=new WebDriverWait(driver, 100);
	wait.until(ExpectedConditions.elementToBeClickable(ele));
				
	}

}
