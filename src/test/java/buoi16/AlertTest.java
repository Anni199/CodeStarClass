package buoi16;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.CommonBase;

public class AlertTest extends CommonBase {
	@BeforeMethod
	void openSite() {
		driver = initChromeDriver("https://demo.guru99.com/test/delete_customer.php");
	}
	
	@Test
	public void deleteCustomer() {
		type(By.name("cusid"), "id123");
		click(By.name("submit"));
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		Assert.assertEquals(driver.getTitle(), "Delete Customer");
	}
	
	@AfterMethod
	void closeWebsite() {
		quitDriver(driver);
	}
	
}
