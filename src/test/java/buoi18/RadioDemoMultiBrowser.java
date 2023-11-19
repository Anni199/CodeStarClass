package buoi18;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import util.CommonFunction;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;

public class RadioDemoMultiBrowser extends CommonFunction {
	WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser"})
	void setup(String br) throws InterruptedException
	{
		if(br.equals("chrome"))
		{
		driver=new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
		openWebsite(driver,"https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
		Thread.sleep(5000);
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
