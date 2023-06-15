package com.selenium_practices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElement_Vs_FindElements {
	public static void main(String[] args) {
		// Using Webdriver Manager
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		// findElement()-->Return the Single WebElement
		/*
		 * // 1. WebElement searchBox = driver.findElement(By.id("small-searchterms"));
		 * searchBox.sendKeys("ABC"); // 2. WebElement ele =
		 * driver.findElement(By.xpath("//div[@class='footer-upper']//a"));
		 * System.out.println(ele.getText()); // 3. WebElement login =
		 * driver.findElement(By.xpath("//button[normalize-space()='login']"));
		 * System.out.println(login.getText());
		 */

		// findElements()--> Returns multiple webelements
		// 1.
		List<WebElement> links = driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
		System.out.println("Number Of Elements Captured : " + links.size());
		for (WebElement elements : links) {
			System.out.println(elements.getText());
		}

		// 2.
		List<WebElement> logo = driver.findElements(By.xpath("//img[@alt='nopCommerce demo store']"));
		System.out.println("Number Of Elements Captured : " + logo.size());

		// 3.
		List<WebElement> electronics = driver.findElements(By.xpath("//img[contains(title,'Electronics')]"));
		System.out.println("Number Of Elements Captured : " + electronics.size());
	}
}
