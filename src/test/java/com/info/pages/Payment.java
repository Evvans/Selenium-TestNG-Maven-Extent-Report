package com.info.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.info.TestBase.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Test;

public class Payment extends TestBase{
	
	
	WebDriver driver;
	
	public Payment(WebDriver driver)
	{
		this .driver=driver;
	}
	
	
	@FindBy(how=How.NAME,using="Source_bank")
	WebElement source_bank;
	
	@FindBy(how=How.NAME,using="Dest_bank")
	WebElement Dest_bank;
	
	@FindBy(how=How.NAME,using="Cust_Name")
	WebElement Cust_Name;
	
	@FindBy(how=How.XPATH,using=".//input[@name='Sorce_acc']")
	WebElement Source_Acc;
	
	@FindBy(how=How.XPATH,using=".//input[@name='Dest_acc']")
	WebElement Dest_Acc;
	
	@FindBy(how=How.XPATH,using=".//input[@name='amount']")
	WebElement Amount;
	
	@FindBy(how=How.NAME,using="username")
	WebElement Username;
	
	@FindBy(how=How.NAME,using="password")
	WebElement Password;
	
	@FindBy(how=How.ID,using="alert_button")
	WebElement btn_submit;
	
	@FindBy(how=How.XPATH,using=".//*[@id='popup_message']")
	WebElement msg;
	
	@FindBy(how=How.XPATH,using=".//*[@id='popup_ok']")
	WebElement btn_OK;
	
	
	
	
	public void to_Fill_Payment_Details(String name,String SorceAc,String DestAc,String AmountTrans,String uname,String upassword)
	{
	
		Select s_bank=new Select(source_bank);
		s_bank.selectByIndex(2);
		
		Select d_bank=new Select(Dest_bank);
		d_bank.selectByIndex(3);
		
		Cust_Name.sendKeys(name);
		test.log(LogStatus.INFO, "Customer has enter Customer Name as"+name);
		Source_Acc.sendKeys(SorceAc);
		test.log(LogStatus.INFO, "Customer has Source Ac no  as"+name);
		Dest_Acc.sendKeys(DestAc);
		test.log(LogStatus.INFO, "Customer has SourDestination Ac no  as"+name);
		Amount.sendKeys(AmountTrans);
		test.log(LogStatus.INFO, "Customer has enter amount as"+name);
		Username.sendKeys(uname);
		test.log(LogStatus.INFO, "Customer has username as"+uname);
		Password.sendKeys(upassword);
		test.log(LogStatus.INFO, "Customer has enter Paswsowrd as"+upassword);
		btn_submit.click();
		
		to_verify_Payment();
		
	}
	
	public boolean to_verify_Payment()
	{
		for (String handle1 : driver.getWindowHandles()) {
			//System.out.println(handle1);
			driver.switchTo().window(handle1);
		}
		String text=msg.getText();
		System.out.println("Messag eis"+text);
		if(text.contains("Transfer"))
		{
			//System.out.println("Successful transfer");
			btn_OK.click();
			Assert.assertTrue(true, "Amout Transfer");
			test.log(LogStatus.PASS," Payment Amount successfuly transfer");
			return true;
		}
		else
		{
			System.out.println("Issue with transfer");
			Assert.assertTrue(false, "Issue with Amout Transfer");
			test.log(LogStatus.FAIL, "Issue with payment transfer");
			return false;
		}
		
		
		
	}

}
