package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementDatePickers {
	
	@FindBy(xpath = "//i[@class='glyphicon glyphicon-th']")
	public static WebElement DateMenu;
	
	@FindBy(xpath = "//td[@class='old day']/following::th[1]")
	public static WebElement TodayBtn;
	
	@FindBy(xpath = "//*[@class='input-group date']/child::input[1]")
	public static WebElement InputBox1;
	
	@FindBy(xpath = "//td[@class='old day']/following::th[2]")
	public static WebElement ClearBtn;
	
	@FindBy(xpath = "//*[@id='datepicker']/child::input[1]")
	public static WebElement StartDate;
	
	@FindBy(xpath = "//td[text()='9']/following-sibling::td[1]")
	public static WebElement SelectStartDate;
	
	@FindBy(xpath = "//*[@id='datepicker']/child::input[2]")
	public static WebElement EndDate;
	
	@FindBy(xpath = "//td[text()='9']/following-sibling::td[5]")
	public static WebElement SelectEndDate;

}
