package testknowledge;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileDownload {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://filesamples.com/categories/document"); 
		driver.manage().window().maximize();
			
		WebElement csv = driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div[2]/div[3]/a"));
		csv.click();		
		Thread.sleep(2000);
		
		WebElement csvdwn = driver.findElement(By.xpath("//*[@id=\"output\"]/div[1]/a"));
		csvdwn.click();
		Thread.sleep(2000);
		
		File downloadfile = new File("C:\\Users\\Senthil\\Downloads");
		
		File[] checkdownload = downloadfile.listFiles();
		
		for (File file : checkdownload) {
			if(file.getName().equals("sample1.csv")) {
				System.out.println("Your "+file.getName()+"file is downloaded successfully");
				break;
			}
			
		}
		 Thread.sleep(2000);
		 
		driver.close();
		
		//This download file executed using test leaf site.
		
		/*WebElement downloadhome = driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[18]/a/img"));
		downloadhome.click();		
		Thread.sleep(2000);
		
		// Download PDF
		WebElement downpdf = driver.findElement(By.linkText("Download PDF"));
		downpdf.click();
		Thread.sleep(3000);
		
		driver.navigate().back();
				
		
		// Download Text file
		WebElement downtext = driver.findElement(By.linkText("Download Text"));
		downtext.click();
		
		
		WebElement checkdownload = driver.findElement(By.xpath("/html/body/pre"));
		System.out.println("File status : "+checkdownload.getText()); */
		
	}

}
