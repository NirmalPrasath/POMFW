package com.qa.hubspot.extentreport;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.hubspot.Utils.TestUtils;



public class baseReport {

	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public TestUtils utils;
	
	@BeforeSuite
	public void reportConfig()
	{
		htmlReporter=new ExtentHtmlReporter("./ExtentReport/MyExtentReport"+System.currentTimeMillis() + ".HTML");
		
		htmlReporter.config().setDocumentTitle("Hubspot Test Report");
		htmlReporter.config().setReportName("Hubspot Regression Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent=new ExtentReports(); 
		
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Hoest", "Local");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester", "KSPLT");
		
	}
	
	@AfterMethod
	public void getResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			//extentTest.fail("Test Failed " + result.getName());
			extentTest.fail(MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
			TestUtils.getScreenShot(driver, result.getName());
			extentTest.fail(result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			extentTest.pass("Test Pass " + result.getName());
			extentTest.pass(MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
			
		}
		else
		{
			extentTest.skip("Test Skiped" + result.getName());
			extentTest.skip(MarkupHelper.createLabel(result.getName(), ExtentColor.YELLOW));
		}
	}
	
	@AfterSuite
	public void tearDown()
	{
		extent.flush();
		
	}
	
}
