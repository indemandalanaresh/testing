package com.nareshmaven.example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {
	public static WebDriver driver;
	
	@BeforeTest
	public void openBrowser(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\jaya lakshimi\\Desktop\\chromedriver.exe");
		driver=new ChromeDriver();
		
		

		driver.get("http://www.thelogicgrid.in/Banking");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
	}
@Test
public void login(){
	driver.findElement(By.xpath(".//*[@id='tp-header']/div/div/div[2]/a")).click();
	String expected="Peace | Insurance Responsive Template";
	String actual=driver.getTitle();
	Assert.assertEquals(actual, expected);

}
@AfterMethod
public void close(){
	driver.close();
}

}
