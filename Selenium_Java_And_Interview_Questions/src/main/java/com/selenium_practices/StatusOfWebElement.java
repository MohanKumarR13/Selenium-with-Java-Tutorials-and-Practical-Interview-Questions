package com.selenium_practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StatusOfWebElement {
	static WebDriver driver;

	public static void main(String[] args) {
		// Using Webdriver Manager
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.nopcommerce.com/en/register");
		WebElement FirstName = driver.findElement(By.name("FirstName"));
		// Is Enabled and Is Displayed
		System.out.println("Enable Status : " + FirstName.isEnabled());
		System.out.println("Display Status : " + FirstName.isDisplayed());

	}

}
