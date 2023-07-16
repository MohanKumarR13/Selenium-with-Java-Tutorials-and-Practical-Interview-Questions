package com.selenium_practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleIframe {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.manage().window().maximize();
		// 1st frame
		driver.switchTo().frame("packageListFrame"); // name of the frame
		driver.findElement(By.xpath("//a[normalize-space()='org.openqa.selenium']")).click();
		driver.switchTo().defaultContent();// go back to the main page
		Thread.sleep(3000);
		// 2nd frame
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.xpath("//a[normalize-space()='WebDriver']")).click();
		driver.switchTo().defaultContent();// go back to the main page

		Thread.sleep(5000);

		// 3rd frame
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("//div[@class='topNav']//a[text()='Help']")).click();
		driver.switchTo().defaultContent();// go back to the main page
		Thread.sleep(3000);

	}

}
