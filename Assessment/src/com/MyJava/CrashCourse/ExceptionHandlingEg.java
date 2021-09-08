package com.MyJava.CrashCourse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExceptionHandlingEg {

	public static void main(String[] args)   {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.google.co.in/");
		
		// enter the code which about to throw an exception
		try {
			WebElement TxtBox = driver.findElement(By.name("q"));
			TxtBox.sendKeys("Chennai"+Keys.ENTER);
			Thread.sleep(2000);
			WebElement TxtBox2= driver.findElement(By.name("q"));
			TxtBox2.clear();
		} 
		
		// Define the logic to throw the exception
		  catch (NoSuchElementException e) {
			System.out.println("Element not identified, please double check identifier");
		}
		 catch (StaleElementReferenceException e) {
			System.out.println("Please identify the element to perform an action");
			
			System.out.println("Identified element again");
		}
		 catch (InterruptedException e) {
			 System.out.println("Added Interrupted excpetion");
		  }
		
		// Irrespective of exception, code under finally block will get executed
		finally {
			driver.quit();
			System.out.println("Browser has been closed");
		}
	}

}
