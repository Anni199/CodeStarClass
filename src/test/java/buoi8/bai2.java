package buoi8;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class bai2 {
	WebDriver driver;

	@BeforeClass
	void openWebsite() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.manage().window().maximize();
	}

	@Test
	public void fillInfo() {
		WebElement iframe = driver.findElement(By.xpath("/html/body/fieldset[13]/div/legend"));
		new Actions(driver).scrollToElement(iframe).perform();
		driver.findElement(By.id("name")).sendKeys("anon");
		driver.findElement(By.name("address")).sendKeys("Heaven");
		driver.findElement(By.id("email")).sendKeys("anonymous@web.com");
		driver.findElement(By.id("password")).sendKeys("0987654321");
	}

	@AfterClass
	void closeWebsite() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}
