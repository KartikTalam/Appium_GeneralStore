package com.generalStore;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.genericLibraries.BaseClass;


public class WebHandle extends BaseClass{
	
	@Test
	public void addProductToCart() throws Exception
	{		
		double totalPrice = 0;
		String[] products = {"Jordan Lift Off"};

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
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		Thread.sleep(10000);
		
		Set<String> context = driver.getContextHandles();
		for(String name : context)
		{
			System.out.println(name);
		}
		
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("cars");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
				
	}

}