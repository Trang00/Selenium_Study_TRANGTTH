package Seleniumeasy.com;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test02 {
	WebDriver driver;
	Date date;
	WebElement dateWidget;
	List<WebElement> rows;
	List<WebElement> columns;
	List<String> list = Arrays.asList("January", "February", "March", "April",
			"May", "June", "July", "August", "September", "October",
			"November", "December");
 
	int expMonth;
	String expYear;
	int expDate;
	
	// Calendar Month and Year.
	String calMonth = null;
	String calYear = null;
	String calMothYear=null;
	String CalDay=null;
	boolean dateNotFound;
	int a;
 
	@BeforeClass
	public void start() {
		driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
		
	}

 
	@Test
	public void testJQueryDatePicket() throws InterruptedException {
		
		driver.findElement(By.xpath("//div[@class='input-group date']//input[@class='form-control']")).click();

		// Set the date here. Eg: 13/04/2019
		expMonth = 4;
		expYear = "April 2019";
		expDate = 13;
	
		calMothYear = driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']")).getText();
		System.out.println("MothYear:"+calMothYear);
		System.out.println(expYear);
		
		CalDay=driver.findElement(By.xpath("//td[@class='today day']")).getText();
		System.out.println("Day:"+CalDay);
	
		a=14;
		int b=Integer.parseInt(CalDay)+1;
		System.out.println("b="+b);
		if(Integer.parseInt(CalDay)+1==a){
			driver.findElement(By.xpath("//td[@class='today day']/following-sibling::td")).isDisplayed();
			System.out.println("Day:..........");
		}
			
			 

	}
 
	@AfterClass
	public void tearDown() {
		//driver.quit();
		
	}
}
