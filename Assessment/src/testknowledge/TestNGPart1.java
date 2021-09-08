package testknowledge;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGPart1 {

	WebDriver driver;

	@BeforeSuite
	public void openSite() {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.leafground.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void dropDown() {
		
		WebElement dropdown1 = driver.findElement(By.xpath("//*[text()='Drop down']/following-sibling::*"));
		dropdown1.click();
	}
	
	@Test(dependsOnMethods = "dropDown")
	public void noofItems() {
		WebElement dropdown2 = driver.findElement(By.xpath("//select[@class='dropdown']"));
		Select dropdownitems = new Select(dropdown2);
		List<WebElement> allitems = dropdownitems.getOptions();
		System.out.println("Number of options in the drop down : "+allitems.size());
		dropdownitems.selectByIndex(1);
	}

	@AfterSuite
	public void closeSite() {
		driver.navigate().back();
		driver.close();
	}
}
