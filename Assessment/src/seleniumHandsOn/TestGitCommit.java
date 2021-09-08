package seleniumHandsOn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestGitCommit {
	
	WebDriver driver;
	
	@BeforeTest
	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.navigate().to("https://google.co.in");
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException e)
		{
			
		}
		
	}

	@Test
	public void CloseBrowser() {
		driver.quit();
	}
}
