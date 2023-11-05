package pageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard_Page {

	public WebDriver driver;
	public Actions act;

	// Constructor
	public Dashboard_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		act=new Actions(driver);
	}

//	Belong to https://rise.fairsketch.com/signin
//	// WebElements Locators+identification
//	@FindBy(xpath = "//a[@id='user-dropdown']")
//	WebElement drp_profile;
//
//	@FindBy(xpath = "//a[normalize-space()='Sign Out']")
//	WebElement btn_signout;
//
//	// Action methods
//	public void clickLogout() {
//		drp_profile.click();
//		btn_signout.click();
//	}
	@FindBy(xpath="//a[contains(text(),'Đăng Ký')]")
	WebElement btn_signup;
	
	@FindBy(xpath="//a[contains(text(),'Đăng Nhập')]")
	WebElement btn_login;
	
	@FindBy(xpath="//div[@class='avatar2']")
	WebElement userAvatar;
	
	@FindBy(xpath="//a[contains(text(),'Chỉnh sửa thông tin')]")
	WebElement changeInfo;
	
	public void clickSignUp() {
		btn_signup.click();
	}
	
	public void clickLogin() {
		btn_login.click();
	}
	
	public void clickUserInfo() {
		act.moveToElement(userAvatar).moveToElement(changeInfo).click().perform();
	}

}
