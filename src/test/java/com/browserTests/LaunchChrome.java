package com.browserTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.genericLibraries.BrowserBaseClass;

public class LaunchChrome extends BrowserBaseClass {

	@Test
	public void rahulShettyAngular() 
	{
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.className("navbar-toggler-icon")).click();
		driver.findElement(By.xpath("//a[text()='Products ']")).click();
		WebElement devops = driver.findElement(By.xpath("//a[text()='Devops']"));
		
		browserUtils.scrollTillElement(devops, driver);

	}

}
