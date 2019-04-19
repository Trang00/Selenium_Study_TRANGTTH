package Seleniumeasy.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Basic_DatePickers_TC02_JQueryDatePicker {
	WebDriver driver;
	@Test
	public void TC01() {
		
	}

	@BeforeMethod
	public void beforeMethod() {
		driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
		
}
