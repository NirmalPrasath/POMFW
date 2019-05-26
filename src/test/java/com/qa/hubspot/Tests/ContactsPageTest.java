package com.qa.hubspot.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.BasePage.BasePage;
import com.qa.hubspot.Constant.Constant;
import com.qa.hubspot.Pages.Contacts;
import com.qa.hubspot.Pages.HomePage;
import com.qa.hubspot.Pages.LoginPage;
import com.qa.hubspot.Utils.TestDataUtils;

public class ContactsPageTest extends BasePage{
	
	
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	Contacts contactsPage;
	TestDataUtils testData;
	
	@BeforeMethod
	public void setUp()
	{
		basePage=new BasePage();
		prop=basePage.initializeProperties();
		driver=basePage.initializeDriver();
		driver.get(prop.getProperty("url"));
		loginPage=new LoginPage(driver);
		homePage=loginPage.loginToApplication(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage=homePage.navigateTOContactsPage();
		
	}
	
	@DataProvider(name="getTstData")
	public Object[][] getTestData()
	{
		Object [][] contactsTestData=TestDataUtils.getData("contacts");
		return contactsTestData;
		
	}
	
	@Test(priority=1)
	public void contactsPageTitleTest()
	{
		String title= contactsPage.getContactsTilte();
		Assert.assertEquals(title, Constant.CONTACTS_PAGE_TITLE);
	}
	
	
	@Test(priority=2)
	public void contactsPageHeaderTest()
	{
		String header= contactsPage.getContactsHeader();
		Assert.assertEquals(header, Constant.CONTACTS_HEADER);
	}
	
	@Test(priority=3)
	public void contactsTempletePageHeaderTest()
	{
		String header= contactsPage.NewContactsHeader();
		Assert.assertEquals(header, Constant.CREATE_New_CONTACT_HEADER);
	}
	
	
	
	@Test(priority=4, dataProvider="getTstData")
	public void createNewContactsTest(String emailId, String fName, String lName,String jobTit)
	{
		contactsPage.createNewContacts(emailId, fName, lName, jobTit);
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
