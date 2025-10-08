package com.generalStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.genericLibraries.BaseClass;


public class LongPressTermsAndConditions extends BaseClass{
	
	@Test
	public void addProductToCart()
	{		
		double totalPrice = 0;
		String[] products = {"Jordan Lift Off", "PG 3"};

		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		mobileGesture.scrollUntilElement("Austria", driver);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Austria']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Test_Demo");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		for (String product : products) 
		{
			mobileGesture.scrollUntilElement(product, driver);
			driver.findElement(By.xpath("//android.widget.TextView[@text='" + product + "']/following-sibling::android.widget.LinearLayout//android.widget.TextView[@text='ADD TO CART']")).click();
			String prodprice = driver.findElement(By.xpath("//android.widget.TextView[@text='" + product + "']/parent::android.widget.LinearLayout/descendant::android.widget.TextView[contains(@resource-id,'productPrice')]")).getText();
			double productprice = Double.parseDouble(prodprice.replace("$",""));
			totalPrice += productprice;
		}
		
		System.out.println("Total Price : " + totalPrice);
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		String purchaseamt = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double purchaseAmount = Double.parseDouble(purchaseamt.replace("$",""));
		
		System.out.println("Purchase Amount : " + purchaseAmount);
		
		Assert.assertEquals(purchaseAmount, totalPrice);
		
		WebElement termsAndConditions = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		mobileGesture.longPress(termsAndConditions, driver);
		
		driver.findElement(By.className("android.widget.Button")).click();
				
	}

}