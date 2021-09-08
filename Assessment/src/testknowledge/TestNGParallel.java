package testknowledge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNGParallel {
	
	WebDriver driver;
	WebElement radiohome;
	
	@Test
	public void FirstTC() {
		System.out.println("I'm 1st test case");
	}
	
	@Test
	public void SecondTC() {
		System.out.println("I'm 2nd test case");
	}
	
	@Test
	public void ThirdTC() {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/");
		driver.manage().window().maximize();
		radiohome = driver.findElement(By.xpath("//*[contains(@href,'radio.html')]"));
		radiohome.click();
	}
	
	@Test(dependsOnMethods = "ThirdTC")
	public void FourthTC() {
		WebElement rd1 = driver.findElement(By.xpath("//*[contains(@for,'Unchecked')]/child::*"));
		WebElement rd2 = driver.findElement(By.xpath("//label[@for='Checked']/child::*"));
		
		boolean rd1ck = rd1.isSelected();
		System.out.println("Does Radio button selected by default : "+rd1ck);
		
		boolean rd2ck = rd2.isSelected();
		System.out.println("Does Radio button selected by default : "+rd2ck);

	}

	@Test
	public void FifthTC() {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://google.co.in");
		System.out.println("Google opened successfully");
	}
}
