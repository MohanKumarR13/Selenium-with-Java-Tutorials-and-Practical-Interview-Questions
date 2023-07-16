package com.selenium_practices;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitExample {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.addArguments("--disable-notifications");
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver(edgeOptions);
		driver.manage().window().maximize();
		Wait<WebDriver> myWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		driver.navigate().to("https://www.google.com/");
		// Fluent Wait
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);

		By elementLocator = By.xpath("//*[text()='Selenium WebDriver']");
		waitForElementWithFluentWait(driver, elementLocator);
	}

	public static WebElement waitForElementWithFluentWait(WebDriver driver, final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(4)).ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
		return element;

	}
}
