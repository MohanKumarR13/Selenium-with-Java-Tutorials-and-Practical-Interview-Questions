package com.selenium_practices;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptUtilDemo {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		// Syntax
		// JavascriptExecutor js=(JavascriptExecutor) driver;
		// js.executeScript(Script,args);

		// Flash
		// Drawing Border And Take ScreenShot
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		JavaScriptUtil.drawBorder(logo, driver);
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\target\\logo.png");
		FileUtils.copyFile(src, trg);
		// Getting Title of the page
		String title = JavaScriptUtil.getTitle(driver);
		System.out.println(title);
		// Click Action
		WebElement regLink = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		JavaScriptUtil.clickElementByJs(regLink, driver);
		// GenerateAlertMessage
		JavaScriptUtil.generateAlert("Alert", driver);
		// Refresh the Page
		// JavaScriptUtil.refreshBrowserBy(driver);
		// Scroll Page Down
		JavaScriptUtil.scrollPageDown(driver);
		// Scroll Page Up
		JavaScriptUtil.scrollPageUp(driver);
		// Zoom Page
		JavaScriptUtil.zoomPageByJs(driver);
		// Flash
		WebElement logos = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		JavaScriptUtil.flash(logos, driver);

	}

}
