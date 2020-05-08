package com.vTiger;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.Base;
import com.vTiger.Utility;
import com.vTiger.ObjectRepository.CreateNewProductPage;
import com.vTiger.ObjectRepository.HomePage;
import com.vTiger.ObjectRepository.ProductsPage;

@Listeners(com.vTiger.ListenerImp.class)
public class CreateProductTest extends Base
{
	public HomePage hp;
	public ProductsPage pp;
	public CreateNewProductPage cnp;	
	public Utility util = new Utility();
	
	
	@DataProvider
	public Object[][] giveData()
	{
		return util.getAllData("./src/main/java/com/vTiger/testData/testData.xlsx", "Products");
	}
	
	@Test(dataProvider="giveData")
	public void createProductTest(String prodName, String man, String cat, String ven)
	{
		hp = PageFactory.initElements(driver, HomePage.class);
		pp = PageFactory.initElements(driver, ProductsPage.class);
		cnp = PageFactory.initElements(driver, CreateNewProductPage.class);
		
		hp.getProductsLink().click();
		pp.getCreateProductImg().click();
		
		cnp.createProduct(prodName, man, cat, ven, driver);
		
		System.out.println("Executed...");		
	}
}
