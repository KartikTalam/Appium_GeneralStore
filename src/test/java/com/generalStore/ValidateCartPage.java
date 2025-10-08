package com.generalStore;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.genericLibraries.BaseClass;

public class ValidateCartPage extends BaseClass{
	
	@Test
	public void addProductToCart()
	{
		
		String productName = "Jordan Lift Off";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		mobileGesture.scrollUntilElement("Belgium", driver);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Belgium']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Test_Demo");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();		
		mobileGesture.scrollUntilElement(productName, driver);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + productName + "']/following-sibling::android.widget.LinearLayout//android.widget.TextView[@text='ADD TO CART']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		String cartProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(cartProduct, productName);
				
	}

}
