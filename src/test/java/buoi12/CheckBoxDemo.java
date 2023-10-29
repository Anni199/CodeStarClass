package buoi12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import util.CommonFunction;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class CheckBoxDemo extends CommonFunction {
	WebDriver driver;
	
	@BeforeClass
	void openSite() {
		driver = new ChromeDriver();
		openWebsite(driver,"https://demo.seleniumeasy.com/basic-checkbox-demo.html");
	}

	@Test(priority=1)
	public void checkDefaultBox() throws InterruptedException {
		WebElement checkDefault = driver.findElement(By.xpath("//label[normalize-space()='Default Checked']/input"));
		if (checkDefault.isSelected() == true) {
			System.out.println("Default checked");
		} else {
			System.out.println("Default hasn't been checked");
		}
		Thread.sleep(2000);
	}
	
	@Test(priority=2)
	public void checkClickOn() throws InterruptedException {
		WebElement clickOn = driver.findElement(By.xpath("//label[normalize-space()=\"Click on this check box\"]/child::input"));
		if (clickOn.isSelected() == true) {
			System.out.println("Has been clicked");
		} else {
			clickOn.click();
			System.out.println("Click on has been clicked");
		}
		Thread.sleep(2000);
	}

	@AfterClass
	void closeWebsite() {
		driver.quit();
	}

}
