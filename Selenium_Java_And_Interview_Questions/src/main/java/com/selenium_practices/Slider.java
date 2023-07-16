package com.selenium_practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Slider {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		WebElement min_slider = driver.findElement(By.xpath("//span[1]"));
		System.out.println("Location of the min slider:" + min_slider.getLocation());// (59,251)
		System.out.println("Height and Width Of Element:" + min_slider.getSize());// (22,21)

		Actions actions = new Actions(driver);
		actions.dragAndDropBy(min_slider, 100, 0).perform();

		System.out.println("Location of the min slider:" + min_slider.getLocation());// (59,251)
		System.out.println("Height and Width Of Element:" + min_slider.getSize());// (22,21)
		
		WebElement max_slider=driver.findElement(By.xpath("//span[2]"));
		actions.dragAndDropBy(max_slider, 100, 0).perform();

	}
}