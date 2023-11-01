package constant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

	public WebDriver driver;

	// Constructor
	public Login_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElements Locators+identification
	@FindBy(xpath = "//input[@id='email']")
	WebElement txt_username;

	@FindBy(xpath = "//input[@id='password']")
	WebElement txt_password;

	@FindBy(xpath = "//button[normalize-space()='Sign in']")
	WebElement btn_signin;

	@FindBy(xpath = "//div[@role='alert']")
	WebElement alert_auth_failed;

	// Action methods
	public void setUserName(String username) {
		txt_username.clear();
		txt_username.sendKeys(username);
	}

	public void setPassword(String password) {
		txt_password.clear();
		txt_password.sendKeys(password);
	}

	public void clickSignin() {
		btn_signin.click();
	}

	public boolean checkFailedAlert() {
		boolean status = alert_auth_failed.isDisplayed();
		return status;
	}

}
