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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.info.pages.NewYahoopage;
import com.info.pages.Payment;
import com.info.TestBase.TestBase;
import com.info.pages.Registration;
import com.relevantcodes.extentreports.LogStatus;


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

	@Test(priority=1)
	@Parameters({"title","fname", "lname", "email", "mobile", "area_address", "cityname", "State", "pincode", "uname", "upassword"})
	public void customer_Registraion(String title,String fname,String lname,String email,String mobile,String area_address,String cityname,String State,String pincode,String uname,String upassword)
	{
		test=report.startTest("Customer Registration");
		test.log(LogStatus.INFO, "Test Started"+test.getStartedTime());
		registration.to_Fil_Customer_Registration_Details(title,fname, lname, email, mobile, area_address, cityname, State, pincode, uname, upassword);
		
	}
	@Test(priority=2)
	public void customer_Payment()
	{
		test=report.startTest("Customer Payment");
		test.log(LogStatus.INFO, "Test Started"+test.getStartedTime());
		payment.to_Fill_Payment_Details();
	}



}
