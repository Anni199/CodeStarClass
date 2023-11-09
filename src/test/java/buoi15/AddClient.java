package buoi15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pageLocator.Rise_Client_Page;
import pageLocator.Rise_Dashboard_Page;
import pageLocator.Rise_Login_Page;
import util.CommonFunction;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class AddClient extends CommonFunction {
	WebDriver driver;
	Rise_Login_Page lp;
	Rise_Dashboard_Page dp;
	Rise_Client_Page clip;

	@BeforeClass
	void openSite() {
		driver = new ChromeDriver();
		openWebsite(driver, "https://rise.fairsketch.com/signin");
		lp = new Rise_Login_Page(driver);
		dp = new Rise_Dashboard_Page(driver);
		clip = new Rise_Client_Page(driver);
	}

	@Test
	public void addClientTest() throws InterruptedException {
		lp.clickSubmit();
		dp.clickClient();
		clip.clickAddClient();
		clip.setCompanyName("Test03");
		clip.clickSave();
		Thread.sleep(2000);
		clip.clickClientTab();
		Thread.sleep(2000);
		clip.searchName("Test03");
		Thread.sleep(2000);

		try
		{
		boolean myCourse=driver.findElement(By.xpath("//a[normalize-space()='Test03']")).isDisplayed();
		Assert.assertEquals(myCourse,true,"Can't find comp name");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
	}


//	@AfterClass
//	void quitWebdriver() {
//		driver.quit();
//	}

}
