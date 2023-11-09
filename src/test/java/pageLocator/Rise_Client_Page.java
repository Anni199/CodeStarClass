package pageLocator;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Rise_Client_Page {

	public WebDriver driver;
	public WebDriverWait wait;

	// Constructor
	public Rise_Client_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	//WebElements Locators+identification	
	@FindBy(xpath="//a[normalize-space()='Add client']")
	WebElement btn_addClient;
	
	@FindBy(id="company_name")
	WebElement btn_companyname;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btn_save;
	
	@FindBy(xpath="//a[@role='presentation'][normalize-space()='Clients']")
	WebElement btn_client_tab;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement txt_search;
	
	// Action methods
	public void clickAddClient() {
		btn_addClient.click();
	}
	
	public void setCompanyName(String name) {
		btn_companyname.sendKeys(name);
	}
	
	public void clickSave() {
		btn_save.click();
	}
	
	public void clickClientTab() {
		btn_client_tab.click();
	}
	
	public void searchName(String compname) {
		txt_search.sendKeys(compname);
	}

}
