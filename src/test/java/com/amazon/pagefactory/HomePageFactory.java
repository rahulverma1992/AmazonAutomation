package com.amazon.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazon.core.Utility;

public class HomePageFactory extends AbstractPageFactory {
	public Utility utils;

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
		hamburgerMenu.click();
	}

	public void openTVDepartment() {
		utils = new Utility();
		// Scroll down to Shop By Department
		utils.scrollDownToElement(shopByDepartment, driver);
		// Click on TV department
		tvDepartment.click();
		utils.waiting(driver);
	}

	public void openTelevisionCategory() {
		televisons.click();
	}

}
