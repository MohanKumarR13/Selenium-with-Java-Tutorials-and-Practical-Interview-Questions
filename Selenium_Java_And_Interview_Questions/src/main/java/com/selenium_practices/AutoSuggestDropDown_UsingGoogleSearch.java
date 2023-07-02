package com.selenium_practices;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropDown_UsingGoogleSearch {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("java tutorial");
		Thread.sleep(5000);
		List<WebElement> list = driver.findElements(By.xpath("//li[@class='sbct']//div[@role='option']//div[1]//span"));
		System.out.println("Size Of Auto Suggestion :" + list.size());
		for(WebElement listItem:list) {
			if(listItem.getText().equals("beginners")) {
				listItem.click();
				break;
			}
		}
	}

}
