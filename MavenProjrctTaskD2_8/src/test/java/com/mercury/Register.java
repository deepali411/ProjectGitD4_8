package com.mercury;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Register {
	static Logger log=Logger.getLogger(Register.class.getName());
	public WebDriver driver;
	Properties p=new Properties();
	@BeforeSuite
	public void browser() throws IOException
	{
		FileInputStream file=new FileInputStream("D:\\java eclipse\\core java 2-workspace\\MavenProjrctTaskD2_8\\parameter.properties");
		p.load(file);
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		 driver=new ChromeDriver();
		log.debug("Open Browser");
	}
	@BeforeTest
	public void url()
	{
		driver.get("http://demowebshop.tricentis.com/register");
		log.info("Open Url");
		
	}
	@BeforeClass
	public void max()
	{
		driver.manage().window().maximize();
	}
	@Test(priority = 1)
	public void m1()
	{
		
		
		log.info("Start register");
		
		 
		    driver.findElement(By.xpath("//*[@id=\"gender-female\"]")).click();
          
	         driver.findElement(By.xpath("//div[@class=\"inputs\"]/child::input[1]")).sendKeys(p.getProperty("Firstname"));;
	          
	          driver.findElement(By.xpath("//input[@id=\"LastName\"]")).sendKeys(p.getProperty("Lastname"));;
	         
	          driver.findElement(By.xpath("//div[@class=\"inputs\"]/child::input[@name=\"Email\"]")).sendKeys(p.getProperty("Email"));;
	         
	          driver.findElement(By.xpath("//div[@class=\"inputs\"]/child::input[@id=\"Password\"]")).sendKeys(p.getProperty("Password"));;
	          
	          driver.findElement(By.xpath("//div[@class=\"inputs\"]/child::input[@name=\"ConfirmPassword\"]")).sendKeys(p.getProperty("Confirmpassword"));;
	      	
	          driver.findElement(By.xpath("//div[@class=\"buttons\"]/child::input[@id=\"register-button\"]")).click();;
		
	          log.info(" registered successfully");
		
	}
	
	@Test(priority = 2)
	public void login()
	{
		driver.get("http://demowebshop.tricentis.com/login");
		String s=driver.getTitle();
		log.debug("Title of web page is:: "+s);
		
		log.debug("login start");
		
		Assert.assertEquals("Demo Web Shop. Login", s);
		driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(p.getProperty("Email"));
		driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys(p.getProperty("Password"));
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")).click();
		log.debug("login successfully");
	}
	@AfterSuite
	public void close()
	{
		driver.close();
	}

}
