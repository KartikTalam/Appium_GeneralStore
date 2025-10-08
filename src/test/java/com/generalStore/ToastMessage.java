package com.generalStore;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.genericLibraries.BaseClass;

public class ToastMessage extends BaseClass {
	
	@Test
	public void validateToastMessage()
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toastMsg = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
		System.out.println("Toast message : " + toastMsg);
		Assert.assertEquals(toastMsg, "Please enter your name");
	}

}
