package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartAndProductDetailspage {
	
	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;

	public CartAndProductDetailspage(AndroidDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = (AndroidDriver<MobileElement>) driver;
		wait = new WebDriverWait(driver, 70);
	}
	
	@AndroidFindBy(xpath="//android.view.View[contains(@text, 'TCL 163.9 cm (65 inches)')]")
	public WebElement TCLPdtDetailPage;
	
	@AndroidFindBy(xpath="//android.widget.EditText[contains(@text, 'rupees 87,999)]")
	public WebElement TCLRupees;
	
	public String VerifyTCLname()	  
	{
		wait.until(ExpectedConditions.visibilityOf(TCLPdtDetailPage));
		String prdtnameTCL = TCLPdtDetailPage.getText();
		return prdtnameTCL;
	}
	public String TCLRupee()	  
	{
		wait.until(ExpectedConditions.visibilityOf(TCLRupees));
		String TCLRupee = TCLRupees.getText();
		return TCLRupee;
	}

}
