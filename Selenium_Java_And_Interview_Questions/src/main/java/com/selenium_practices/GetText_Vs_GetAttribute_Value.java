package com.selenium_practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetText_Vs_GetAttribute_Value {
	public static void main(String[] args) {
		// Using Webdriver Manager
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://admin-demo.nopcommerce.com/login");

		WebElement emailInputBox = driver.findElement(By.id("Email"));
		emailInputBox.clear();
		emailInputBox.sendKeys("123@gmail.com");

		// Capturing text from input box
		System.out.println("Result from getAttribute() method : " + emailInputBox.getAttribute("value"));
		System.out.println("Result from getText() method : " + emailInputBox.getText());

		// Login button
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
		System.out.println(button.getAttribute("type"));
		System.out.println(button.getAttribute("class"));
		System.out.println(button.getText());
		String title = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
		System.out.println(title);

	}
}