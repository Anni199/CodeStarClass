package buoi15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pageLocator.Trizen_Bookflight_Page;
import util.CommonFunction;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class HW_TrizenSearchFlight extends CommonFunction {
	WebDriver driver;
	Trizen_Bookflight_Page bp;

	@BeforeClass
	void openSite() {
		driver = new ChromeDriver();
		openWebsite(driver, "https://techydevs.com/demos/themes/html/trizen-demo/trizen/index.html");
		bp = new Trizen_Bookflight_Page(driver);
	}

//	@Test
//	public void chooseDate() throws InterruptedException {
//		bp.chooseDate("07112023");
//		Thread.sleep(2000);
//
////		try
////		{
////		boolean myCourse=driver.findElement(By.xpath("//a[normalize-space()='Test03']")).isDisplayed();
////		Assert.assertEquals(myCourse,true,"Can't find comp name");
////		}
////		catch(Exception e)
////		{
////			Assert.fail();
////		}
//		
//	}
	@Test
	public void searchFlight() throws InterruptedException {
		bp.inputFlyFrom("Ha Noi");
		Thread.sleep(2000);
		bp.inputFlyTo("Ho Chi Minh");
		Thread.sleep(2000);
		bp.chooseDate("07112023");
		Thread.sleep(2000);
		bp.addAdult();
		Thread.sleep(2000);
		bp.searchFlight();
		Thread.sleep(2000);
		Assert.assertEquals(bp.isResultPageShow(), true);
	}

	@AfterClass
	void quitWebdriver() {
		driver.quit();
	}
}
