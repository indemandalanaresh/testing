package com.cpsbank.tests;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cpsbank.utils.Screenshot;

public class VerifyGetAccount {


	public static Logger log=Logger.getLogger(VerifyGetAccount.class); 
	public static WebDriver driver;
	Screenshot obj=new Screenshot();
	
@BeforeTest
	 public void openbrowser(){
		 
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\jaya lakshimi\\Desktop\\chromedriver.exe");
	driver=new ChromeDriver();
	DOMConfigurator.configure("log4j.xml");
	log.info("browser launched");
	driver.get("http://www.thelogicgrid.in/Banking/");
	log.info("navigate to the url");
	driver.manage().window().maximize();
	log.info("browser maximized");
}
	@Test
	public void openGetAccount() throws IOException{
		String x=".//*[@id='slider']/div[1]/div/div[";
		String y="]/div/div/div/div/a";
		obj.screenshot(driver,".\\src\\com\\cpsbank\\screenshots\\getaccount.png");
		
		log.info("click on get account today link");
	List<WebElement>account=driver.findElements(By.xpath("//*[@id='slider']/div[1]/div/div"));
	for (int i = 1; i <=account.size(); i++) {
		driver.findElement(By.xpath(x+i+y)).click();
	obj.screenshot(driver,".\\src\\com\\cpsbank\\screenshots\\getaccount1.png");
	}
	
}
	
@AfterTest
public void close(){
	
	driver.close();
	log.info("browser closed");
	}

}
