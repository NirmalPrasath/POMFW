package com.qa.hubspot.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.BasePage.BasePage;
import com.qa.hubspot.Constant.Constant;
import com.qa.hubspot.Utils.TestUtils;
import com.qa.hubspot.Utils.waitUtils;

public class Contacts extends BasePage{
	
	
	@FindBy(css=".private-header__heading")
	WebElement contactsHeader;
	
	@FindBy(xpath="//span[text()='Create contact']")
	WebElement contactsButton;
	
	@FindBy(css=".m-all-0")
	WebElement CreatecontactsTemplateHeader;
	
	@FindBy(xpath="//input[@data-field='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@data-field='firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@data-field='lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@data-field='jobtitle']")
	WebElement jobTitle;
	
	@FindBy(xpath="//li//span[text()='Create contact']")
	WebElement createNewContactBut;
	
	
	
	
	public Contacts(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getContactsTilte()
	{
		waitUtils.waitForVisibilityOfTitle(driver, Constant.CONTACTS_PAGE_TITLE);
		return driver.getTitle();
		
	}
	
	public String getContactsHeader()
	{
		waitUtils.waitForVisibilityOfElement(driver, contactsHeader);
		return contactsHeader.getText();
		
	}
	
	public String NewContactsHeader()
	{
		waitUtils.waitForElementToBeClickable(driver, contactsButton);
		TestUtils.clickEvent(contactsButton);
		
		waitUtils.waitForVisibilityOfElement(driver, CreatecontactsTemplateHeader);
		return CreatecontactsTemplateHeader.getText();
		
	}
	
	public void createNewContacts(String eMail, String firstNam, String lastNam, String jobTil)
	{
		waitUtils.waitForElementToBeClickable(driver, contactsButton);
		TestUtils.clickEvent(contactsButton);
		
		waitUtils.waitForElementToBeClickable(driver, email);
		TestUtils.sendKeysEvent(email, eMail);
		
		//waitUtils.waitForElementToBeClickable(firstName);
		TestUtils.sendKeysEvent(firstName, firstNam);
		
		//waitUtils.waitForElementToBeClickable(lastName);
		TestUtils.sendKeysEvent(lastName, lastNam);
		
		waitUtils.waitForElementToBeClickable(driver, jobTitle);
		TestUtils.sendKeysEvent(jobTitle, jobTil);
		waitUtils.shortWait();
		TestUtils.clickEvent(createNewContactBut);
		
	}

}
