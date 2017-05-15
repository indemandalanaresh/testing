package com.cpsbank.tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cpsbank.utils.Screenshot;

public class VerifyUrl {

		public static Logger log=Logger.getLogger(VerifyUrl.class); 
		public static WebDriver driver;
		Screenshot obj=new Screenshot();
		
	@BeforeTest
		 public void openbrowser(){
			 
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\jaya lakshimi\\Desktop\\chromedriver.exe");
		driver=new ChromeDriver();
		DOMConfigurator.configure("log4j.xml");
		log.info("browser launched");
	}
	@Test
	public void navigateUrl() throws Exception{
		
		
		driver.get("http://www.thelogicgrid.in/Banking/");
		log.info("navigate to the url");
		driver.manage().window().maximize();
		log.info("browser maximized");
		String expected="CPS BANK";
		String actual=driver.getTitle();
		Assert.assertEquals(actual, expected);
		obj.screenshot(driver, "C:\\Users\\jaya lakshimi\\Desktop\\reports\\verifyurl\\url.png");
		}
		@AfterTest
		public void closeBrowser(){
			
		driver.close();
		log.info("browser closed");
	}

}
