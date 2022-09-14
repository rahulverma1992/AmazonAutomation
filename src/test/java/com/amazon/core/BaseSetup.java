package com.amazon.core;

import java.io.IOException;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseSetup {
	private static WebDriver driver;
	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest logger;

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
			// Create an object of Extent Report
			extent = new ExtentReports();
			spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
			extent.attachReporter(spark);
			extent.setSystemInfo("User Name", "Rahul Verma");
		} catch (Exception e) {
			System.out.println("Error....." + e.getMessage() + e);
		}
	}

	// To capture screenshot
	@AfterMethod
	public void getResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenShotPath = Utility.capture(driver, "ErrorOccurred");
			logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenShotPath));

		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}

	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
		extent.flush();
	}

}