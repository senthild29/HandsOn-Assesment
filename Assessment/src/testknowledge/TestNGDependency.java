package testknowledge;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGDependency {

	WebDriver driver; //Declaring global variables
	String oldwindow;
	Set<String> allwindow;


	@BeforeSuite //Using Before suite annotation, executing this OpenBrowser(), as 1st test case
	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void OpenGmail() { 
		driver.navigate().to("https://www.google.co.in/");
		oldwindow = driver.getWindowHandle();
		driver.manage().window().maximize();
		WebElement gmail = driver.findElement(By.xpath("//*[text()='Gmail']"));
		gmail.click();
	}

	@Test(dependsOnMethods = "OpenGmail") //Using attribute "dependsonMethods", setting dependency 
	@Parameters("UserID") //Using @parameters annotation, passing value during run time using suitexml file
	public void LoginGmail(String getUserID) { //declaring a variable getUserId to get the run time value
		WebElement sign = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[4]/ul[1]/li[2]/a"));
		sign.click();

		allwindow = driver.getWindowHandles(); //To handle new window

		for (String newwindow : allwindow) {
			driver.switchTo().window(newwindow);			
		}
		WebElement un = driver.findElement(By.xpath("//input[@type='email']"));
		un.sendKeys(getUserID+Keys.ENTER);//Passing run time value using Variable gerUserID
	}

	@AfterSuite //Using @AfterSuite annotation, executing this CloeBrowser() as last test case
	public void CloseBrowser() {
		driver.navigate().back();
		driver.close();

	}

}
