package testknowledge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SendDataDataProvider {
	
	WebDriver driver;

	String [][] data = {
			{"John Smith","testgmail"},
			{"Smith","testsmithgmail"}
			
	};
	
@DataProvider(name="SendData")
	public String[][] UsingDataProvider()   {
		return data;

	}

	
	@BeforeTest
	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.india.gov.in/online-registration");
		driver.manage().window().maximize();
	}

	
	
	@Test(dataProvider = "SendData")
	public void LoginPage(String getUser, String getPass) {

		WebElement register = driver.findElement(By.xpath("//*[text()='Register']"));
	     register.click();

		WebElement un = driver.findElement(By.id("edit-name"));
		un.sendKeys(getUser);

		WebElement email = driver.findElement(By.id("edit-mail"));
		email.sendKeys(getPass);

		

	}
	
	
	 @AfterTest//This will close the browser after @Test exeuction public void
	 public void CloseBrowser() { driver.close(); }
	 

}


