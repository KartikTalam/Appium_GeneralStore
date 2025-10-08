package com.genericLibraries;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class MobileGestures {
	
	//Mobile gesture to long press an Element
	public void longPress(WebElement element, AndroidDriver driver)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement)element).getId(), "duration", 2000));
	}
	
	//Mobile gesture to scroll based on the element
	public void scrollUntilElement(String elementText, AndroidDriver driver)
	{
		driver.findElements(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+ elementText +"\"));"));
	}
	
	//Swipe left mobile gesture
	public void swipeLeftGesture(WebElement element, AndroidDriver driver)
	{
		((JavascriptExecutor)driver).executeScript("mobile: swipeGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement)element).getId(), "direction", "left", "percent", 0.75));
	}
	
	//Swipe right mobile gesture
	public void swipeRightGesture(WebElement element, AndroidDriver driver)
	{
		((JavascriptExecutor)driver).executeScript("mobile: swipeGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement)element).getId(), "direction", "right", "percent", 0.75));
	}
	
	//Drag and drop an element based on the Source and destination elements
	public void dragAndDropElement(WebElement source, WebElement destination, AndroidDriver driver)
	{
	        int endX = destination.getLocation().getX() + (destination.getSize().getWidth() / 2);
	        int endY = destination.getLocation().getY() + (destination.getSize().getHeight() / 2);
	        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
				    "elementId", ((RemoteWebElement) source).getId(),
				    "endX", endX,
				    "endY", endY
				));
	}

}
