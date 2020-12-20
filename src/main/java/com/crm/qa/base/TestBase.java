package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver; //////////////////////////////SEE GLoBaL and LoCaL//////////////////////////////
	public static Properties prop;  // both made public later so that can be used in child class as well

	/*public TestBase() throws IOException {  // constructor of TestBase class
		
		prop = new Properties();          //////////////////////////////SEE GLoBaL and LoCaL//////
		FileInputStream ip = new FileInputStream("C:\\Selenium_Workspace\\FreeCRMTest\\src\\main\\"
				+ "java\\com\\crm\\qa\\config\\config.properties");
		prop.load(ip);
	}*/
	
	public static void initialization() throws IOException {
		
		prop = new Properties();          //////////////////////////////SEE GLoBaL and LoCaL//////
		FileInputStream ip = new FileInputStream("C:\\Selenium_Workspace\\FreeCRMTest\\src\\main\\"
				+ "java\\com\\crm\\qa\\config\\config.properties");
		prop.load(ip);
		
		//System.out.println(prop.getProperty("browser"));
		String browName = prop.getProperty("browser");
		
		if(browName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if (browName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		}else {
			System.out.println("No browser value found");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		// Removed the hard-coded values by creating a TestUtil CLASS in above two lines 
		
		driver.get(prop.getProperty("url"));//can use prop in initializaton as well bcz we have defined 
		                                    // it at global level
	}
}
