package com.qa.hubspot.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.BasePage.BasePage;
import com.qa.hubspot.Constant.Constant;
import com.qa.hubspot.Pages.HomePage;
import com.qa.hubspot.Pages.LoginPage;
import com.qa.hubspot.Utils.waitUtils;

public class HomePageTest extends BasePage{
	
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp()
	{
		basePage=new BasePage();
		prop=basePage.initializeProperties();
		driver=basePage.initializeDriver();
		driver.get(prop.getProperty("url"));
		loginPage=new LoginPage(driver);
		homePage=loginPage.loginToApplication(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=1, groups={"title1"})
	
	public void homePageTitleTest()
	{
		String title=homePage.getHomePageTitle();
		Assert.assertEquals(title, Constant.HOME_PAGE_TITLE);
	}
	@Test(priority=2)
	public void homePageHeaderTest()
	{
		String header=homePage.getHomePageHeader();
		
		Assert.assertEquals(header, Constant.HOME_PAGE_HEADER, "Invalid Header");
	}
	
	@Test(priority=3, groups={"navigateCon"})
	public void navigateToContactsTest()
	{
		homePage.navigateTOContactsPage();
		waitUtils.mediumWait();
	}
	
	@AfterMethod
	public void tearDown()
	
	{
		driver.quit();
	}

}
