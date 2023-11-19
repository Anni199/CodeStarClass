package buoi17;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.CommonBase;

public class SwitchIframe extends CommonBase {
	@BeforeClass
	void openSite() {
		driver = initChromeDriver("https://codestar.vn/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void findWindowsId() {
		pause(20000);
		//if (isElementPresent(By.tagName("iframe")) == true) {
			int totalFrames = driver.findElements(By.tagName("iframe")).size();
			System.out.println("Total iframe: " + totalFrames);

			for (int i = 0; i < totalFrames; i++) {
				driver.switchTo().frame(i);
				int foundedAtIndex = driver.findElements(By.xpath("//button[text()='Đăng ký ngay']")).size();
				System.out.println("Found at: " + foundedAtIndex);
				driver.switchTo().defaultContent();
			}
		//}

	}
	
	@Test
	public void switchWindowsAndType() {
		pause(5000);
		scrollToElement(By.xpath("//h2[contains(text(),'Đăng ký nhận tài liệu')]"));
		driver.switchTo().frame(3);
		type(By.xpath("//input[@name='account_name']"), "Auto");
		click(By.xpath("//button[text()='Đăng ký ngay']"));
		Assert.assertTrue(isElementPresent(By.xpath("//button[text()='Đăng ký ngay']")));
		driver.switchTo().defaultContent();

	}

//	@AfterClass
//	void closeWebsite() {
//		quitDriver(driver);
//	}

}
