package com.vTiger.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage 
{
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createProductImg;

	public WebElement getCreateProductImg() {
		return createProductImg;
	}
	
	
}
