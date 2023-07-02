package com.selenium_practices;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropDown_BingSearch {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://bing.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("sb_form_q")).sendKeys("selenium");

		List<WebElement> list = driver.findElements(By.xpath("//li[@class='sa_sg as_extra_pad']//span"));
		System.out.println("Size Of Auto Suggestion :" + list.size());
		for(WebElement listItem:list) {
			if(listItem.getText().equals("selenium")) {
				listItem.click();
				break;
			}
		}
	}

}
