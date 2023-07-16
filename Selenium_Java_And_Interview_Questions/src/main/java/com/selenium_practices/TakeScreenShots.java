package com.selenium_practices;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenShots {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		// Full Page screenshot
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File src1 = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File trg1 = new File(".\\homepage.png");
		FileUtils.copyFile(src1, trg1);
		// Screenshot of section/portion of the page
		WebElement section = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File src2 = section.getScreenshotAs(OutputType.FILE);
		File trg2 = new File(".\\featureproducts.png");
		FileUtils.copyFile(src2, trg2);
		// Screenshot of section/portion of the page
		WebElement ele = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		File src3 = ele.getScreenshotAs(OutputType.FILE);
		File trg3 = new File(".\\logo.png");
		FileUtils.copyFile(src3, trg3);
	}
}
