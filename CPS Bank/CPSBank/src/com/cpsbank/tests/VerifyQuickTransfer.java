package com.cpsbank.tests;

import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cpsbank.utils.Excel;
import com.cpsbank.utils.Screenshot;

public class VerifyQuickTransfer {


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
		System.out.println(ex);
		ex.excelSheet("./src/com/cpsbank/testdata/customer.xlsx","Quick Transfer");

		for (int i = 1; i <ex.rowc; i++) {

			WebElement element=driver.findElement(By.xpath(".//*[@id='bs-example-navbar-collapse-1']/ul/li[2]/a"));
			Actions action=new Actions(driver);
			action.moveToElement(element).build().perform();
			element=driver.findElement(By.xpath(".//*[@id='bs-example-navbar-collapse-1']/ul/li[2]/ul/li[1]/a"));
			action.moveToElement(element).click().build().perform();

			driver.findElement(By.id("accountNumber")).sendKeys(ex.wso.getRow(i).getCell(0).getStringCellValue());
			driver.findElement(By.id("IFSC")).sendKeys(ex.wso.getRow(i).getCell(1).getStringCellValue());
			driver.findElement(By.xpath(".//*[@id='tp-career-form']/div/div/div[3]/form/div[3]/label/label/input[1]")).click();
			Thread.sleep(5000);
			//	JavascriptExecutor je=(JavascriptExecutor)driver;
			//je.executeScript("scroll(0,400)");
			driver.findElement(By.xpath(".//*[@id='amount']")).sendKeys(ex.wso.getRow(i).getCell(2).getStringCellValue());
			driver.findElement(By.xpath(".//*[@id='tp-career-form']/div/div/div[3]/form/div[5]/button")).click();
			String x=driver.findElement(By.xpath(".//*[@id='tp-career-form']/div/div/div[2]/p")).getText();

			if (x.equalsIgnoreCase("Hi nareshSuccesfully transfered")) {
				ex.wso.createRow(i).createCell(4).setCellValue("pass");

				
			}
			else{
				ex.wso.createRow(i).createCell(4).setCellValue("fail");
			}
			FileOutputStream f=new FileOutputStream("./src/com/cpsbank/results/customer1.xlsx");
			ex.wbo.write(f);
		}
		
		ex.wbo.close();
	}

	@AfterMethod
	public void closeBrowser(){
		driver.close();
		log.info("browser closed");
	}

}
