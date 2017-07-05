package com.info.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.info.TestBase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class Registration extends TestBase{
	
	final WebDriver driver;

	public Registration(WebDriver ldriver)
	{
	this.driver=ldriver;
		
	}
	
	//By First=By.xpath("//input[@name='first_name']");
	
	
	@FindBy(xpath="//select[@name='title']")
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
		
		System.out.println("In method");
		first_name1.sendKeys("Pravin");
		last_name.sendKeys("Kale");
		email_id.sendKeys("pravin@gmail.com");
		phone_no.sendKeys("9878786546");
		address.sendKeys("Aundh,Pune");
		city.sendKeys("Pune");
		Select s2=new Select(state);
		s2.selectByIndex(3);
		zipcode.sendKeys("431234");
		username.sendKeys("Pravin");
		password.sendKeys("Kale");
		comments.sendKeys("don't having credit card");
		
		
		List<WebElement> rdBtn = driver.findElements(Credit);	
		boolean svalue=rdBtn.get(0).isSelected();
		System.out.println("Value of"+svalue);
		if(!svalue==true)
		{	
		rdBtn.get(0).click();	
		
		}
		boolean status=btn_submit.isEnabled();
		if(status==true)
		{
			btn_submit.click();	
			Assert.assertTrue(true, "Submit button is enable on page");
			test.log(LogStatus.PASS, "Submit button is enable on page");
			return true;
		}
		else
		{
			Assert.assertTrue(false, "Submit button is not enable on page");
			test.log(LogStatus.FAIL, "Submit button is not enable on page");
			return false;
		}
		
	}
	
	
}
