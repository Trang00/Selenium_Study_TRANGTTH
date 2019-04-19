package Seleniumeasy.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Basic_InputForms_TC05_InputFormSubmit {

	WebDriver driver;
	String FirstName="Phi Yến";
	String LastName="LastName";
	String Mail="Mail@gmail.com";
	String Phone="0978999999";
	String Address="123 Hà Nội";
	String City="Hà Nội";
	String State="Việt Nam";
	String ZipCode="0101";
	String Website="py.vn";
	String hosting="nm";
	String ProjectDescription="First";
	
	@Test
	public void TC01() {
		
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(FirstName);
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(LastName);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Mail);
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(Phone);
		driver.findElement(By.xpath("//input[@name='address']")).sendKeys(Address);
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(City);
		
		Select SelectState=new Select(driver.findElement(By.xpath("//select[@name='state']")));
		SelectState.selectByVisibleText("California");
		String SelectedState=SelectState.getFirstSelectedOption().getText();
		Assert.assertEquals(SelectedState, "California");
		
		driver.findElement(By.xpath("//input[@name='zip']")).sendKeys(ZipCode);
		driver.findElement(By.xpath("//input[@name='website']")).sendKeys(Website);
		
		WebElement YesHosting=driver.findElement(By.xpath("//input[@value='yes']"));
		YesHosting.click();
		Assert.assertTrue(YesHosting.isSelected());
		
		
		driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys(ProjectDescription);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//System.out.println("Xin chao");
		
	}
	@BeforeMethod
	public void beforMethod() {
		driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");
	}
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	
}
