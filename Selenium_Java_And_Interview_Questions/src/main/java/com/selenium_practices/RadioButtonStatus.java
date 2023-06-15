package com.selenium_practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtonStatus {
	static WebDriver driver;

	public static void main(String[] args) {
		// Using Webdriver Manager
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/radio.xhtml");
		WebElement Chrome = driver
				.findElement(By.xpath("//*[@id=\"j_idt87:console1\"]/tbody/tr/td[1]/div/div[2]/span"));
		WebElement FireFox = driver
				.findElement(By.xpath("//*[@id=\"j_idt87:console1\"]/tbody/tr/td[2]/div/div[2]/span"));

		// Is Selected
		System.out.println("Selected Status For Chrome : " + Chrome.isSelected());// False
		System.out.println("Selected Status For FireFox : " + FireFox.isSelected());// False
		Chrome.click();
		System.out.println("Selected Status For Chrome : " + Chrome.isSelected());
		System.out.println("Selected Status For FireFox : " + FireFox.isSelected());
		FireFox.click();
		System.out.println("Selected Status For Chrome : " + Chrome.isSelected());
		System.out.println("Selected Status For FireFox : " + FireFox.isSelected());

	}
}
