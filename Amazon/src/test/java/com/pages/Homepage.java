package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Homepage {
	
	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;

	public Homepage(AndroidDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = (AndroidDriver<MobileElement>) driver;
		wait = new WebDriverWait(driver, 70);
	}
	
	@AndroidFindBy(className="android.widget.EditText")
	public WebElement SearchBox;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, '65 inch tv 4k')]")
	public WebElement Inch65;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'TCL 163.9 cm')]")
	public WebElement ItemnameTCL;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'TCL')]")
	public WebElement DescriptionTCL;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, '87,999.00')]")
	public WebElement PriceTCL;

	
	public boolean VerifySearchBarDisplayed()	  
	{
		wait.until(ExpectedConditions.visibilityOf(SearchBox));
		System.out.println("SearchBox is Displayed");
		return SearchBox.isDisplayed();		
	}
	
	public String VerifyPrdtName()	  
	{
		wait.until(ExpectedConditions.visibilityOf(ItemnameTCL));
		String prdtname = ItemnameTCL.getText();
		return prdtname;
	}
	public String VerifyDescription()	  
	{
		wait.until(ExpectedConditions.visibilityOf(DescriptionTCL));
		String DescTCL = DescriptionTCL.getText();
		return DescTCL;
	}
	
	public String VerifyPrice()	  
	{
		wait.until(ExpectedConditions.visibilityOf(PriceTCL));
		String PrcTCL = PriceTCL.getText();
		return PrcTCL;

	}
	
	public void ItemNameTCL() throws InterruptedException	  
	{
		wait.until(ExpectedConditions.visibilityOf(ItemnameTCL));
		ItemnameTCL.click();
	}
	
	public void EnterProductName() throws InterruptedException	  
	{
		wait.until(ExpectedConditions.visibilityOf(SearchBox));
		SearchBox.click();
		SearchBox.sendKeys("65");
		Thread.sleep(3000);
	}
	
	public void tapOnPrdt()	  
	{
		wait.until(ExpectedConditions.visibilityOf(Inch65));
		Inch65.click();
	}
	
	


}
