package testknowledge;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAttributes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.india.gov.in/online-registration");
		driver.manage().window().maximize();

		//Finding X-path using child axes
		WebElement registerlink = driver.findElement(By.xpath("//div[@class='tophead_right']/child::a[2]"));
		registerlink.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Finding X-path using Elements and Attributes
		WebElement un = driver.findElement(By.xpath("//input[@id='edit-name']"));
		un.sendKeys("testuser");

		//Finding X-path using multiple Attributes
		WebElement mailid = driver.findElement(By.xpath("//input[@id='edit-mail'][@name='mail'][@type='text']"));
		mailid.sendKeys("test.user@gmail.com");

		//Finding X-path using contains() function
		WebElement pwd1 = driver.findElement(By.xpath("//input[contains(@id,'pass1')]"));
		pwd1.sendKeys("User@2021");

		//Finding X-path using following axes
		WebElement pwd2 = driver.findElement(By.xpath("//input[contains(@id,'pass1')]/following::input[1]"));
		pwd2.sendKeys("User@2021");

		//Finding X-path using Preceding axes
		WebElement fn = driver.findElement(By.xpath("//input[@id='edit-profile-main-field-last-name-und-0-value']/preceding::input[1]"));
		fn.sendKeys("John");

		//Finding X-path using start-swith and following-sibling axes
		WebElement ln = driver.findElement(By.xpath("//label[starts-with(text(),'Last')]/following-sibling::input"));
		ln.sendKeys("Smith");


		//Finding X-path using Preceding-sibling axes
		WebElement chk = driver.findElement(By.xpath("//*[starts-with(text(),'Subscribe')]/preceding-sibling::input[1]"));
		chk.click();

		//Finding X-path using text() function
		WebElement dd = driver.findElement(By.xpath("//*[text()='Higher Secondary Education']"));
		dd.click();
		
		//After filling all the details going back to home page using back funcions
		driver.navigate().back();
	}

}
