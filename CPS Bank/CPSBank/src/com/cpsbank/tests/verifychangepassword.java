package com.cpsbank.tests;

import java.io.IOException;
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

public class verifychangepassword {

	public static Logger log=Logger.getLogger(verifychangepassword.class); 
	public static WebDriver driver;
	Screenshot obj=new Screenshot();	
	Customerlogin login=new Customerlogin();

		@BeforeTest
		public void openBrowser(){
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\jaya lakshimi\\Desktop\\chromedriver.exe");
		driver=new ChromeDriver();
		DOMConfigurator.configure("log4j.xml");
		log.info("browser launched");	
		
		driver.get("http://www.thelogicgrid.in/Banking/loginCustomer.php");
		log.info("customer login page open");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		log.info("browser maximized");
		}
		@Test
		public void changePassword() throws Exception{
			
		login.login(driver,"Naresh-Qa", "password");
		log.info("change password page open");
		driver.findElement(By.xpath(".//*[@id='tp-header']/div/div/div[2]/a[1]")).click();
		driver.findElement(By.xpath(".//*[@id='oldPassword']")).sendKeys("password");
		driver.findElement(By.xpath(".//*[text()='Confirm Old Password']//following::input[1]")).sendKeys("password");
		driver.findElement(By.xpath(".//*[@id='amount']")).sendKeys("password");
	     driver.findElement(By.xpath(".//*[@type='submit']")).click();
	     log.info("changed password succefully");
	     obj.screenshot(driver,"C:\\Users\\jaya lakshimi\\Desktop\\reports\\verifychangepassword\\changpassword.png");
	    String actuval=driver.findElement(By.xpath("//*[@id='tp-career-form']/div/div/div[2]/h2[1]")).getText();
        Assert.assertEquals(actuval,"Successfully Changed Your Password");
	}
		@AfterTest
		public void closeBrowser(){
			driver.close();
		}

}
