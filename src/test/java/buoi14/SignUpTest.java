package buoi14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pageLocator.Dashboard_Page;
import pageLocator.Signup_Page;
import util.CommonFunction;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class SignUpTest extends CommonFunction {
	WebDriver driver;
	Signup_Page sp;
	Dashboard_Page dp;

	@BeforeClass
	void openSite() {
		driver = new ChromeDriver();
		openWebsite(driver, "https://alada.vn/");
		sp = new Signup_Page(driver);
		dp = new Dashboard_Page(driver);
	}

	@Test(dataProvider="dp")
	public void loginTest(String dpName, String dpEmail, String dpPassword, String dpPhone) throws InterruptedException {
		dp.clickSignUp();
		sp.setName(dpName);
		sp.setEmail(dpEmail);
		sp.setPassword(dpPassword);
		sp.setPhone(dpPhone);
		sp.clickSubmit();

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
							{ "Nguyễn Văn Minh", "kexopi1777@eazenity.com", "kn&kz&D2egi%Fc", "0978656543" },
							{ "Nguyễn Viết Nghị", "tfd65271@zslsz.com", "44B#Cc^h*6Ymgt", "0918573659" } 
						};
		
		return data;
	}

}
