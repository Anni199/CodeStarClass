package pageLocator;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Userinfo_Page {

	public WebDriver driver;
	public WebDriverWait wait;

	// Constructor
	public Userinfo_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	//WebElements Locators+identification	
	@FindBy(xpath="//input[@id='txtpassword']")
	WebElement txt_password;
	
	@FindBy(xpath="//input[@id='txtnewpass']")
	WebElement txt_newpassword;
	
	@FindBy(xpath="//input[@id='txtrenewpass']")
	WebElement txt_confirmpassword;
	
	@FindBy(xpath="//button[contains(text(),'Lưu mật khẩu mới')]")
	WebElement btn_submit;
	
	// Action methods
	public void setCurrentPass(String pass) {
		wait.until(ExpectedConditions.elementToBeClickable(txt_password));
		txt_password.sendKeys(pass);
	}
	
	public void setNewPass(String pass) {
		txt_newpassword.sendKeys(pass);
		txt_confirmpassword.sendKeys(pass);
	}
	
	public void clickSubmit() {
		btn_submit.click();
	}

}
