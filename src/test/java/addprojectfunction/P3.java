package addprojectfunction;

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

public class P3 extends CommonFunction {
	WebDriver driver;
	Rise_Login_Page lp;
	Rise_Dashboard_Page dp;
	Rise_Projects_Page pp;

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
	public void TC10() throws InterruptedException {
		pp.clickAddProject();
		String projectTitle = "P3 Project " + randomString();
		String taskTitle = "P3 Tasks " + randomString();
		pp.typeProjectTitleOrTasks(projectTitle);
		pp.clickSaveAndContinueProject();
		Thread.sleep(2000);
		pp.clickNextAddProjectMember();
		pp.typeProjectTitleOrTasks(taskTitle);
		pp.clickAddMoreTasks();
		Thread.sleep(3000);
		pp.clickCloseAddTasks();
		Assert.assertEquals(pp.checkCreatedProjectAndTaks(projectTitle,taskTitle), true);
	}

	@AfterClass
	void quitWebdriver() {
		driver.quit();
	}

}
