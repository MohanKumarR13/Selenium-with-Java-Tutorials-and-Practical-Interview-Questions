package com.selenium_practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tooltip {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/tooltip/");
		driver.switchTo().frame(0);
		WebElement inputBox = driver.findElement(By.xpath("//input[@id='age']"));
		String tooltipText = inputBox.getAttribute("title");
		System.out.println(tooltipText);

	}

}
