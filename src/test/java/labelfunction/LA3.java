package labelfunction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import pageLocator.Rise_Dashboard_Page;
import pageLocator.Rise_Login_Page;
import pageLocator.Rise_Projects_Page;
import util.CommonFunction;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class LA3 extends CommonFunction {
	WebDriver driver;
	Rise_Login_Page lp;
	Rise_Dashboard_Page dp;
	Rise_Projects_Page pp;
	String labelName = "TC3 LA3 " + randomString();

	@BeforeClass
	@Parameters({"browserTest"})
	void openSite(String br) {
		System.setProperty("webdriver.http.factory", "jdk-http-client"); //fix Connection reset warning
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
		openWebsite(driver, "https://rise.fairsketch.com/signin");
		lp = new Rise_Login_Page(driver);
		dp = new Rise_Dashboard_Page(driver);
		pp = new Rise_Projects_Page(driver);
		lp.clickSubmit();
		dp.clickProject();
	}

	@Test
	public void TC3_createLabel() throws InterruptedException {
		pp.clickLabelButton();
		pp.typeLabelName(labelName);
		pp.saveLabel();
		Thread.sleep(2000);
		Assert.assertEquals(pp.verifyLabelAndColor(labelName,"#4a8af4"), true);
	}
	
	@Test
	public void TC3_deleteLabel() throws InterruptedException {
		pp.clickCreatedLabel();
		pp.clickDeleteButton();
		Thread.sleep(2000);
		Assert.assertEquals(pp.checkSelectedLabelDeleted(labelName), false);
	}

	@AfterClass
	void quitWebdriver() {
		driver.quit();
	}

}
