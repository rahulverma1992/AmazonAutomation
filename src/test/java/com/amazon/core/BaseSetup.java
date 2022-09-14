package com.amazon.core;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseSetup {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	private void setDriver(String browserType, String appURL) throws MalformedURLException {

		switch (browserType) {
		case "chrome":
			driver = initChromeDriver(appURL);
			break;
		case "firefox":
			driver = initFirefoxDriver(appURL);
			break;
		case "IE":
			driver = initIEDriver(appURL);
			break;
		default:
			driver = initFirefoxDriver(appURL);
		}
	}

	protected static WebDriver initChromeDriver(String appURL) {
		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	private static WebDriver initIEDriver(String appURL) {
		driver = WebDriverManager.iedriver().create();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	private static WebDriver initFirefoxDriver(String appURL) {
		driver = WebDriverManager.firefoxdriver().create();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	@Parameters({ "browserType", "appURL" })
	@BeforeSuite(alwaysRun = true)
	public void initializeTestBaseSetup(final String browserType, final String appURL) {
		try {
			setDriver(browserType, appURL);
		} catch (Exception e) {
			System.out.println("Error....." + e.getMessage() + e);
		}
	}

	@AfterSuite
	public void tearDown() {
		//driver.quit();
	}

}