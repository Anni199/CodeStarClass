package pageLocator;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Page {

	public WebDriver driver;
	public WebDriverWait wait;

	// Constructor
	public Login_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

//	Belong to https://rise.fairsketch.com/signin
	// WebElements Locators+identification
//	@FindBy(xpath = "//input[@id='email']")
//	WebElement txt_username;
//
//	@FindBy(xpath = "//input[@id='password']")
//	WebElement txt_password;
//
//	@FindBy(xpath = "//button[normalize-space()='Sign in']")
//	WebElement btn_signin;
//
//	@FindBy(xpath = "//div[@role='alert']")
//	WebElement alert_auth_failed;
//
//	// Action methods
//	public void setUserName(String username) {
//		txt_username.clear();
//		txt_username.sendKeys(username);
//	}
//
//	public void setPassword(String password) {
//		txt_password.clear();
//		txt_password.sendKeys(password);
//	}
//
//	public void clickSignin() {
//		btn_signin.click();
//	}
//
//	public boolean checkFailedAlert() {
//		boolean status = alert_auth_failed.isDisplayed();
//		return status;
//	}
	
	@FindBy(xpath="//input[@id='txtLoginUsername']")
	WebElement txt_loginusername;
	
	@FindBy(xpath="//input[@id='txtLoginPassword']")
	WebElement txt_loginpassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btn_submit;
	
	// Action methods
	public void setEmail(String email) {
		wait.until(ExpectedConditions.elementToBeClickable(txt_loginusername));
		txt_loginusername.sendKeys(email);
	}
	
	public void setPass(String pass) {
		wait.until(ExpectedConditions.elementToBeClickable(txt_loginpassword));
		txt_loginpassword.sendKeys(pass);
	}
	
	public void clickSubmit() {
		btn_submit.click();
	}

}
