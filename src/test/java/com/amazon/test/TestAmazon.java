package com.amazon.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.amazon.pagefactory.*;
import com.amazon.core.BaseSetup;

public class TestAmazon extends BaseSetup {
	public WebDriver driver;
	HomePageFactory objHomePage;

	@BeforeSuite
	public void setUp() {
		driver = getDriver();
	}

	@Test
	public void productAboutTest() {
		objHomePage= new HomePageFactory(driver);
		objHomePage.verifyBasePageTitle("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", driver);
		objHomePage.openHamburgerMenu();
	}

}
