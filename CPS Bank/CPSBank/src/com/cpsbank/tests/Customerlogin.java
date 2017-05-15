package com.cpsbank.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Customerlogin {
	public void login(WebDriver driver,String user,String pass){
	driver.findElement(By.id("userId")).sendKeys(user);
	driver.findElement(By.id("password")).sendKeys(pass);
	driver.findElement(By.id("submit")).click();

}
}