package com.amazon.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.core.Utility;

public class ProductListingPageFactory extends AbstractPageFactory {
	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	@FindBy(xpath = "//span[normalize-space()='Brands']")
	WebElement brands;
	
	@FindBy(xpath = "//span[@class='a-size-base a-color-base'][contains(.,'Samsung')]")
	WebElement samsung;
	
	@FindBy(xpath = "//span[@class='a-dropdown-label']")
	WebElement sortBy;
	
	@FindBy(xpath = "//a[contains(.,'Price: High to Low')]")
	WebElement highToLow;
	
	public ProductListingPageFactory(WebDriver driver) {
		// This initElements method will create all WebElements
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void filterSamsung()
	{
		// Scroll down to Brands
		Utility.scrollDownToElement(brands, driver);
		samsung.click();
		Utility.waiting(driver);
	}
	
	public void sortHighToLow()
	{
		sortBy.click();
		highToLow.click();
		
	}

}
