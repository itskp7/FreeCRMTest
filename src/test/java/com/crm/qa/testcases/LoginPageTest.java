package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {  // created a constructor of this class
		super();              // used super keyword for calling the super class constructor
		                      // or constructor of test base class
	}
	// it wont give null pointer exception bcz we already called super class constructor where there is 
	// prop... method defined as we will be using prop in initialization
	@BeforeMethod
	public void setUp() throws IOException {
		initialization(); // called this method from the TestBase class/ from parent
		
		//LoginPage loginPage = new LoginPage(); // Now we created the object of login page class/ constructor
		loginPage = new LoginPage();            // but defined the variable at class level so that it can be
		                                       // used throughout the program
		                                      // same as Webdriver driver on the class level
	} ///CREATED THE OBJECT SO THAT WE CAN USE ITS METHOD HERE
	
	@Test (priority=1)
	public void loginPageTitleTest() {      // also bcz this("validateLoginPageTitle()") is non static we had to create object of LP class so that we 
		String title = loginPage.validateLoginPageTitle(); //can access all its methods and functions
		                                    // we used the object created above "loginPage"
		                       // and bcz it will return string so "String title" written later
		//Assert.assertEquals(title, "CRMPRO  - CRM software for customer relationship management, sales, and support.");
		                     // Assert will show that test case pass or fail
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");

	}
	
	@Test (priority=2)
	public void crmLogoImageTest() {
		boolean flag = loginPage.validateCRMImage(); //sameobject which was made used and bcz it returns boolean so...
		Assert.assertTrue(flag);
	}
	
	@Test (priority=3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password")); // so this will call
		 // (.login)   method and will enter username and pswd
		//BUT it returns homepage class object so We will create HomePage class object on top below
		// LoginPage loginPage  and then homePage  = above line
		//bcz.login returns object of homepage class
		
		// above line is like HomePage homPage = new HomePage();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();  // closing the browser
	}
	

}
