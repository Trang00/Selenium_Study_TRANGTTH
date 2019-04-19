package Seleniumeasy.com;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Basic_InputForms_TC07_JQuerySelectDropdown {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor javascript;
	
	String state1="Hawaii";
	String state2="New York";
	String state3="Washington";
	
	String Territories="American Samoa";
	
	@Test
	public void TC01_DropDownWithSearchBox() {
		
		WebElement SelectCountry=driver.findElement(By.xpath("//label[text()='Select Country :']/following-sibling::span//span[@class='select2-selection__arrow']"));
		SelectCountry.click();
		//javascript.executeScript("arguments[0].click();", SelectCountry);
		driver.findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']")).sendKeys("Japan",Keys.RETURN);
		Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Select Country :']/following-sibling::span//span[@id='select2-country-container' and text()='Japan']")).isDisplayed());
		
	}
	@Test
	public void TC02_SelectMultipleValues() {//click ch�?n
		driver.findElement(By.xpath("//span[@class='select2-selection select2-selection--multiple']")).click();
		driver.findElement(By.xpath("//span[@class='select2-results']//li[text()='"+state1+"']")).click();
		
		driver.findElement(By.xpath("//span[@class='select2-selection select2-selection--multiple']")).click();
		driver.findElement(By.xpath("//span[@class='select2-results']//li[text()='"+state2+"']")).click();
		
		driver.findElement(By.xpath("//span[@class='select2-selection select2-selection--multiple']")).click();
		driver.findElement(By.xpath("//span[@class='select2-results']//li[text()='"+state3+"']")).click();
		
		List<WebElement> SelectNumber=driver.findElements(By.xpath("//li[@class='select2-selection__choice']"));
		Assert.assertEquals(3, SelectNumber.size());
	}@Test
	public void TC02_2_SelectMultipleValues() throws Exception {//tìm -> ch�?n
		driver.findElement(By.xpath("//span[@class='select2-selection select2-selection--multiple']")).sendKeys(state1,Keys.RETURN);
		driver.findElement(By.xpath("//span[@class='select2-selection select2-selection--multiple']")).sendKeys(state2,Keys.RETURN);
		
		List<WebElement> SelectNumber=driver.findElements(By.xpath("//li[@class='select2-selection__choice']"));
		Assert.assertEquals(2, SelectNumber.size());
	}
	@Test
	public void TC03_WithDisableValues() throws Exception {
		
		scrollToBottomPage();
		driver.findElement(By.xpath("//label[text()='Select US Outlying Territories :']/following-sibling::span//span[@class='select2-selection select2-selection--single']")).click();
		driver.findElement(By.xpath("//span[@class='select2-dropdown select2-dropdown--below']//input[@class='select2-search__field']")).sendKeys("American Samoa",Keys.RETURN);
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='select2-selection__rendered' and text()='"+Territories+"']")).isDisplayed());
	}
	
	@Test
	public void TC_04_SelectAFile() {
		
		Select SelectFile=new Select(driver.findElement(By.xpath("//select[@id='files']")));
		SelectFile.selectByVisibleText("PHP");
		
		
	}
	
	
	 public Object scrollToBottomPage() {
         JavascriptExecutor js = (JavascriptExecutor) driver;
         return js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
 }
	
	@BeforeMethod
	public void beforeMethod() {
		driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		javascript=(JavascriptExecutor) driver ;
		wait= new WebDriverWait(driver, 15);
		driver.get("https://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html");

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
