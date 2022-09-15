package com.amazon.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazon.core.Utility;

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

	@FindBy(xpath = "//div[contains(text(),'tv, audio & cameras')]")
	WebElement tvAudioDepartment;

	@FindBy(xpath = "//a[contains(text(),'Televisions')]")
	WebElement televisons;

	public HomePageFactory(WebDriver driver) {
		// This initElements method will create all WebElements
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void openHamburgerMenu() {
		Utility.fluentWait(hamburgerMenu, driver);
		hamburgerMenu.click();
	}

	public void openTVDepartment() {
		Utility.fluentWait(shopByDepartment, driver);
		// Scroll down to Shop By Department
		Utility.scrollDownToElement(shopByDepartment, driver);
		Utility.fluentWait(tvDepartment, driver);
		// Click on TV department
		tvDepartment.click();
		Utility.waiting(driver);
	}

	public void openTelevisionCategory() {
		Utility.fluentWait(televisons, driver);
		televisons.click();
	}

}
