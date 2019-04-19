package Seleniumeasy.com;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Basic_InputForms_TC06_AjaxFormSubmit {
	WebDriver driver;
	WebDriverWait waitexplicit;
	Date date;
	@Test
	public void TC01_AjaxFormSubmit() {
		driver.findElement(By.xpath("//input[@id='title']")).sendKeys("Name Ajax Form");
		driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("Comment Ajax Form\"");
		driver.findElement(By.xpath("//input[@id='btn-submit']")).click();
		
		System.out.println("------------Start time Ajax Request is Processing! visible---------");
		System.out.println(date=new Date());
		
		waitexplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='submit-control' and text()=' Ajax Request is Processing!']")));
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='submit-control' and text()=' Ajax Request is Processing!']")).isDisplayed());
		
		System.out.println("------------And time Ajax Request is Processing! visible---------");
		System.out.println(date=new Date());
		
		// Invisible- ko có trong DOM, ch�? hết timeout implicit wait- 15s
		System.out.println("------------Start time Sumit Invisible ---------");
		System.out.println(date=new Date());
		waitexplicit.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@id='btn-submit']")));
		System.out.println("------------And time Sumit Invisible---------");
		System.out.println(date=new Date());
		
		System.out.println("------------Start time submited Successfully! visible ---------");
		System.out.println(date=new Date());
		waitexplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='submit-control' and text()='Form submited Successfully!']")));
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='submit-control' and text()='Form submited Successfully!']")).isDisplayed());
		System.out.println("------------And time ubmited Successfully! visibl ---------");
		System.out.println(date=new Date());
		
		
	}

	@BeforeMethod
	public void beforeMethod() {
		driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		waitexplicit=new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/ajax-form-submit-demo.html");

	}

	@AfterMethod
	public void afterMethod() {
		//driver.quit();
	}
}
