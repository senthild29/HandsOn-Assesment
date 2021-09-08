package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkImage {
	
	@FindBy(xpath = "//*[text()='HyperLink']/following-sibling::*")
	public static WebElement LinkHome;
	
	@FindBy(xpath = "//*[contains(text(),'Verify')]")
	public static WebElement VerifyLink;
	
	@FindBy(xpath = "//*[text()='Image']/following-sibling::*")
	public static WebElement ImageHome;
	
	@FindBy(xpath = "//img[contains(@src,'images/abcd.jpg')]")
	public static WebElement BrokenImage;
	

}
