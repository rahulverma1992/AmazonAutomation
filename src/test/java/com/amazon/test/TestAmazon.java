package com.amazon.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.amazon.pagefactory.*;
import com.amazon.core.BaseSetup;

public class TestAmazon extends BaseSetup {
	public WebDriver driver;
	HomePageFactory objHomePage;
	ProductListingPageFactory objProductListingPage;

	@BeforeSuite
	public void setUp() {
		driver = getDriver();
	}

	@Test
	public void productAboutTest() {
		objHomePage = new HomePageFactory(driver);
		objProductListingPage = new ProductListingPageFactory(driver);
		// Verify Amazon home page is opened
		objHomePage.verifyBasePageTitle(
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in",
				driver);
		// Click on Hamburger Menu
		objHomePage.openHamburgerMenu();
		// Scroll down to Shop by department and click on TV,Appliance and Electronics
		objHomePage.openTVDepartment();
		//Click on Television Category
		objHomePage.openTelevisionCategory();
		//Verify Television Category is opened
		//objProductListingPage.verifyBasePageTitle("Buy the latest LED TVs, 4K TVs and Android TVs online at Best Prices in India-Amazon.in | Shop by size, price, features and more",driver);
		//Filter category for Samsung products
		objProductListingPage.filterSamsung();
	}

}
