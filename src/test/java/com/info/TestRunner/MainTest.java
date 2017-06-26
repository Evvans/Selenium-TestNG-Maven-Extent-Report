package com.info.TestRunner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.info.pages.NewYahoopage;
import com.info.pages.Payment;
import com.info.TestBase.TestBase;
import com.info.pages.Registration;


public class MainTest extends TestBase{
	Registration registration ;
	Payment payment;
	
	@BeforeSuite
	public void launchApp()
	{	
		WebDriver driver=startBrowser("Firefox", "file:///E:/StudyWorkpace/ExtentReport_Demo/HTML_Pages/Registration.html");
		registration=PageFactory.initElements(driver, Registration.class);
		payment=PageFactory.initElements(driver, Payment.class);
	}

	@Test
	public void customer_Registraion()
	{
		//test=report.startTest("Customer Registration");
		//test.log(LogStatus.INFO, "Test Started"+test.getStartedTime());
		//driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Pravin");

		registration.to_Fil_Customer_Registration_Details();
		payment.to_Fill_Payment_Details();
		
	}



}
