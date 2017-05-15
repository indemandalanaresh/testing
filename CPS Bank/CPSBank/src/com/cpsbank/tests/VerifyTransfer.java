package com.cpsbank.tests;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cpsbank.utils.Screenshot;

public class VerifyTransfer {


	public static Logger log=Logger.getLogger(VerifyTransfer.class); 
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
		
		login.login(driver, "Naresh-Qa","password");
		log.info("login into transferpage");
	}
	@Test
	public void transfer() throws Exception{
		WebElement transfer=driver.findElement(By.xpath(".//*[text()='TRANSFER']"));
		log.info("mouse over on transfer module");
		Actions action=new Actions(driver);
		action.moveToElement(transfer).build().perform();
		obj.screenshot(driver,"C:\\Users\\jaya lakshimi\\Desktop\\reports\\verifytransfer\\transfer.png");
		String x=".//*[@id='bs-example-navbar-collapse-1']/ul/li[2]/ul/li[";
		String y="]/a";
		List<WebElement> list=driver.findElements(By.xpath(".//*[@id='bs-example-navbar-collapse-1']/ul/li[2]/ul/li"));
		int actuval =list.size();
		for (int i = 1; i <=list.size(); i++) {
			transfer=driver.findElement(By.xpath(x+i+y));
			action.moveToElement(transfer).build().perform();	
			System.out.println(transfer.getText());
		}
		Assert.assertEquals(actuval,"6");
	}
	
	@AfterTest
	public void close(){
		driver.close();
	}
}


