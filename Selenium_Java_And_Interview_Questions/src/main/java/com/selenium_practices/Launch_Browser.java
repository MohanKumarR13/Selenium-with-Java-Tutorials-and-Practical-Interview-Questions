package com.selenium_practices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Launch_Browser {
	static WebDriver driver;

	public static void main(String[] args) {
		// Using Webdriver Manager
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.nopcommerce.com/en");
		System.out.println("Title of the web page : " + driver.getTitle());
		System.out.println("Title of the web page : " + driver.getCurrentUrl());
		System.out.println(driver.getPageSource());

	}
}
