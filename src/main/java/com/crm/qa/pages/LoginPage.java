package com.crm.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	// Page Factory - OR (Object Repository)
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-small']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpLink;
	
	@FindBy(xpath="//a[@class='navbar-brand']")
	WebElement crmLogo;
	
	//Now initializing the PAGE OBJECTS/elements with the help of Page Factory ({{So creating Constructor first
	
	public LoginPage(){
		PageFactory.initElements(driver, this);  //bcz here driver had red line below webdriver driver in testbase class made public
	}
	
	// Actions/features of log in page:    // or different functionalities of log in page
	public String validateLoginPageTitle() {    //String bcz .getTitle returns string
		return driver.getTitle(); 
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();              // boolean bcz .isDisplayed returns true or false
	}
	
	public HomePage login(String usn, String pswd) {   // we passed two strings can write anyname but we used usn and pswd
		username.sendKeys(usn);
		password.sendKeys(pswd);
		loginBtn.sendKeys(Keys.ENTER);
		
		return new HomePage();
	}
	

}
