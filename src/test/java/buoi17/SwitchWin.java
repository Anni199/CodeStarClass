package buoi17;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.CommonBase;

public class SwitchWin extends CommonBase {
	@BeforeClass
	void openSite() {
		driver = initChromeDriver("https://demo.guru99.com/popup.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void switchWindows() {
		click(By.xpath("//a[normalize-space()='Click Here']"));
		String mainWindow = driver.getWindowHandle();
		Set<String> windowIDs = driver.getWindowHandles();
		for (String winid : windowIDs) {

			if (!winid.equals(mainWindow)) {
				driver.switchTo().window(winid);
				Assert.assertEquals(driver.getCurrentUrl(), "https://demo.guru99.com/articles_popup.php");
				pause(2000);
				type(By.name("emailid"), "abc@zslsz.com");
				click(By.name("btnLogin"));
				pause(2000);
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		pause(2000);
		Assert.assertEquals(driver.getCurrentUrl(), "https://demo.guru99.com/popup.php");
	}

	@AfterClass
	void closeWebsite() {
		quitDriver(driver);
	}

}
