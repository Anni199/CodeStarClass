package buoi13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pageLocator.Dashboard_Page;
import pageLocator.Login_Page;
import util.CommonFunction;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class AuthTest extends CommonFunction {
	WebDriver driver;
	Login_Page lp;
	Dashboard_Page dp;

	@BeforeClass
	void openSite() {
		driver = new ChromeDriver();
		openWebsite(driver, "https://rise.fairsketch.com/signin");
		lp = new Login_Page(driver);
		dp = new Dashboard_Page(driver);
	}

	@Test(priority = 1)
	public void loginFailedEmail() throws InterruptedException {
		lp.setUserName("abc123@demo.com");
		lp.setPassword("riseDemo");
		lp.clickSignin();

		Assert.assertEquals(lp.checkFailedAlert(), true);
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	public void loginFailedPassword() throws InterruptedException {
		lp.setUserName("admin@demo.com");
		lp.setPassword("riseDemo123");
		lp.clickSignin();

		Assert.assertEquals(lp.checkFailedAlert(), true);
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void loginFailedEmailAndPassword() throws InterruptedException {
		lp.setUserName("abc@demo.com");
		lp.setPassword("riseDemo123");
		lp.clickSignin();

		Assert.assertEquals(lp.checkFailedAlert(), true);
		Thread.sleep(2000);
	}

	@Test(priority = 4)
	public void loginSuccess() throws InterruptedException {
		lp.setUserName("admin@demo.com");
		lp.setPassword("riseDemo");
		lp.clickSignin();

		Assert.assertEquals(driver.getTitle(), "Dashboard | RISE - Ultimate Project Manager and CRM");
		Thread.sleep(2000);
	}
	
	@Test(priority=5, dependsOnMethods = {"loginSuccess"})
	public void logout() throws InterruptedException {
		dp.clickLogout();
		
		Assert.assertEquals(driver.getTitle(),"Sign in | RISE - Ultimate Project Manager and CRM");
		Thread.sleep(2000);
	}

	@AfterClass
	void quitWebdriver() {
		driver.quit();
	}

}
