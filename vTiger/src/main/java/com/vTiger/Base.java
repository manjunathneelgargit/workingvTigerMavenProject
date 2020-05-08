package com.vTiger;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.vTiger.ObjectRepository.LoginPage;


public class Base 
{
	public FileLib flib = new FileLib();
	public WebDriver driver;
	public static WebDriver scrnDriver;
	public WebDriverWait wait;
	public LoginPage l;
	public Utility util = new Utility();
	
	@BeforeClass
	public void configBC()
	{
		if(flib.getPropertyKeyValue("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./src/main/java/com/vTiger/resources/chromedriver.exe");
			driver = new ChromeDriver();
			scrnDriver = driver;
		}
		else if(flib.getPropertyKeyValue("browser").equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./src/main/java/com/vTiger/resources/geckodriver.exe");
			driver = new FirefoxDriver();
			scrnDriver = driver;
		}
		else
		{
			System.setProperty("webdriver.ie.driver", "./src/main/java/com/vTigerMaven/resources/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			scrnDriver = driver;
		}
		
		driver.manage().window().maximize();
		driver.get(flib.getPropertyKeyValue("url"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);		
	}
	
	
	@BeforeMethod
	public void configBM()
	{
		l = PageFactory.initElements(driver, LoginPage.class);
		l.login(flib.getPropertyKeyValue("username"), flib.getPropertyKeyValue("password"));
	}
	
	@AfterMethod
	public void configAM()
	{
		l.logout(util, driver);
		
	}
	
	@AfterClass
	public void configAC()
	{
		driver.quit();
	}
	
	
}
