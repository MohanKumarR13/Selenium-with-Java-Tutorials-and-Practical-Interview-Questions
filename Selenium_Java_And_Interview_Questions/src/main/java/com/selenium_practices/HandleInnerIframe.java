package com.selenium_practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleInnerIframe {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();
		// 1st frame
		driver.findElement(By.xpath("//a[normalize-space()='Iframe with in an Iframe']")).click();
		WebElement outterFrame = driver.findElement(By.xpath("//*[@id='Multiple']/iframe"));
		driver.switchTo().frame(outterFrame);

		WebElement innerFrame = driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
		driver.switchTo().frame(innerFrame);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Welcome");

	}

}
