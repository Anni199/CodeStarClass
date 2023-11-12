package buoi16;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.CommonBase;

public class AlertAutoTesting extends CommonBase {
	@BeforeClass
	void openSite() {
		driver = initChromeDriver("https://demo.automationtesting.in/Alerts.html");
	}
	
	@Test
	public void okAndCancel() {
		click(By.xpath("//a[normalize-space()='Alert with OK & Cancel']"));
		click(By.xpath("//button[normalize-space()='click the button to display a confirm box']"));
		driver.switchTo().alert().dismiss();
		Assert.assertEquals(isElementPresent(By.xpath("//p[@id='demo']")), true);
	}
	
	@Test
	public void typeAlert() {
		click(By.xpath("//a[normalize-space()='Alert with Textbox']"));
		click(By.xpath("//button[normalize-space()='click the button to demonstrate the prompt box']"));
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.alertIsPresent());
		Alert alertwindow=driver.switchTo().alert();
		System.out.println(alertwindow.getText());
		alertwindow.sendKeys("aaaaa");
		pause(3000);
		alertwindow.accept();
		WebElement text = driver.findElement(By.xpath("//p[@id='demo1']"));
		Assert.assertEquals((text.getText()), "Hello aaaaa How are you today");
		pause(3000);
	}
	
	@AfterClass
	void closeWebsite() {
		quitDriver(driver);
	}
	
}
