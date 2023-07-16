package com.selenium_practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverAction {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		WebElement desktopMenu = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		WebElement macMenuItem = driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(desktopMenu).moveToElement(macMenuItem).click();

	}
}