package Demo.guru99.com;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_02_RegisterAndLogin_DataProvider {
	
	WebDriver driver;
	private String email, UserID, password, LoginURL;//
	@Test
	  public void TC_01_RegisterToSystem1() {
		
		  driver.get("http://demo.guru99.com/V4");
		  LoginURL=driver.getCurrentUrl();
		  driver.findElement(By.xpath("//a[text()='here']")).click();
		  Assert.assertTrue(driver.findElement(By.xpath("//input[@name='emailid']")).isDisplayed());
		  driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
		  driver.findElement(By.xpath("//input[@type='submit']")).click();
		  UserID=driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		  password=driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
		  
		  System.out.println("UserID: "+UserID);
		  System.out.println("Password: "+ password);
		  
	  }
	  @Test(dataProvider = "UserAndPass")
	  public void TC_02_LoginWithAboveInformation2(String User, String pass) {
		  
		  driver.get(LoginURL);
		  driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(User);
		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
		  driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		  if(User==UserID && pass==password ) {
			  Assert.assertTrue(driver.findElement(By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]")).isDisplayed());
			  Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Manger Id : "+User+"']")).isDisplayed());
		  }else {
			  Alert alert=driver.switchTo().alert();
			  String MsgAlert=alert.getText();
			  Assert.assertEquals(MsgAlert,"User or Password is not valid");
			  alert.accept();
		  }
	  }
	  @DataProvider
	  public Object[][] UserAndPass() {
	    return new Object[][] {
	    	{UserID,password},
	    	{"INvalidUserID",password},
	    	{UserID,"INValidPassword"},
	    	{"INvalidUserID","INValidPassword"}};
	  }
	  public int randomNumber() {
		  Random random= new Random();
		  int number=random.nextInt(999);
		  return number;
	  }
	  @BeforeClass
	  public void beforeClass() {
		  driver= new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			email="seleniumonline"+randomNumber()+"@gmail.com";
	  }
	  @AfterClass
	  public void afterClass() {
		  driver.quit();
		  
	  }
}
