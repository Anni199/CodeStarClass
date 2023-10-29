package buoi12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import util.CommonFunction;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class HomeworkSelectAndDropdown extends CommonFunction {
	WebDriver driver;
	
	@BeforeClass
	void openSite() {
		driver = new ChromeDriver();
		openWebsite(driver,"http://demo.seleniumeasy.com/input-form-demo.html");
	}

	@Test(priority=1)
	public void homework12() throws InterruptedException {
		WebElement dropdownState=driver.findElement(By.xpath("//select[@name='state']"));
		Select drpState=new Select(dropdownState);
		WebElement radioHostingYes=driver.findElement(By.xpath("//input[@name='hosting' and @value='yes']"));
		List<WebElement> options=drpState.getOptions();
		System.out.println("total number of options: "+options.size());
		drpState.selectByVisibleText("New York");
		if (radioHostingYes.isSelected() == false) {
			radioHostingYes.click();
		} else {
			System.out.println("Radio button has been clicked before");
		}
		Thread.sleep(5000);
	}
	
	@Test(priority=2)
	public void dropdownTest() throws InterruptedException {
		openWebsite(driver,"https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
		
		WebElement dropdownDay=driver.findElement(By.xpath("//select[@id='select-demo']"));
		Select drpDay=new Select(dropdownDay);
		List<WebElement> options=drpDay.getOptions();
		System.out.println("total number of options: "+options.size());
		drpDay.selectByValue("Saturday");
		Thread.sleep(5000);
	}

	@AfterClass
	void closeWebsite() {
		driver.quit();
	}

}
