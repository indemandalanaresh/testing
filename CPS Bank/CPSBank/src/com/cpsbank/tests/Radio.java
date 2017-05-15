package com.cpsbank.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cpsbank.utils.Excel;
import com.cpsbank.utils.Screenshot;

public class Radio {
	public static Logger log=Logger.getLogger(VerifyTransferToOtherBank.class); 
	public static WebDriver driver;
	Screenshot obj=new Screenshot();
	Customerlogin login=new Customerlogin();
	Excel ex=new Excel();
	@BeforeMethod
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
	public void quickTransfer() throws Exception{
		
		WebElement element=driver.findElement(By.xpath(".//*[@id='bs-example-navbar-collapse-1']/ul/li[2]/a"));
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
		element=driver.findElement(By.xpath(".//*[@id='bs-example-navbar-collapse-1']/ul/li[2]/ul/li[1]/a"));
		action.moveToElement(element).click().build().perform();
		List<WebElement>radio=driver.findElements(By.xpath(".//input[@type='radio']"));
		for (WebElement web : radio) {
			System.out.println(web.getAttribute("innerHTML"));
			
		}
					
}
}