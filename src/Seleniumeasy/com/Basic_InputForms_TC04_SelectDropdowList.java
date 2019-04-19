package Seleniumeasy.com;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Basic_InputForms_TC04_SelectDropdowList {
WebDriver driver;
	
@Test
public void TC01_SelectListDemo() {
	
	//Selected value from the list will display below the dropdown
	Select SelectDay= new Select(driver.findElement(By.xpath("//select[@id='select-demo']")));
	SelectDay.selectByVisibleText("Sunday");
	String TextSelect=driver.findElement(By.xpath("//p[text()='Day selected :- Sunday']")).getText();
	System.out.println("TextSelect TC1:"+TextSelect);
	Assert.assertEquals(TextSelect,"Day selected :- Sunday");
	
	int numberSelect=SelectDay.getOptions().size();
	Assert.assertEquals(8, numberSelect);
}
@Test
public void TC_02_MultiSelectList() throws Exception {
	
	//
	Select SelectMulti=new Select(driver.findElement(By.xpath("//select[@id='multi-select']")));
	SelectMulti.selectByVisibleText("New York");
	
	WebElement buttonFirstSelect=driver.findElement(By.xpath("//button[@id='printMe']"));
	buttonFirstSelect.click();
	Thread.sleep(1000);
	
	WebElement buttonAllSelect=driver.findElement(By.xpath("//button[@id='printAll']"));
		
	String TextSelec=driver.findElement(By.xpath("//p[@class='getall-selected']")).getText();
	System.out.println("TextSelec:"+TextSelec);
	Assert.assertEquals(TextSelec, "First selected option is : New York");
	
	/*
	 List<WebElement> Size=SelectMulti.getOptions();
	for(WebElement Se: Size) {
		System.out.println(Se.getText());
	}
	 int ListSize=Size.size();
	for(int i=0;i<ListSize;i++) {
		String Value=Size.get(i).getText();
		System.out.println("Gia tri Select "+i+":"+Value);
	}
	*/
	driver.manage().deleteAllCookies();
	Actions buider= new Actions(driver);
	
	buider.keyDown(Keys.CONTROL).click(SelectMulti.getOptions().get(0)).click(SelectMulti.getOptions().get(1)).click(SelectMulti.getOptions().get(2)).keyUp(Keys.CONTROL);
	buider.build().perform();
	
	buttonAllSelect.click();
	TextSelec=driver.findElement(By.xpath("//p[@class='getall-selected']")).getText();
	System.out.println("MulSe:"+TextSelec);
}
@BeforeMethod
public void beforeMethod() {
	driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
}
@AfterMethod
public void afterMethod() {
	driver.quit();
}
}
