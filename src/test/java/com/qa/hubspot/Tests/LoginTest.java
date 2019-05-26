package com.qa.hubspot.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.BasePage.BasePage;
import com.qa.hubspot.Constant.Constant;
import com.qa.hubspot.Pages.LoginPage;

public class LoginTest {
	
	public WebDriver driver;
	public Properties prop;
	public BasePage basePage;
	public LoginPage loginPage;
	
	@BeforeMethod
	public void setUp()
	{
		basePage=new BasePage();
		prop=basePage.initializeProperties();
		driver=basePage.initializeDriver();
		driver.get(prop.getProperty("url"));
		loginPage=new LoginPage(driver);
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title=loginPage.getLoginPageTitle();
		Assert.assertEquals(title, Constant.LOGIN_PAGE_TITLE, "Invalid Title");
		
	}
	
	@Test(priority=2)
	public void signUPLinkTest()
	{
		
		Assert.assertTrue(loginPage.signupLink(), "Not displayed");
		
	}
	
	@Test(priority=3)
	public void loginTest()
	{
		loginPage.loginToApplication(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
