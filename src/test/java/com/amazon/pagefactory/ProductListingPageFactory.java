package com.amazon.pagefactory;

import java.util.List;
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

	@FindBy(xpath = "//*[@id=\"a-autoid-0-announce\"]")
	WebElement sortBy;

	@FindBy(xpath = "//a[contains(.,'Price: High to Low')]")
	WebElement highToLow;

	@FindBy(xpath = "//div[@class=\"a-row a-size-base a-color-base\"]/a/span[@class=\"a-price\"]")
	List<WebElement> getAllProductPrices;

	public ProductListingPageFactory(WebDriver driver) {
		// This initElements method will create all WebElements
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void filterSamsung() {
		Utility.fluentWait(brands, driver);
		// Scroll down to Brands
		Utility.scrollDownToElement(brands, driver);
		Utility.fluentWait(samsung, driver);
		samsung.click();
	}

	public void sortHighToLow() {
		Utility.fluentWait(sortBy, driver);
		sortBy.click();
		highToLow.click();

	}

	public void getSecondHighestProductPrice() {
		Utility.waiting(driver);
		String currentHandle = driver.getWindowHandle();
		// Click the link which opens in a new window
		getAllProductPrices.get(1).click();
		Utility.windowHandle(currentHandle, driver);
	}
}
