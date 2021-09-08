package seleniumHandsOn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcelJXL {

	WebDriver driver;
	String[] data;
	String[] receiveExcelData;
	WebElement TxtBox;

	@DataProvider(name = "sendData")
	public String[] dataprov() throws BiffException, IOException {
		receiveExcelData = ExcelData();
		return receiveExcelData;
	}

	public String[] ExcelData() throws BiffException, IOException {
		FileInputStream ExcelFile = new FileInputStream("F:\\Senthil\\Testing\\Tutorials\\Test Data\\TestMyKnow.xls");
		Workbook book= Workbook.getWorkbook(ExcelFile);
		Sheet getSheet = book.getSheet(0);
		int rowdata = getSheet.getRows();

		data = new String[rowdata];
		
		for (int i=0; i<rowdata; i++) {
			data[i] = getSheet.getCell(0,i).getContents();
					}
		return data;
	}

	@BeforeTest
	public void OpenBrow() {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.navigate().to("https://www.google.co.in/");		 

	}
	
	@Test(dataProvider = "sendData")
	public void GoogleSrch(String SrchTerm) throws InterruptedException {
		
		TxtBox =driver.findElement(By.name("q"));
		TxtBox.sendKeys(SrchTerm);
		Thread.sleep(2000);
		TxtBox.clear();
		
	}
	
	@AfterTest
	public void CloseBrow() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}
}
