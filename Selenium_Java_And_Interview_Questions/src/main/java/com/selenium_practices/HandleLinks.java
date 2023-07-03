package com.selenium_practices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleLinks {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.amazon.in/");
		// driver.findElement(By.xpath("//a[contains(@href,'/deals?ref_=nav_cs_gb')]")).click();
		// driver.findElement(By.partialLinkText("Deals")).click();

		// How To Capture All Links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("No Of Links Presented :" + links.size());
	
		for (int i = 0; i < links.size(); i++) {
			System.out.println(links.get(i).getText());
			System.out.println(links.get(i).getAttribute("href"));

		}

		for (WebElement link : links) {
			System.out.println(link.getText());
			System.out.println(link.getAttribute("href"));

		}

	}

}
