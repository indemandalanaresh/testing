package com.cpsbank.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class VerifyImpsTrasfer {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\jaya lakshimi\\Desktop\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.thelogicgrid.in/Banking/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='tp-header']/div/div/div[2]/a")).click();
		
		driver.findElement(By.id("userId")).sendKeys("Naresh-Qa");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("submit")).click();
		WebElement element=driver.findElement(By.xpath(".//*[@id='bs-example-navbar-collapse-1']/ul/li[2]/a"));
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
		element=driver.findElement(By.xpath(".//*[@id='bs-example-navbar-collapse-1']/ul/li[2]/ul/li[4]/a"));
	}

}
