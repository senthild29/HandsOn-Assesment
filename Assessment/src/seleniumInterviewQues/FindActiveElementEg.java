package seleniumInterviewQues;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FindActiveElementEg {

	@Test
	public void ActiveElement() {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.google.co.in/");
		
		//Identified element using activeElement(), withou driver.findElemement()
		driver.switchTo().activeElement().sendKeys("chennai \n");
	}
}
