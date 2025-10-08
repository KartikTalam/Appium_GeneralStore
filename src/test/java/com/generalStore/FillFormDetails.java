package com.generalStore;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.genericLibraries.BaseClass;

public class FillFormDetails extends BaseClass{
	
	@Test
	public void formData() throws Exception
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		mobileGesture.scrollUntilElement("Belgium", driver);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Belgium']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Test_Demo");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Male']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	}

}
