package com.selenium_practices;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoCompleteGooglePlaceDropDown {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
		WebElement searchBox = driver.findElement(By.id("autocomplete"));
		searchBox.clear();
		searchBox.sendKeys("Toronto");
		String text;
		do {
			searchBox.sendKeys(Keys.ARROW_DOWN);
			text = searchBox.getAttribute("value");
			if (text.equals("Toronto, OH, USA")) {
				searchBox.sendKeys(Keys.ENTER);
				break;
			}Thread.sleep(5000);
		} while (!text.isEmpty());
	}

}
