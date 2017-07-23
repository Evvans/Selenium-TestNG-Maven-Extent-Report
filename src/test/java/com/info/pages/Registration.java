package com.info.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.info.TestBase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class Registration extends TestBase{
	
	 WebDriver driver;

	public Registration(WebDriver ldriver)
	{
	this.driver=ldriver;
		
	}
	
	//By First=By.xpath("//input[@name='first_name']");
	
	
	@FindBy(xpath="//select[@name='title']")
	@CacheLookup
	public WebElement select_title;
	@FindBy(xpath=".//input[@name='first_name']")
	public WebElement first_name1;
	@FindBy(name="last_name")
	public WebElement last_name;
	@FindBy(xpath="//input[@name='email']")
	public WebElement email_id;
	@FindBy(xpath="//input[@name='phone']")
	public WebElement phone_no;
	@FindBy(xpath="//input[@name='address']")
	public WebElement address;
	@FindBy(xpath="//input[@name='city']")
	public WebElement city;
	@FindBy(xpath="//select[@name='state']")
	public WebElement state;
	@FindBy(xpath="//input[@name='zip']")
	public WebElement zipcode;
	@FindBy(xpath="//input[@name='username']")
	public WebElement username;
	@FindBy(xpath="//input[@name='password']")
	public WebElement password;
	
	By Credit=By.xpath("//*[@name='hosting']");
	@FindBy(xpath="//*[@name='comment']")
	public WebElement comments;
	@FindBy(xpath=".//*[@id='btn_submit']")
	public WebElement btn_submit;
	
	public boolean to_Fil_Customer_Registration_Details(String title,String fname,String lname,String email,String mobile,String area_address,String cityname,String State,String pincode,String uname,String upassword)
	{
		
		
		Select s1=new Select(select_title);
		s1.selectByIndex(2);
		test.log(LogStatus.INFO, "User hasSelect Title");
		
		//System.out.println("In method");
		first_name1.sendKeys(fname);
		test.log(LogStatus.INFO, "User has enter first name As :"+fname);
		
		last_name.sendKeys(lname);
		test.log(LogStatus.INFO, "User has enter Last name As :"+lname);
		
		email_id.sendKeys(email);
		test.log(LogStatus.INFO, "User has enter email As :"+email);
		
		phone_no.sendKeys(mobile);
		test.log(LogStatus.INFO, "User has enter Mobile As :"+mobile);
		
		address.sendKeys(area_address);
		test.log(LogStatus.INFO, "User has enter Area address As :"+area_address);
		
		city.sendKeys(cityname);
		test.log(LogStatus.INFO, "User has enter City As :"+cityname);
		
		Select s2=new Select(state);
		s2.selectByIndex(3);
		zipcode.sendKeys(pincode);
		test.log(LogStatus.INFO, "User has enter Pincode As :"+pincode);
		
		username.sendKeys(uname);
		test.log(LogStatus.INFO, "User has enter Username As :"+uname);
		
		password.sendKeys(upassword);
		test.log(LogStatus.INFO, "User has enter password As :"+upassword);
		comments.sendKeys("don't having credit card");
		
		
		List<WebElement> rdBtn = driver.findElements(Credit);	
		boolean svalue=rdBtn.get(0).isSelected();
		//System.out.println("Value of"+svalue);
		if(!svalue==true)
		{	
		rdBtn.get(0).click();	
		
		}
		boolean status=btn_submit.isEnabled();
		if(status==true)
		{
			btn_submit.click();	
			Assert.assertTrue(true, "Submit button is enable on page");
			//test.log(LogStatus.PASS, "Submit button is enable on page");
			return true;
		}
		else
		{
			Assert.assertTrue(false, "Submit button is not enable on page");
			//test.log(LogStatus.FAIL, "Submit button is not enable on page");
			return false;
		}
		
	}
	
	
}
