package testknowledge;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class SendDataJXL {

	WebDriver driver;

	@DataProvider(name = "SendData")
	public String[][] UseDataProv() throws BiffException, IOException {
		String [][] testdata = ReadExcelFile();
		return testdata;
	}

	public String[][] ReadExcelFile() throws BiffException, IOException {
		FileInputStream fileloc = new FileInputStream("F:\\Senthil\\Testing\\Tutorials\\Test Data\\NewValo.xls");
		Workbook getBook = Workbook.getWorkbook(fileloc);
		Sheet getSheet = getBook.getSheet(0);

		int rows = getSheet.getRows();
		int cols = getSheet.getColumns();

		System.out.println("No of Rows :"+rows);
		System.out.println("No of Columns :"+cols);

		String [][] GetValue = new String[rows-1][cols];

		for(int i =1; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				GetValue[i-1][j] = getSheet.getCell(j, i).getContents();
			}
		}
		return GetValue;
	}
	@BeforeTest
	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.navigate().to("https://www.india.gov.in/online-registration");

	}

	@Test(dataProvider = "SendData")
	public void RegisterPage(String getUn, String GetPWD) {



		WebElement regLink = driver.findElement(By.xpath("//*[text()='Register']"));
		regLink.click();

		WebElement un = driver.findElement(By.id("edit-name"));
		un.sendKeys(getUn);

		WebElement mailid = driver.findElement(By.id("edit-mail"));
		mailid.sendKeys(GetPWD);

	}
	
@AfterSuite
	public void CloseBrowser() {
		driver.close();
	}


}
