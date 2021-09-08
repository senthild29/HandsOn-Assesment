package testknowledge;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class TestNGPart2 {

	WebDriver driver;

	@BeforeSuite
	public void OpenSite() {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/");
		driver.manage().window().maximize();

	}

	@Test
	public void AlertBox() {
		WebElement click1 = driver.findElement(By.xpath("//*[text()='Alert']/following-sibling::*"));
		click1.click();
	}

	@Test(dependsOnMethods = "AlertBox" )
	public void ConfirmBox()  throws InterruptedException {
		WebElement click2 = driver.findElement(By.xpath("//*[contains(text(),'Confirm')]"));
		click2.click();
		Alert HandleAlerts = driver.switchTo().alert();
		HandleAlerts.dismiss();
		Thread.sleep(2000);
	}

	@Test(dependsOnMethods = "ConfirmBox" )
	public void PromptBox() throws InterruptedException {
		WebElement click3 = driver.findElement(By.xpath("//button[@onclick='confirmPrompt()']"));
		click3.click();
		Alert HandleAlerts2 = driver.switchTo().alert();
		HandleAlerts2.sendKeys("Test Suite");
		HandleAlerts2.accept();
		Thread.sleep(2000);
	}

	@AfterSuite
	public void closeSite() {
		driver.navigate().back();
		driver.close();
	}
}
