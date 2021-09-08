package seleniumInterviewQues;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PrintGoogleSearch {

	@Test
	public void OpenBrow() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.google.co.in/");

		WebElement TxtBx =driver.findElement(By.name("q"));
		TxtBx.sendKeys("chennai");
		Thread.sleep(1000);

		List<WebElement>  allElements = driver.findElements(By.xpath("//ul[@role='listbox']/li"));

		//Scenario# 1 Print search term suggestion
		/*
		 * for (WebElement iterate: allElements) {
		 * System.out.println(iterate.getText());
		 * 
		 * }
		 */

		//Scenario# 2 Click specific google suggestion
		/*
		 * for (WebElement iterate1 : allElements) { 
		 * if(		 * iterate1.getText().contains("Kings")) {
		 *  iterate1.click(); 
		 *  break; 
			}
		 * }
		 */

		//Click using index();
		int i=0;
		for (WebElement iterate3 : allElements) {
			System.out.println(iterate3.getText());
			i++;
			if(i==3) {
				iterate3.click();
				break;
			}

		}
	}


}
