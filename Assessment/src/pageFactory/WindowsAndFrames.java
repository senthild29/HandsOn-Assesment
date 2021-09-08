package pageFactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowsAndFrames {
	
	@FindBy(xpath = "//*[text()='Frame']/following-sibling::*")
	public static WebElement FramesHome;
	
	@FindBy(tagName = "iframe")
	public static List<WebElement> NoofFrames;
	
	@FindBy(id = "Click")
	public static WebElement Frame1;
	
	@FindBy(id = "Click1")
	public static WebElement Frame2;
	
	@FindBy(xpath = "//*[text()='Window']/following-sibling::*")
	public static WebElement WindowsHome;
	
	@FindBy(id = "home")
	public static WebElement HomePgBtn;
	
	@FindBy(xpath = "//*[text()='Open Multiple Windows']")
	public static WebElement MultiPgBtn;
	
	

}
