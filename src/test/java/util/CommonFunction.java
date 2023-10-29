package util;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class CommonFunction {

	protected static void openWebsite(WebDriver driver, String url) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(url);
		driver.manage().window().maximize();
	}

}
