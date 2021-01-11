package com.script;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.library.BaseClass;
import com.pages.CartAndProductDetailspage;
import com.pages.Homepage;

public class ProductDetailsTestCase extends BaseClass {
	
	Homepage hom=new Homepage(driver);
	CartAndProductDetailspage cart=new CartAndProductDetailspage(driver);

	@Test(description="Verify info between product search screen vs checkout screen")
	public void PrdtDetailsValidation() throws Exception{
		
		CartAndProductDetailspage details =new CartAndProductDetailspage(driver);
	
		try{
		    hom.VerifyPrdtName();
		    hom.VerifyDescription();
		    hom.VerifyPrice();
		    //**Verify info between product search screen vs checkout screen **//
		    Assert.assertEquals(hom.VerifyPrdtName(), cart.VerifyTCLname());
		    Assert.assertEquals(hom.VerifyPrice(), cart.TCLRupee());
		}catch(Exception e){
			throw e;
		}
	}

}
