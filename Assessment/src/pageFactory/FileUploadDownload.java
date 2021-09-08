package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadDownload {

	@FindBy(xpath = "//*[text()='Upload Files']/following-sibling::*")
	public static WebElement FileUploadHome;
	
	@FindBy(name = "filename")
	public static WebElement ClickUpload;
	
	@FindBy(xpath = "//*[text()='DownLoad Files']/following-sibling::*")
	public static WebElement FileDownloadHome;
	
	@FindBy(linkText = "Download Excel")
			public static WebElement DownloadTxtFile;
}


