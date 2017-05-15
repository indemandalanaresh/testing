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

public class VerifyCustomerLogin {

	public static Logger log=Logger.getLogger(VerifyCustomerLogin.class); 
	public  WebDriver driver;
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
	public void customerLogin() throws Exception{
		login.login(driver,"Naresh-Qa","password");
		log.info("transfer page opend");
		String actual=driver.findElement(By.xpath(".//*[@id='tp-career-form']/div/div/div[2]/h2[1]")).getText();
		Assert.assertEquals(actual,"Succesfully Logged In");
		obj.screenshot(driver,".\\screenshot\\customerlogin1.png");


	}
	@AfterTest
	public void closeBrowser(){
		driver.close();
		log.info("browser closed");
	}

}