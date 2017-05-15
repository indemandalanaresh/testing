package com.cpsbank.tests;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
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

public class VerifyDropdown {


	public static Logger log=Logger.getLogger(VerifyUrl.class); 
	public static WebDriver driver;
	Screenshot obj=new Screenshot();

	@BeforeTest
	public void openbrowser(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\jaya lakshimi\\Desktop\\chromedriver.exe");
		driver=new ChromeDriver();
		DOMConfigurator.configure("log4j.xml");
		log.info("browser launched");	
		driver.get("http://www.thelogicgrid.in/Banking/");
		log.info("cps home page open");
		driver.manage().window().maximize();
	}
	@Test
	public void openDropdown() throws Exception{
		WebElement ele=driver.findElement(By.className("dropdown-toggle")); 
		log.info("drop down list opend");
		Actions action=new Actions(driver);
		action.moveToElement(ele).build().perform();
		String x=".//*[@id='bs-example-navbar-collapse-1']/ul/li/ul/li[";
		String y="]/a";
		List<WebElement>list=driver.findElements(By.xpath(".//*[@id='bs-example-navbar-collapse-1']/ul/li/ul/li"));
		int actual=list.size();
		for (int i = 1; i <=list.size(); i++) {
			ele=driver.findElement(By.xpath(x+i+y));
			action.moveToElement(ele).build().perform();
			System.out.println(ele.getText());
		}
		Assert.assertEquals(actual,2);
		obj.screenshot(driver,"C:\\Users\\jaya lakshimi\\Desktop\\reports\\verifydropdown\\dropdown.png");		
	}
	@AfterTest
	public void close(){
		driver.close();
		log.info("driver  closed");
	}
}








