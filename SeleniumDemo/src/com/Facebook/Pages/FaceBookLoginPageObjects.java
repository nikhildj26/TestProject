package com.Facebook.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FaceBookLoginPageObjects {
	
	WebDriver driver;

	public FaceBookLoginPageObjects(WebDriver driver1) {
		this.driver=driver1;
	}
	
	@FindBy(how=How.XPATH, using="//input[@id='email']") 
	WebElement UserID;
	
	@FindBy(how=How.XPATH, using="//input[@data-testid='royal_pass']") 
	WebElement Password;
	
	@FindBy(how=How.XPATH, using="//input[@data-testid='royal_login_button']") 
	WebElement Login_Button;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Home')]")
	WebElement Home_Button;
	
	@FindBy(how=How.XPATH, using="//div[text()='Account Settings']")
	WebElement Logout_Anchor;
	
	@FindBy(how=How.XPATH, using="//span[@class='_54nh']")
	WebElement Logout_Button;
	
	public void login_facebook(String uid, String pass) {
		
		UserID.clear();
		UserID.sendKeys(uid);
		Password.clear();
		Password.sendKeys(pass);
		Login_Button.click();
		
	}
	
	public void logout_Facebook() {
		Logout_Anchor.click();
		Logout_Button.click();
	}
}
