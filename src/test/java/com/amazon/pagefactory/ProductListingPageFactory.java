package com.amazon.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.core.Utility;

public class ProductListingPageFactory extends AbstractPageFactory {
	public Utility utils;
	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	@FindBy(xpath = "//span[normalize-space()='Brands']")
	WebElement brands;
	
	@FindBy(xpath = "//*[@id=\"s-refinements\"]/div[21]/ul/li[5]/span/a/span")
	WebElement samsung;
	
	public ProductListingPageFactory(WebDriver driver) {
		// This initElements method will create all WebElements
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void filterSamsung()
	{
		utils = new Utility();
		// Scroll down to Brands
		utils.scrollDownToElement(brands, driver);
		samsung.click();
	}

}
