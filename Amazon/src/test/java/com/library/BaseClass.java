package com.library;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
	
	public DesiredCapabilities Capabilities;
	public static  String sDirpath=System.getProperty("user.dir");
	public String apkfilepath=sDirpath+"\\APKFile\\Amazon_shopping.apk";
			
	public static  AndroidDriver driver;
	
	@SuppressWarnings("rawtypes")
	@BeforeMethod
	//   @Parameters({"port", "deviceName", "platformVersion","udid"})
	public void setup(){
		try{

		Capabilities=new DesiredCapabilities();
		Capabilities.setCapability("automationName","Appium");
		Capabilities.setCapability("platformName","Android");
		Capabilities.setCapability("deviceName","ba0bfc7a");
		Capabilities.setCapability("platformVersion","6.0");
		Capabilities.setCapability("app",apkfilepath);
		Capabilities.setCapability("noReset",true);
		Capabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");
		Capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), Capabilities);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
         Thread.sleep(10000);
 

		}catch(Exception e){
			
		e.printStackTrace();
	}
		//driver.startActivity(new Activity("com.amazon.mShop.android.shopping", "com.amazon.mShop.sso.SigninPromptActivity"));

	}
	
	
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	
	@AfterSuite
	public void stopappiumserver(){
	   System.out.println("Close");
		}

}
