package com.SeleniumDemo.Driver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Facebook.Pages.FaceBookLoginPageObjects;

import Configuration.SetConfig;
import ExcelDataFetching.ExcelDataConfig;


public class SeleniumDemo {

	public WebDriver driver;
	public SetConfig configprop;
	public SoftAssert Assertion;
	public FaceBookLoginPageObjects objects1;
	
	@BeforeTest(alwaysRun = true)

	public void setUp() throws Exception {

		configprop = new SetConfig();
		Assertion=new SoftAssert(); 
		
		System.setProperty("webdriver.gecko.driver", configprop.getFirefixDriverPath());
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		driver=new FirefoxDriver();		
		/*
		 * System.setProperty("webdriver.ie.driver", configprop.getIEDriver()); 
		 * driver = new InternetExplorerDriver();
		 */
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(dataProvider="PassData")
	
	public void testFacebooklogin(String Username, String Password) throws Exception {
		
		System.out.println("Test Case 1 Started");
		
		driver.get(configprop.getApplicationURL());
		FaceBookLoginPageObjects loginpage =PageFactory.initElements(driver, FaceBookLoginPageObjects.class);
		loginpage.login_facebook(Username, Password);
		
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Home')]")).isEnabled());
		
		//loginpage.logout_Facebook();
		
		System.out.println("Test Case 1 Ends");
	}
	
	@DataProvider(name = "PassData")

	public Object[][] passData() throws Exception {

		/*
		 * Object[][] arr = new Object[2][2];
		 * 
		 * arr[0][0]="nikhiljaltare@gmail.com"; arr[0][1]="nikhil";
		 * arr[1][0]="nikhiljaltare@gmail.com"; arr[1][1]="Dextermorgan1";
		 * 
		 * return arr;
		 */

		ExcelDataConfig config = new ExcelDataConfig(configprop.getTestDataPath() + "\\TS_001.xlsx");
		int rowCount = config.getRowCount("Login");
		Object[][] arr = new Object[rowCount][2];
		for (int i = 0; i < rowCount; i++) {
			arr[i][0] = config.getData("Login", i, 0);
			arr[i][1] = config.getData("Login", i, 1);
		}
		return arr;
	}

	@AfterTest(alwaysRun = true)

	public void tearDown() throws Exception {
		driver.close();
	}

}