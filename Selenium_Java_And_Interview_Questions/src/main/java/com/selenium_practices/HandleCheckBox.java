package com.selenium_practices;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckBox {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.manage().window().maximize();
		// Select Specific Check Box
		driver.findElement(By.xpath("//input[@id='monday']")).click();

		// Select All The Check Box
		List<WebElement> checkBoxes = driver
				.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		System.out.println("Total No Of Check Boxes :" + checkBoxes.size());

		// Using Loop
		for (int i = 0; i < checkBoxes.size(); i++) {
			checkBoxes.get(i).click();
		}
		// Using For Each Loop
		for (WebElement chBox : checkBoxes) {
			chBox.click();
		}
		// Select Multiple Check Boxes By Choice
		// Monday and Sunday
		for (WebElement chBox : checkBoxes) {
			String checkBoxName = chBox.getAttribute("id");
			if (checkBoxName.equals("monday") || checkBoxName.equals("sunday")) {
				chBox.click();
			}
			// Total No Of Check Box-No Of Check Box Want To Select=Starting Index
			// 7-2=5
			int totalCheckBox = checkBoxes.size();
			for (int i = totalCheckBox - 2; i < totalCheckBox; i++) {
				checkBoxes.get(i).click();
			}
			// Select the First Three Check Box

			for (int i = 0; i < totalCheckBox; i++) {
				if (i < 3)
					checkBoxes.get(i).click();
			}
		}
	}
}