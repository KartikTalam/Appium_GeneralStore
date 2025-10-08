package com.browserTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.genericLibraries.BrowserBaseClass;

public class AngularApp extends BrowserBaseClass{
	
	@Test
	public void launchBrowser()
	{
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("cars");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

}
