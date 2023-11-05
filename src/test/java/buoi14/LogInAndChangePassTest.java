package buoi14;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pageLocator.Dashboard_Page;
import pageLocator.Login_Page;
import pageLocator.Userinfo_Page;
import util.CommonFunction;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class LogInAndChangePassTest extends CommonFunction {
	WebDriver driver;
	Login_Page lp;
	Dashboard_Page dp;
	Userinfo_Page up;

	@BeforeClass
	void openSite() {
		driver = new ChromeDriver();
		openWebsite(driver, "https://alada.vn/");
		lp = new Login_Page(driver);
		dp = new Dashboard_Page(driver);
		up = new Userinfo_Page(driver);
	}

	@Test(dataProvider="dp")
	public void loginTest(String dpEmail, String dpCurrentPassword, String dpNewPassword) throws InterruptedException {
		dp.clickLogin();
		lp.setEmail(dpEmail);
		lp.setPass(dpCurrentPassword);
		lp.clickSubmit();
		dp.clickUserInfo();
		up.setCurrentPass(dpCurrentPassword);
		up.setNewPass(dpNewPassword);
		up.clickSubmit();

		try
		{
		Thread.sleep(10000);
		Alert alertwindow=driver.switchTo().alert();		
		System.out.println(alertwindow.getText());		
		Assert.assertEquals(alertwindow.getText(),"Cập nhật mật khẩu mới thành công!","Alert element not showing up");
		//alertwindow.accept();
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
							{ "qna34203@zslsz.com", "%@9N4WVg5au%A$", "ufY#n@Lw!QFu9s" },
							{ "tfd65271@zslsz.com", "44B#Cc^h*6Ymgt", "%@9N4WVg5au%A$" } 
						};
		
		return data;
	}

}
