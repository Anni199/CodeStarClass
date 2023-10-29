package buoi12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import util.CommonFunction;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class RadioDemo extends CommonFunction {
	WebDriver driver;
	
	@BeforeClass
	void openSite() {
		driver = new ChromeDriver();
		openWebsite(driver,"https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
	}

	@Test(priority=1)
	public void radioCheck() throws InterruptedException {
		WebElement radioMale=driver.findElement(By.xpath("(//div[@class='panel-body'])[2]//label[@class='radio-inline']//input[1]"));
		if (radioMale.isEnabled() == false) {
			Thread.sleep(2000);
		}
		if (radioMale.isSelected() == false) {
			radioMale.click();
		}
		Thread.sleep(2000);
	}

	@AfterClass
	void closeWebsite() {
		driver.quit();
	}

}
