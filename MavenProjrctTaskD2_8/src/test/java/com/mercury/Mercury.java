package com.mercury;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mercury {
	static Logger log=Logger.getLogger(Register.class.getName());
	public WebDriver driver;
	Properties p=new Properties();
	@BeforeSuite
	public void browser() throws IOException
	{
		FileInputStream file=new FileInputStream("D:\\java eclipse\\core java 2-workspace\\MavenProjrctTaskD2_8\\src\\test\\java\\Mparameter.properties");
		p.load(file);
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		 driver=new ChromeDriver();
		log.debug("Open Browser");
	}
	@BeforeTest
	public void url()
	{
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		log.info("Open Url");
		
	}
	@BeforeClass
	public void max()
	{
		driver.manage().window().maximize();
	}
	@Test(priority = 1)
  
  public void f() {
		driver.findElement(By.name("firstName")).sendKeys(p.getProperty("val1"));
		driver.findElement(By.name("lastName")).sendKeys(p.getProperty("val2"));
		driver.findElement(By.name("phone")).sendKeys(p.getProperty("val3"));
		driver.findElement(By.id("userName")).sendKeys(p.getProperty("val4"));
		driver.findElement(By.name("address1")).sendKeys(p.getProperty("val5"));
		driver.findElement(By.name("city")).sendKeys(p.getProperty("val6"));
		driver.findElement(By.name("state")).sendKeys(p.getProperty("val7"));
		driver.findElement(By.name("postalCode")).sendKeys(p.getProperty("val8"));
		WebElement sel=driver.findElement(By.name("country"));
		Select s=new Select(sel);
		s.selectByVisibleText("INDIA");
		driver.findElement(By.name("email")).sendKeys(p.getProperty("val10"));
		driver.findElement(By.name("password")).sendKeys(p.getProperty("val11"));
		driver.findElement(By.name("confirmPassword")).sendKeys(p.getProperty("val12"));
		driver.findElement(By.name("submit")).click();
  }
	@Test(priority = 2)
	public void login()
	{
		driver.get("http://demo.guru99.com/test/newtours/");
		String s=driver.getTitle();
		log.debug("Title of web page is:: "+s);
		
		log.debug("login start");
		
		
		driver.findElement(By.name("userName")).sendKeys(p.getProperty("val10"));
		driver.findElement(By.name("password")).sendKeys(p.getProperty("val11"));
		driver.findElement(By.name("submit")).click();
		log.debug("login successfully");
	}
	@AfterSuite
	public void close()
	{
		driver.close();
	}

}


