package com.script;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.library.BaseClass;
import com.library.GenericClass;
import com.pages.Homepage;

public class HomeTestCase extends BaseClass {

	@Test(description="Search for item in pdt homePage")
	public void HomePageValidation() throws Exception{
		Homepage home = new Homepage(driver);		
		GenericClass generic=new GenericClass();
	
		try{
			Assert.assertTrue(home.VerifySearchBarDisplayed(),"Verify Search bar displayed");
			home.EnterProductName();
			home.tapOnPrdt();
			home.ItemNameTCL();
			generic.scrollAndClick("Add to Cart");
		}catch(Exception e){
			throw e;
		}
	}

}
