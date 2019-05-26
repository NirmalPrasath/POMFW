package com.qa.hubspot.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.BasePage.BasePage;
import com.qa.hubspot.Utils.TestUtils;
import com.qa.hubspot.Utils.waitUtils;

public class LoginPage extends BasePage {

	@FindBy(id="username")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="loginBtn")
	WebElement loginButton;
	
	@FindBy(linkText="Sign up")
	WebElement signupLink;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
		
	}
	
	public boolean signupLink()
	{
		System.out.println("SignupLink" + signupLink);
		return signupLink.isDisplayed();	
	}
	
	public HomePage loginToApplication(String uname, String pwd)
	{
		waitUtils.waitForElementToBeClickable(driver, userName);
		TestUtils.sendKeysEvent(userName, uname);
		TestUtils.sendKeysEvent(password, pwd);
		TestUtils.clickEvent(loginButton);
		return  new HomePage(driver);
		
	}
	
	
}
