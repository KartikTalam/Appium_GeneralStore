package com.genericLibraries;

import java.io.File;
import java.net.URI;
import java.time.Duration;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BrowserBaseClass {

	AppiumDriverLocalService service;
	public AndroidDriver driver;

	protected BrowserUtils browserUtils;

	@BeforeClass
	public void initialConfiguration() {
		browserUtils = new BrowserUtils();
	}

	@BeforeTest
	public void configuration() throws Exception {
		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\Kartik\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();

		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 9 Pro");
		options.setChromedriverExecutable("C:\\Users\\Kartik\\eclipse-workspace\\Appium_GeneralStore\\src\\test\\resources\\chromedriver.exe");
		options.setCapability("browserName", "Chrome");
		
		
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
	}

	@AfterTest
	public void teardown() {
		service.close();
		driver.quit();
	}

}
