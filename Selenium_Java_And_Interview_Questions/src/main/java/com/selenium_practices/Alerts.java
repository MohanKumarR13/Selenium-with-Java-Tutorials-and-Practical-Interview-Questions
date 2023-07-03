package com.selenium_practices;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
		/*
		 * // Alerts window OK button driver.findElement(By.
		 * xpath("//button[normalize-space()='Click for JS Alert']")).click();
		 * Thread.sleep(5000); driver.switchTo().alert().accept();
		 */
		// Alerts window OK and Cancel button

		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();// Close Alert By Using OK Button
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		driver.switchTo().alert().dismiss();// Close Alert By Using Cancel Button

		// Alerts window with input box,capture text from alert

		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		System.out.println("The Message Displayed On Alert : " + alert.getText());
		alert.sendKeys("Welcome");
		alert.accept();

	}
}
