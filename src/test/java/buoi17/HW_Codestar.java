package buoi17;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.CommonBase;

public class HW_Codestar extends CommonBase {
	WebDriverWait wait;
	
	@BeforeClass
	void openSite() {
		driver = initChromeDriver("https://codestar.vn/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
	}

//	@Test
//	public void findWindowsId() {
//		pause(15000);
//		
//		//if (isElementPresent(By.tagName("iframe")) == true) {
//			int totalFrames = driver.findElements(By.tagName("iframe")).size();
//			System.out.println("Total iframe: " + totalFrames);
//			//wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("(//div[@role='button'])[3]"))));
//			for (int i = 0; i < totalFrames; i++) {
//				driver.switchTo().frame(i);
//				//test 1 find fb iframe
//				//int foundedAtIndex = driver.findElements(By.xpath("(//div[@class='_a2zm'])")).size();
//				//test 2 find roadmap iframe
//				int foundedAtIndex = driver.findElements(By.xpath("//input[@name='account_phone']")).size();
//				System.out.println("Found at: " + foundedAtIndex);
//				driver.switchTo().defaultContent();
//			}
//		//}
//
//	}
	
	@Test
	public void switchToFacebook() {
		pause(10000);
		driver.switchTo().frame(5);
		
		//click on iframe to open new windows
		click(By.xpath("(//div[@class='_a2zm'])"));
		pause(1000);
		click(By.xpath("//span[text()='Sử dụng Messenger']"));
		
		//switch to child window
		String parentwindow = driver.getWindowHandle();
		List<String> allwindows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(allwindows.get(1));
		
		//assert child window then close it
		Assert.assertEquals(driver.getTitle(), "Facebook");
		pause(1000);
		driver.close();
		
		//switch back to parent window
		driver.switchTo().window(parentwindow);
		driver.switchTo().defaultContent();
	}
	
	@Test
	public void switchToRoadmapIframe() {
		pause(5000);
		scrollToElement(By.xpath("//h2[contains(text(),'Đăng kí nhận tư vấn lộ trình')]"));
		driver.switchTo().frame(1);
		type(By.xpath("//input[@name='account_phone']"), "Auto");
		click(By.xpath("//button[text()='Gửi ngay']"));
		Assert.assertEquals(driver.getCurrentUrl(), "https://codestar.vn/");
		driver.switchTo().defaultContent();
	}

	@AfterClass
	void closeWebsite() {
		quitDriver(driver);
	}

}
