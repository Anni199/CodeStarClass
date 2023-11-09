package pageLocator;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Trizen_Bookflight_Page {

	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;

	// Constructor
	public Trizen_Bookflight_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		js = (JavascriptExecutor) driver;
	}

	//WebElements Locators+identification	
	@FindBy(xpath="//div[@id='one-way']//input[@name='daterange-single']")
	WebElement drp_date;
	
	@FindBy(xpath="(//input[@placeholder='City or airport'])[1]")
	WebElement txt_flyFrom;
	
	@FindBy(xpath="(//input[@placeholder='City or airport'])[2]")
	WebElement txt_flyTo;
	
	@FindBy(xpath="//div[@id='one-way']//a[@role='button']")
	WebElement drp_passenger;
	
	@FindBy(xpath="//div[@id='one-way']//div[@class='dropdown-menu dropdown-menu-wrap']//div[1]//div[1]//div[1]//div[2]//i[1]")
	WebElement btn_addAdult;
	
	@FindBy(xpath="(//a[contains(text(),'Search Now')])[1]")
	WebElement btn_search;
	
	@FindBy(xpath="//h2[normalize-space()='Flight Search Result']")
	WebElement txt_result;
	
	// Action methods
	public void chooseDate(String date) {
		js.executeScript("arguments[0].removeAttribute('readonly','readonly')", drp_date);
		drp_date.clear();
		drp_date.sendKeys(date);
		drp_date.sendKeys(Keys.TAB);
	}
	
	public void inputFlyFrom(String from) {
		txt_flyFrom.clear();
		txt_flyFrom.sendKeys(from);
	}
	
	public void inputFlyTo(String to) {
		txt_flyTo.clear();
		txt_flyTo.sendKeys(to);
	}
	
	public void addAdult() {
		drp_passenger.click();
		btn_addAdult.click();
	}
	
	public void searchFlight() {
		btn_search.click();
	}
	
	public boolean isResultPageShow()
	{
		try {
			return (txt_result.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}
	

}
