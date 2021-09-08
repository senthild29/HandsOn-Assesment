package testknowledge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/sorttable.html");
		driver.manage().window().maximize();
		
		//searching a value using sendkeys
		WebElement srchbox = driver.findElement(By.xpath("//*[@id=\"table_id_filter\"]/label/input"));
		srchbox.sendKeys("1019");
		
		//getting the all the record for emp_id 1019
		WebElement tbdata = driver.findElement(By.xpath("//tr[@class=\"odd\"]"));
		System.out.println(tbdata.getText());
	}

}
