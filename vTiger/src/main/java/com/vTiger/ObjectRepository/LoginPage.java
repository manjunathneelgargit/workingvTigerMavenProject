package com.vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vTiger.Utility;



public class LoginPage 
{
	@FindBy(name="user_name")
	private WebElement userNameEB;
	
	@FindBy(name="user_password")
	private WebElement passwordEB;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;

	@FindBy(xpath="//img[contains(@src,'user')]")
	private WebElement userIcon;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	public WebElement getUserIcon() {
		return userIcon;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public WebElement getUserNameEB() 
	{
		return userNameEB;
	}

	public WebElement getPasswordEB() 
	{
		return passwordEB;
	}

	public WebElement getLoginBtn() 
	{
		return loginBtn;
	}
		
	public void login(String userName, String password)
	{
		userNameEB.sendKeys(userName);
		passwordEB.sendKeys(password);
		loginBtn.click();
	}
	
	public void logout(Utility util,WebDriver driver)
	{
		util.moveToElement(driver, userIcon);
		signOutLink.click();
	}
	
}
