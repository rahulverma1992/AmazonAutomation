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
	ProductDetailsPageFactory objProductDetailsPage;

	@BeforeSuite
	public void setUp() {
		driver = getDriver();
	}

	@Test
	public void productAboutTest() {
		objHomePage = new HomePageFactory(driver);
		objProductListingPage = new ProductListingPageFactory(driver);
		objProductDetailsPage = new ProductDetailsPageFactory(driver);
		logger = extent.createTest("To verify Amazon features");
		// Verify Amazon home page is opened
		objHomePage.verifyBasePageTitle(
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in",
				driver);
		logger.createNode("Amazon home page is opened");
		// Click on Hamburger Menu
		objHomePage.openHamburgerMenu();
		logger.createNode("Click on Hamburger Menu");
		// Scroll down to Shop by department and click on TV,Appliance and Electronics
		objHomePage.openTVDepartment();
		logger.createNode("Scroll down to Shop by department and click on TV,Appliance and Electronics");
		// Click on Television Category
		objHomePage.openTelevisionCategory();
		logger.createNode("Click on Television Category");
		// Filter category for Samsung products
		objProductListingPage.filterSamsung();
		logger.createNode("Click on Samsung filter");
		// Perform sorting High to Low
		objProductListingPage.sortHighToLow();
		logger.createNode("Perform sorting High to Low");
		objProductListingPage.getSecondHighestProductPrice();
		logger.createNode("Open Product details and print about this item in console");
		objProductDetailsPage.aboutThisItem();
	}

}
