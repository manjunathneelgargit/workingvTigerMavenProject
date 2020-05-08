package com.vTiger.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage 
{
	@FindBy(linkText="Products")
	private WebElement productsLink;

	public WebElement getProductsLink() {
		return productsLink;
	}
	
	
	
	
}
