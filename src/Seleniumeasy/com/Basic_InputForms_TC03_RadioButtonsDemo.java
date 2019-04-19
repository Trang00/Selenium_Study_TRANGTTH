package Seleniumeasy.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Basic_InputForms_TC03_RadioButtonsDemo {
	WebDriver driver;
	
	
	@Test
	public void TC01_RadioButtonDemo() {
		//Click nut khi chua chon gioi tinh
		WebElement buttonRadio1=driver.findElement(By.xpath("//button[@id='buttoncheck']"));
		buttonRadio1.click();
		WebElement Msg=driver.findElement(By.xpath("//p[@class='radiobutton' and text()='Radio button is Not checked']"));
		Assert.assertTrue(Msg.isDisplayed());
		
		//Click on button to get the selected value
		//chon male- > check
		WebElement MaleRadio=driver.findElement(By.xpath("//p[text()='Click on button to get the selected value']/following-sibling::label[text()='Male']/input"));
		MaleRadio.click();
		buttonRadio1.click();
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='radiobutton' and text()=\"Radio button 'Male' is checked\"]")).isDisplayed());
		
		//Chon female -> check
		WebElement FemaleRadio=driver.findElement(By.xpath("//p[text()='Click on button to get the selected value']/following-sibling::label[text()='Female']/input"));
		FemaleRadio.click();
		buttonRadio1.click();
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='radiobutton' and text()=\"Radio button 'Female' is checked\"]")).isDisplayed());
	}
	
	@Test
	public void TC02_GroupRadioButtons() throws Exception {
		//Click on button to get the selected values from Group Sex and Age group
		String male="Sex : Male\n";
		String Female="Sex : Female\n";
		
		String Age1="Age group: 0 - 5";
		String Age2="Age group: 5 - 15";
		String Age3="Age group: 15 - 25";
	
		WebElement MaleRadio2=driver.findElement(By.xpath("//h4[text()='Sex : ']//following-sibling::label[text()='Male']/input"));
		WebElement FemaleRadio2=driver.findElement(By.xpath("//h4[text()='Sex : ']//following-sibling::label[text()='Female']/input"));
		
		WebElement AgeRadi1=driver.findElement(By.xpath("//h4[text()='Age Group : ']/following-sibling::label[text()='0 to 5']/input"));
		WebElement AgeRadi2=driver.findElement(By.xpath("//h4[text()='Age Group : ']/following-sibling::label[text()='5 to 15']/input"));
		WebElement AgeRadi3=driver.findElement(By.xpath("//h4[text()='Age Group : ']/following-sibling::label[text()='15 to 50']/input"));
		
		AgeRadi1.click();
		MaleRadio2.click();
		
		WebElement buttonRadio2=driver.findElement(By.xpath("//button[text()='Get values']"));
		buttonRadio2.click();
		
		String msgh=driver.findElement(By.xpath("//p[@class='groupradiobutton']")).getText();
	
		Assert.assertEquals(msgh,male+Age1);
		
		FemaleRadio2.click();
		AgeRadi2.click();
		buttonRadio2.click();
		msgh=driver.findElement(By.xpath("//p[@class='groupradiobutton']")).getText();
		Assert.assertEquals(msgh,Female+Age2);
}
	
	@BeforeMethod
	public void beforeMethod() {
		driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
