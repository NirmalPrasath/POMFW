package com.qa.hubspot.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.BasePage.BasePage;
import com.qa.hubspot.Constant.Constant;
import com.qa.hubspot.Utils.TestUtils;
import com.qa.hubspot.Utils.waitUtils;

public class HomePage extends BasePage{
	
	
	
	@FindBy(css=".private-header__heading")
	WebElement homePaheHeader;
	
	@FindBy(id="nav-primary-contacts-branch")
	WebElement mainContacts;
	
	@FindBy(id="nav-secondary-contacts")
	WebElement secondaryContacts;
	

	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String getHomePageTitle()
	{
		waitUtils.waitForVisibilityOfTitle(driver, Constant.HOME_PAGE_TITLE);
		//waitUtils.mediumWait();
		return driver.getTitle();
	}
	
	public String getHomePageHeader()
	{
		waitUtils.waitForVisibilityOfElement(driver, homePaheHeader);
		//waitUtils.mediumWait();
		return homePaheHeader.getText();
	}
	
	public Contacts navigateTOContactsPage()
	{
		waitUtils.mediumWait();
		waitUtils.waitForVisibilityOfElement(driver, mainContacts);
		TestUtils.clickEvent(mainContacts);
		//waitUtils.waitForVisibilityOfElement(secondaryContacts);
		waitUtils.mediumWait();
		TestUtils.clickEvent(secondaryContacts);
		
		return new Contacts(driver);
		
	}

}
