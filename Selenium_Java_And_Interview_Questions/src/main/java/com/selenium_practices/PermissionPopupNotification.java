package com.selenium_practices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PermissionPopupNotification {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		EdgeOptions edgeOptions=new EdgeOptions();
		edgeOptions.addArguments("--disable-notifications");
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://redbus.in/");
	

	}
}
