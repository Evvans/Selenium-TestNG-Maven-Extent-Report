package com.info.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewYahoopage {
	
	
	WebDriver driver;
	
	public NewYahoopage(WebDriver ldriver) 
	{
		 this.driver=ldriver;
		//PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using=".//input[@id='first_name']")
	//@FindBy(xpath="//input[@id='first_name']")
	 WebElement fr_name;
	@FindBy(name="last_name")
	public WebElement last_name1;
	
	public void toEnterRegistrationDetails(String name)
	{
		
		fr_name.sendKeys(name);
		last_name1.sendKeys("john");
		
		
	}

}
