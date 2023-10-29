package buoi12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import util.CommonFunction;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class MultiCheckboxDemo extends CommonFunction {
	WebDriver driver;
	
	@BeforeClass
	void openSite() {
		driver = new ChromeDriver();
		openWebsite(driver,"https://demo.seleniumeasy.com/basic-checkbox-demo.html");
	}

	@Test(priority=1)
	public void multiCheckbox() throws InterruptedException {
		List<WebElement> checkboxes=driver.findElements(By.xpath("(//div[@class='panel-body'])[3]//div[@class='checkbox']//input"));
		System.out.println("Total number of checkboxes: "+checkboxes.size()); //4
		int index = 0;
		for(WebElement chkbox:checkboxes)
		{
			System.out.println(chkbox.isSelected());
			if(chkbox.isSelected() == true) {
	            System.out.println("Checkbox at " + (index+1) + " has been checked.");
	        } else {
	        	chkbox.click();
	        }      
	        index++;
	        System.out.println("After running");
	        System.out.println(chkbox.isSelected());
		}
		Thread.sleep(2000);
	}
	
	@Test(priority=2)
	public void multiCheckbox2() throws InterruptedException {
		List<WebElement> checkboxes=driver.findElements(By.xpath("(//div[@class='panel-body'])[3]//div[@class='checkbox']//input"));
		System.out.println("Total number of checkboxes: "+checkboxes.size()); //4
		int index = 0;
		for(WebElement chkbox:checkboxes)
		{
			if(index ==2 && chkbox.isSelected() == false) {
				chkbox.click();
	        } else {
	        	System.out.println("Has been checked");
	        }      
	        index++;
		}
		Thread.sleep(2000);
	}

	@AfterClass
	void closeWebsite() {
		driver.quit();
	}

}
