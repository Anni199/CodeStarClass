package buoi14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pageLocator.Dashboard_Page;
import pageLocator.Login_Page;
import util.CommonFunction;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class LoginTest extends CommonFunction {
	WebDriver driver;
	Login_Page lp;
	Dashboard_Page dp;

	@BeforeClass
	void openSite() {
		driver = new ChromeDriver();
		openWebsite(driver, "https://alada.vn/");
		lp = new Login_Page(driver);
		dp = new Dashboard_Page(driver);
	}

	@Test(dataProvider="dp")
	public void loginTest(String dpEmail, String dpPassword) throws InterruptedException {
		dp.clickLogin();
		lp.setEmail(dpEmail);
		lp.setPass(dpPassword);
		lp.clickSubmit();

		try
		{
		boolean myCourse=driver.findElement(By.xpath("//a[contains(@href,'https://alada.vn/khoa-hoc-cua-toi/')]")).isDisplayed();
		Assert.assertEquals(myCourse,true,"Can't find my course element");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		Thread.sleep(2000);
	}


	@AfterClass
	void quitWebdriver() {
		driver.quit();
	}
	
	@DataProvider(name="dp", indices= {0})
	String [][] loginData()
	{
		String data[][]= {  
				{ "qna34203@zslsz.com", "%@9N4WVg5au%A$" },
				{ "tfd65271@zslsz.com", "44B#Cc^h*6Ymgt" } 
						};
		
		return data;
	}

}
