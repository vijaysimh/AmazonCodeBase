package com.pages;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	
	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;
	Log logger;

	public LoginPage(AndroidDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = (AndroidDriver<MobileElement>) driver;
		wait = new WebDriverWait(driver, 100);
	}
	
	@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/sign_in_button")
	public WebElement AmazonSignInButton;

	@AndroidFindBy(className="android.widget.EditText")
	public WebElement AmazonUserNameTextBox;
	
	@AndroidFindBy(className="android.widget.EditText")
	public WebElement AmazonPasswordTextBox;
	
	@AndroidFindBy(className="android.widget.Button")
	public WebElement Continue;
	
	@AndroidFindBy(className="android.widget.Button")
	public WebElement LoginButton;
	
	@AndroidFindBy(className="android.widget.Button")
	public WebElement LoginSubmitButton;
	
	/*Check whether AmazonPasswordTextBox is present*/
	public boolean isDisplayedAmazonPasswordTextBox()	  
	{
		wait.until(ExpectedConditions.visibilityOf(AmazonPasswordTextBox));
		System.out.println("AmazonPasswordTextBox is Displayed");
		return AmazonPasswordTextBox.isDisplayed();		
	}
	
	public boolean isDisplayedUserNameTextBox()	  
	{
		wait.until(ExpectedConditions.visibilityOf(AmazonUserNameTextBox));
		System.out.println("AmazonUserNameTextBox is Displayed");
		return AmazonUserNameTextBox.isDisplayed();		
	}
	
	public void DisplayedContinueButtonAndClick()	  
	{
		wait.until(ExpectedConditions.visibilityOf(Continue));
		System.out.println("Continue button is Displayed");
		Continue.click();
	}
	
	public void LoginButtonClick()	  
	{
		wait.until(ExpectedConditions.visibilityOf(LoginSubmitButton));
		System.out.println("Login button is Displayed");
		LoginSubmitButton.click();
	}
	
	/*Check whether SignInButton is present*/
	public boolean isDisplayedAmazonSignInButton()	
	{
		wait.until(ExpectedConditions.visibilityOf(AmazonSignInButton));
		System.out.println("password text Displayed");
		return AmazonSignInButton.isDisplayed();		
	}


}
