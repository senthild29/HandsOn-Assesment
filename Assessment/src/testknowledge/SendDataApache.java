package testknowledge;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendDataApache {
	
	public void ReadExcel() throws IOException {
		
		FileInputStream floc = new FileInputStream("F:\\Senthil\\Testing\\Tutorials\\Test Data\\TestValo.xls");
		
		Workbook book = new HSSFWorkbook(floc);
		
		Sheet sheets = book.getSheetAt(0);
		
		Iterator<Row>  rowIterate = sheets.iterator();
		
		while(rowIterate.hasNext()) {
			Row  rows = rowIterate.next();
			Iterator<Cell> colIterate = rows.iterator();
			int i=2;
			while(colIterate.hasNext()) {
				Cell cols = colIterate.next();
				if(i%2==0) {
					UserList.add(cols.getStringCellValue());
					
				}
				else {
					PwdList.add(cols.getStringCellValue());
				}
				i++;
			}
		}
		
	}

	public void Login(String getUN, String GetPWD) {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://www.india.gov.in/online-registration");
		
		WebElement regLink = driver.findElement(By.xpath("//*[text()='Register']"));
		regLink.click();

		WebElement un = driver.findElement(By.id("edit-name"));
		un.sendKeys(getUN);

		WebElement mailid = driver.findElement(By.id("edit-mail"));
		mailid.sendKeys(GetPWD);

		driver.close();
	}
	
	public void ExecuteTestCase() {
		
		for(int i=1; i<UserList.size(); i++) {
			
			Login(UserList.get(i), PwdList.get(i));
		}
	}
	
	static List<String> UserList = new ArrayList<String>();
	static List<String> PwdList = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException {
		
		SendDataApache MainMethod = new SendDataApache();
		
		MainMethod.ReadExcel();
		
		System.out.println("User Name List :"+UserList);
		System.out.println("Password List :"+PwdList);
		
		//MainMethod.ExecuteTestCase();
		// TODO Auto-generated method stub
		
		

	}

}
