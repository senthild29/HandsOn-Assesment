package seleniumInterviewQues;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AuthPopUpEg {
	
	@Test
	public void popup() {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Pass the credentials in URL itself for authentication pop-up
		driver.navigate().to("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
	}

}
