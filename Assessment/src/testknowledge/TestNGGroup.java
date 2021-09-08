package testknowledge;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class TestNGGroup {

	WebDriver driver;

	@Test(groups = "MyGroup") //Using groups attribute assigning a group name, so that specific methods/test case will be executed
	public void OpenWikipedia() {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.wikipedia.org/");
driver.close();
	}

	@Test
	public void OpenIncomeTax() {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.incometaxindiaefiling.gov.in/home");
		
	}

	@Test(groups = "MyGroup")//Using groups attribute assigning a group name, so that specific methods/test case will be executed
	public void OpenTestLeaf() {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/");
		
	}
	
	@AfterSuite(groups = "MyGroup")//Using groups attribute assigning a group name, so that specific methods/test case will be executed
	public void CloseAllBrowser() {
		driver.quit();
	}

	
}