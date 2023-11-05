package pageLocator;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Signup_Page {

	public WebDriver driver;
	public WebDriverWait wait;

	// Constructor
	public Signup_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	//WebElements Locators+identification
	@FindBy(xpath="//input[@id='txtFirstname']")
	WebElement txt_firstname;
	
	@FindBy(xpath="//input[@id='txtEmail']")
	WebElement txt_email;
	
	@FindBy(xpath="//input[@id='txtCEmail']")
	WebElement txt_confirmemail;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	WebElement txt_password;
	
	@FindBy(xpath="//input[@id='txtCPassword']")
	WebElement txt_confirmpassword;
	
	@FindBy(xpath="//input[@id='txtPhone']")
	WebElement txt_phone;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btn_submit;
	
	// Action methods
	public void setName(String name) {
		wait.until(ExpectedConditions.elementToBeClickable(txt_firstname));
		txt_firstname.sendKeys(name);
	}
	
	public void setEmail(String email) {
		txt_email.sendKeys(email);
		txt_confirmemail.sendKeys(email);
	}
	
	public void setPassword(String password) {
		txt_password.sendKeys(password);
		txt_confirmpassword.sendKeys(password);
	}
	
	public void setPhone(String number) {
		txt_phone.sendKeys(number);
	}
	
	public void clickSubmit() {
		btn_submit.click();
	}

}
