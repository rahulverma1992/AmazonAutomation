package com.amazon.pagefactory;

import com.amazon.core.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPageFactory extends AbstractPageFactory {

	@FindBy(xpath = "//h1[contains(text(),'About this item')]")
	WebElement aboutItem;

	@FindBy(xpath = "//*[@id=\"feature-bullets\"]/ul")
	WebElement aboutSection;

	public ProductDetailsPageFactory(WebDriver driver) {
		// This initElements method will create all WebElements
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void aboutThisItem() {
		Utility.waiting(driver);
		Utility.assertDisplayed(aboutItem);
		System.out.println("Value of about this item are:" + aboutSection.getText());
	}

}
