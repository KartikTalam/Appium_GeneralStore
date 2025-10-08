package com.generalStore;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.genericLibraries.BaseClass;

public class AddToCart extends BaseClass {

	@Test
	public void addProductToCart() {
		String productName = "Jordan Lift Off";
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		mobileGesture.scrollUntilElement("Belgium", driver);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Belgium']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Test_Demo");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		mobileGesture.scrollUntilElement(productName, driver);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + productName
				+ "']/following-sibling::android.widget.LinearLayout//android.widget.TextView[@text='ADD TO CART']"))
				.click();
	}

}
