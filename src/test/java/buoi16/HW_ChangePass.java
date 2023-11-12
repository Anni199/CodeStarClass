package buoi16;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.CommonBase;

public class HW_ChangePass extends CommonBase {
	public Actions act;
	public WebDriverWait wait;
	@BeforeClass
	void openSite() {
		driver = initChromeDriver("https://alada.vn/tai-khoan/dang-nhap.html");
	}
	
	@Test(priority=1)
	public void login() {
		type(By.name("txtLoginUsername"), "qna34203@zslsz.com");
		type(By.name("txtLoginPassword"), "ufY#n@Lw!QFu9s");
		click(By.xpath("//button[@type='submit']"));
	}
	
	@Test(priority=2)
	public void openProfilepage() {
		act=new Actions(driver);
		WebElement userAvatar = driver.findElement(By.xpath("//div[@class='avatar2']"));
		WebElement changeInfo = driver.findElement(By.xpath("//a[contains(text(),'Chỉnh sửa thông tin')]"));
		act.moveToElement(userAvatar).moveToElement(changeInfo).click().perform();
	}
	
	@Test(priority=2)
	public void changePass() {
		//scroll to change pass view
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(text(),'Lưu mật khẩu mới')]"))));
		//scrollToElement(By.xpath("//button[contains(text(),'Lưu mật khẩu mới')]"));
		//scrollToElement(By.name("txtrenewpass"));
		
		 //type current pass
		WebElement currentPass = driver.findElement(By.xpath("//input[@id='txtpassword']"));
		wait.until(ExpectedConditions.elementToBeClickable(currentPass));
		type(By.xpath("//input[@id='txtpassword']"), "ufY#n@Lw!QFu9s");
		
		//type new pass
		WebElement newPass = driver.findElement(By.xpath("//input[@id='txtnewpass']"));
		wait.until(ExpectedConditions.elementToBeClickable(newPass));
		type(By.xpath("//input[@id='txtnewpass']"), "%@9N4WVg5au%A$");
		
		//type new pass again
		WebElement confirmNewPass = driver.findElement(By.xpath("//input[@id='txtrenewpass']"));
		wait.until(ExpectedConditions.elementToBeClickable(confirmNewPass));
		type(By.xpath("//input[@id='txtrenewpass']"), "%@9N4WVg5au%A$");
		
		//click on confirm button
		click(By.xpath("//button[contains(text(),'Lưu mật khẩu mới')]"));
		wait.until(ExpectedConditions.alertIsPresent());
		
		//verify pop up
		try
		{
		Alert alertwindow=driver.switchTo().alert();		
		System.out.println(alertwindow.getText());		
		Assert.assertEquals(alertwindow.getText(),"Cập nhật mật khẩu mới thành công!","Alert element not showing up");
		//alertwindow.accept();
		pause(3000);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
	
//	@AfterClass
//	void closeWebsite() {
//		quitDriver(driver);
//	}
	
}
