package com.vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vTiger.Utility;

public class CreateNewProductPage 
{
	public Utility util = new Utility();
	
	
	@FindBy(name="productname")
	private WebElement productNameEB;
	
	@FindBy(name="manufacturer")
	private WebElement manufacturerSDD;
	
	@FindBy(name="productcategory")
	private WebElement productCategorySDD;
	
	@FindBy(xpath="//input[@name='vendor_name']/following-sibling::img")
	private WebElement vendorImg;
	
	@FindBy(id="my_file_element")
	private WebElement chooseFileBtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//a[contains(text(),'Vendor Name')]/../../../tr[2]/td/a")
	private WebElement vendorNameLink;

	public WebElement getProductNameEB() {
		return productNameEB;
	}

	public WebElement getManufacturerSDD() {
		return manufacturerSDD;
	}

	public WebElement getProductCategorySDD() {
		return productCategorySDD;
	}

	public WebElement getVendorImg() {
		return vendorImg;
	}

	public WebElement getChooseFileBtn() {
		return chooseFileBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createProduct(String productName, String manufacturer,String productCategory, String vendor,WebDriver driver)
	{
		productNameEB.sendKeys(productName);
		util.selectByValue(manufacturerSDD, manufacturer);
		util.selectByValue(productCategorySDD, productCategory);
		vendorImg.click();
		String pid = util.switchToNewWindow(driver);
		vendorNameLink.click();
		driver.switchTo().window(pid);
		saveBtn.click();	
	}
	
	
}
