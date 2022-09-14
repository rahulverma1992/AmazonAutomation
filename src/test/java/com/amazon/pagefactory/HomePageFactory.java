package com.amazon.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory extends AbstractPageFactory {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	@FindBy(id = "nav-hamburger-menu")
	WebElement hamburgerMenu;

	@FindBy(xpath = "//div[contains(text(),'shop by department')]")
	WebElement shopByDepartment;

	@FindBy(xpath = "//div[contains(text(),'TV, Appliances, Electronics')]")
	WebElement tvDepartment;

	public HomePageFactory(WebDriver driver) {
		// This initElements method will create all WebElements
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void openHamburgerMenu() {
		hamburgerMenu.click();
	}

}
