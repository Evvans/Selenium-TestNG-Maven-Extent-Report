package com.info.TestRunner;

import org.testng.annotations.Test;

public class Grouping {
	
	
		  @Test (groups = { "Sanity" ,"Regression" },priority=1)
		  public void login() {
	
			  System.out.println("Login Execute Successfully");
		 
		  }
		 
		  @Test (groups = { "Sanity" ,"Regression" },priority=10)
		  public void logout() {
		 
			  System.out.println("Logout Execute Successfully");
		 
		  }
		 
		  @Test (groups = { "Sanity"},priority=2)
		  public void search() {
		 
			  System.out.println("Search Execute Successfully");		 
		  }
		 
		  @Test (groups = { "Sanity" ,"Regression" },priority=3)
		  public void advancedSearch() {
		 
			  System.out.println("advancedSearch Execute Successfully");
		 
		  }
		 
		  @Test (groups = {"Regression" },priority=4)
		  public void billPayment() {
		 
			  System.out.println("billPayment Execute Successfully");
		 
		  }
		  
		 
		  @Test (groups = {"Regression" },priority=5)	 
		  public void prepaidRecharge() {
		 
			  System.out.println("prepaidRecharge Execute Successfully");
		 
		  }
		 
		}


