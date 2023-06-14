package com.selenium_practices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigations {
	static WebDriver driver;

	public static void main(String[] args) {
		// Using Webdriver Manager
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		driver.get("https://www.amazon.in/");
		driver.navigate().back();// To SnapDeal
		driver.navigate().forward();// To Amazon
		driver.navigate().refresh();// Refresh Or Reload
		driver.navigate().to("https://www.amazon.in/");

	}
}
