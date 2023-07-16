package com.selenium_practices;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicityWaitExample {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.addArguments("--disable-notifications");
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver(edgeOptions);
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com/");
		// Implicity Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		driver.findElement(By.xpath("//*[text()='Selenium WebDriver']")).click();

	}
}
