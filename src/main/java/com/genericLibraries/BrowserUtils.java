package com.genericLibraries;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;


public class BrowserUtils {
	
	//SCROLLING ACTION
		public void scrollTillElement(WebElement element, AndroidDriver driver)
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true)", element);
		}

}
