package constant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard_Page {

	public WebDriver driver;

	// Constructor
	public Dashboard_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElements Locators+identification
	@FindBy(xpath = "//a[@id='user-dropdown']")
	WebElement drp_profile;

	@FindBy(xpath = "//a[normalize-space()='Sign Out']")
	WebElement btn_signout;

	// Action methods
	public void clickLogout() {
		drp_profile.click();
		btn_signout.click();
	}

}
