package com.selenium_practices;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrokenLinks {
	static WebDriver driver;

	public static void main(String[] args) throws MalformedURLException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.deadlinkcity.com/");
		int brokenLinks = 0;
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("No Of Links Presented :" + links.size());

		for (WebElement element : links) {
			String url = element.getAttribute("href");
			if (url == null || url.isEmpty()) {
				System.out.println("URL is Empty");
				continue ;
			}
			URL link = new URL(url);
			try {
				HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
				httpURLConnection.connect();
				if (httpURLConnection.getResponseCode() >= 400) {
					System.out.println(httpURLConnection.getResponseCode() + url + " is" + " Broken Link");
					brokenLinks++;
				} else {
					System.out.println(httpURLConnection.getResponseCode() + url + " is" + " Valid Link");

				}
			} catch (Exception e) {
				
			}
		}
		System.out.println("No Of Broken Links :" + brokenLinks);
		driver.quit();
	}

}
