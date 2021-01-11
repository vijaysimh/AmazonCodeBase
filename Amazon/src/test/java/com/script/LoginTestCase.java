package com.script;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.library.BaseClass;
import com.library.GenericClass;
import com.pages.Homepage;
import com.pages.LoginPage;

public class LoginTestCase extends BaseClass {

	@Test(description="Login to amazon application")
	public void LogintoAmazonApplication() throws Exception{
		
		LoginPage login=new LoginPage(driver);
		Homepage home=new Homepage(driver);
	
		try{
			Assert.assertTrue(login.isDisplayedAmazonSignInButton(),"The Amazon signIn button is displayed");
			login.AmazonSignInButton.click();
			login.isDisplayedUserNameTextBox();
			//login.AmazonUserNameTextBox.click();
			login.AmazonUserNameTextBox.sendKeys(GenericClass.getdataproperties("UName"));
			login.DisplayedContinueButtonAndClick();			
			Assert.assertTrue(login.isDisplayedAmazonPasswordTextBox(),"The Amazon password text field is displayed");
			login.AmazonPasswordTextBox.sendKeys(GenericClass.getdataproperties("Password"));
			login.LoginButtonClick();
			Assert.assertTrue(home.VerifySearchBarDisplayed(), "Displayed search bar at Homepage");
		}catch(Exception e){
			throw e;
		}
	}

}
