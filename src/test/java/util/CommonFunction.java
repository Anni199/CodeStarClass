package util;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

public class CommonFunction {

	protected static void openWebsite(WebDriver driver, String url) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		driver.manage().window().maximize();
	}
	
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

}
