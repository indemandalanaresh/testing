package com.nareshmaven.example;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Testng {
	

		public static WebDriver driver;
		Actions action;
		@BeforeTest
		public void open(){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\jaya lakshimi\\Desktop\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("http://www.thelogicgrid.in/Banking");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		}

		@Test(priority=1,groups={"smoke"})
		public void login(){

			driver.findElement(By.xpath(".//*[@id='tp-header']/div/div/div[2]/a")).click();
			String expected="Peace | Insurance Responsive Template";
			String actual=driver.getTitle();
			Assert.assertEquals(actual, expected);


		}

		@Test(priority=2,groups={"regression","smoke"})
		public void customerLogin(){
			driver.findElement(By.xpath(".//*[@id='userId']")).sendKeys("Naresh-Qa");
			driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("password");
			driver.findElement(By.xpath(".//*[@id='submit']")).click();
			String actual=driver.findElement(By.xpath(".//*[@id='tp-career-form']/div/div/div[2]/h2[1]")).getText();
			Assert.assertEquals(actual,"Succesfully Logged In");


		}

		@Test(priority=3,groups={"regression"},dependsOnMethods={"customerLogin"})
		public void changePassword(){
			driver.findElement(By.xpath(".//*[@id='tp-header']/div/div/div[2]/a[1]")).click();
			driver.findElement(By.xpath(".//*[@id='oldPassword']")).sendKeys("password");
			driver.findElement(By.xpath(".//*[text()='Confirm Old Password']//following::input[1]")).sendKeys("password");
			driver.findElement(By.xpath(".//*[@id='amount']")).sendKeys("password");
			driver.findElement(By.xpath(".//*[@type='submit']")).click();
			String actuval=driver.findElement(By.xpath("//*[@id='tp-career-form']/div/div/div[2]/h2[1]")).getText();
			Assert.assertEquals(actuval,"Successfully Changed Your Password");
		}


		@Test(priority=4,groups={"regression"},dependsOnMethods={"customerLogin"})
		public void Transfer(){
			WebElement transfer=driver.findElement(By.xpath(".//*[text()='TRANSFER']"));
			action=new Actions(driver);
			action.moveToElement(transfer).build().perform();
			String x=".//*[@id='bs-example-navbar-collapse-1']/ul/li[2]/ul/li[";
			String y="]/a";
			List<WebElement> list=driver.findElements(By.xpath(".//*[@id='bs-example-navbar-collapse-1']/ul/li[2]/ul/li"));
			int actuval =list.size();
			for (int i = 1; i <=list.size(); i++) {
				transfer=driver.findElement(By.xpath(x+i+y));
				action.moveToElement(transfer).build().perform();	
			}
			Assert.assertEquals(actuval,"4");
		}

@AfterTest
public void close(){
	driver.close();
}


}