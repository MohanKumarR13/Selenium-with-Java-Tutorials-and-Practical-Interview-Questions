package com.selenium_practices;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseDoubleClickAction {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		WebElement field = driver.findElement(By.xpath("//input[@id='field1']"));
		field.clear();
		field.sendKeys("Welcome to selenium");
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		Actions actions = new Actions(driver);
		actions.contextClick(button).perform();
	}
}