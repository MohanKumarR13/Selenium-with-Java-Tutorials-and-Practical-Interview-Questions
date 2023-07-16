package com.selenium_practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenShots {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.automationpractice.pl/index.php");
		driver.manage().window().maximize();
		WebElement features = driver.findElement(By.xpath("//a[@title='Women']"));
		Actions actions = new Actions(driver);
		// actions.moveToElement(features).perform();
		Action action = actions.moveToElement(features).build();
		action.perform();

	}
}