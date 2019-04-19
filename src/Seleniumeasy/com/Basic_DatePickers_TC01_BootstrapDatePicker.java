package Seleniumeasy.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Basic_DatePickers_TC01_BootstrapDatePicker {
	WebDriver driver;
	@Test
	public void TC01_Date() {
		driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
		
		// Future Dates Disabled
		 //Days Of Week Disabled- Sunday
		// Week Starts from Monday 
		
		// Click on 'Today' to select Current date
		driver.findElement(By.xpath("//div[@class='input-group date']//input[@class='form-control']")).click();
		driver.findElement(By.xpath("//div[@class='datepicker-days']//th[text()='Today']")).click();
		
		//Click on Clear button to clear the date entered
		driver.findElement(By.xpath("//div[@class='input-group date']//input[@class='form-control']")).click();
		driver.findElement(By.xpath("//div[@class='datepicker-days']//th[text()='Clear']")).click();
	}


	@BeforeMethod
	public void beforeMethod() {
		driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	
	}
}
