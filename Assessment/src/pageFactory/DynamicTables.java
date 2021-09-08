package pageFactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicTables {
	
	@FindBy(xpath = "//*[text()='Table']/following-sibling::*")
	public static WebElement TableHome;
	
	@FindBy(tagName = "th")
	public static List<WebElement> ColCount;
	
	@FindBy(tagName = "tr")
	public static List<WebElement> RowCount;
	
	@FindBy(xpath = "//*[text()='Learn to interact with Elements']/following-sibling::td[1]")
	public static WebElement ProgValue;
	
	@FindBy(xpath = "//td[2]")
	public static List<WebElement> ProgAllValues;
	
	@FindBy(xpath = "//*[text()='30%']/following::input[1]")
	public static WebElement ClickCheckbox;
	
	@FindBy(xpath = "//*[text()='Advance Web Table']/following-sibling::*")
	public static WebElement SortTableHome;
	
	@FindBy(xpath = "//td[2]")
	public static List<WebElement> NameDefaultOrder;
	
	@FindBy(xpath = "//*[text()='Name']")
	public static WebElement NameCol;
	
	@FindBy(xpath = "//td[2]")
	public static List<WebElement> NameAsecOrder;
 
}
