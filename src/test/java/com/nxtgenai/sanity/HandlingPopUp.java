package com.nxtgenai.sanity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class HandlingPopUp {

	public WebDriver driver;	

	@Test(priority = 1)
	public void launchApplication() {

		// Input values
		// String url = "https://nxtgenaiacademy.com/alertandpopup/";
		String url ="http://localhost:9090/PopUpHandling/";
		// Set the system property for the edge driver file 
		System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");

		// Creating the object instance for the edge browser in the webdriver interface 
		// classname objname = new classnameconstructor();
		driver = new FirefoxDriver();

		// launch thr url
		driver.get(url);

		// maximize the browser
		driver.manage().window().maximize();
		System.out.println("Application is launched");
		System.out.println("DevOps CI CD");

	}	


	@Test(priority = 2)
	public void handlingPopUp() {	  

		// Handling confirm alert box 
		WebElement confirmAlertBoxBtn = driver.findElement(By.name("confirmalertbox"));
		confirmAlertBoxBtn.click();

		// Capture the message 
		String confirmAlertBoxMsg = driver.switchTo().alert().getText();
		System.out.println(confirmAlertBoxMsg);

		// Click on Ok button 
		driver.switchTo().alert().accept();
		System.out.println("Ok button is clicked");

		confirmAlertBoxBtn.click();

		// click on cancel
		driver.switchTo().alert().dismiss();
		System.out.println("Cancel button is clicked");	

	}


	@Test(priority = 3)
	public void closeApplication() {

		driver.quit();
		System.out.println("Application is closed");

	}
}
