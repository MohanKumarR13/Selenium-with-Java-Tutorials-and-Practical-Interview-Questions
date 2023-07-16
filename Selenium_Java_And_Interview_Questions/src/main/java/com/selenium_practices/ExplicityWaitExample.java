package com.selenium_practices;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicityWaitExample {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.addArguments("--disable-notifications");
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver(edgeOptions);
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com/");
		// Explicity Wait
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		By elementLocators = By.xpath("//*[text()='Selenium WebDriver']");
		waitForElementPresent(driver, elementLocators, 10).click();
		/*
		 * WebElement element = myWait
		 * .until(ExpectedConditions.visibilityOfElementLocated(By.
		 * xpath("//*[text()='Selenium WebDriver']"))); element.click();
		 */

	}

	public static WebElement waitForElementPresent(WebDriver driver, By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return driver.findElement(locator);

	}
}
