package buoi8;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class bai1 {
	WebDriver driver;
	
	@BeforeClass
	void openWebsite() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.manage().window().maximize();
	}

	@Test
	public void fillInfo() {
		driver.findElement(By.id("userId")).sendKeys("an@gmail.com");
		driver.findElement(By.name("Password")).sendKeys("password123");
		driver.findElement(By.className("form-control")).sendKeys("CodeStar");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/section[2]/div/div/div/div/div/form/div/div[1]/div/div/div/input[2]")).sendKeys("0987654321");
	}

	@AfterClass
	void closeWebsite() {
		driver.quit();
	}

}
