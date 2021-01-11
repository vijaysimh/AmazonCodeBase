package com.library;

import java.io.FileInputStream;
import java.util.Properties;

import com.library.BaseClass;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class GenericClass {
	public static String configprop=BaseClass.sDirpath+"\\config.properties";
	AndroidDriver<MobileElement> driver;


	//READ data from the config.properties
	
		public static String getdataproperties(String key){
			
			String svalue=null;
			Properties properties=new Properties();
			
			try{
				
					FileInputStream file=new FileInputStream(configprop);
					properties.load(file);
					svalue=properties.getProperty(key);
				
			}catch(Exception e){
				
			}
			return svalue;
			
		}
		
		//Scroll and Click on element
		public void scrollAndClick(String visibleText) {
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
		        }
		    }

