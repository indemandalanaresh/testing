package com.cpsbank.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cpsbank.utils.Screenshot;

public class VerifyLoginLink {
	public static Logger log=Logger.getLogger(VerifyUrl.class); 
	public static WebDriver driver;
	Screenshot obj=new Screenshot();
	FileInputStream file;
	Properties pr;
	
	
	@BeforeTest
	public void openbrowser() throws Exception{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\jaya lakshimi\\Desktop\\chromedriver.exe");
		driver=new ChromeDriver();
		
		file=new FileInputStream("CPSBank/src/properties/test.properties");
		pr=new Properties();
		pr.load(file);
		DOMConfigurator.configure("log4j.xml");
		log.info("browser launched");	

		driver.get("http://www.thelogicgrid.in/Banking");
		log.info("customer login page open");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		log.info("browser maximized");
	}
	@Test
	public void login() throws Exception{
		
		driver.findElement(By.xpath(pr.getProperty("login"))).click();
		log.info("account login page open");
		String expected="Peace | Insurance Responsive Template";
		String actual=driver.getTitle();
		Assert.assertEquals(actual, expected);
		obj.screenshot(driver,"./screenshots/logiin21.png");		

	}
	@AfterTest
	public void close(){
		driver.close();
	}

}
