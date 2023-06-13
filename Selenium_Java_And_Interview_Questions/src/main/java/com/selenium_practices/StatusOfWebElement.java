package com.selenium_practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StatusOfWebElement {
	static WebDriver driver;

	public static void main(String[] args) {
		// Using Webdriver Manager
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.nopcommerce.com/en/register");
		Boolean isEnable = driver.findElement(By.name("FirstName")).isEnabled();
		Boolean isDisplay = driver.findElement(By.name("FirstName")).isDisplayed();
		if (isEnable) {
			System.out.println("First Name Input Box is Enabled");
		} else {
			System.out.println("First Name Input Box  is Not Enabled");

		}

		if (isDisplay) {
			System.out.println("First Name Input Box is Displayed");
		} else {
			System.out.println("First Name Input Box is Not Displayed");

		}

	}

}
