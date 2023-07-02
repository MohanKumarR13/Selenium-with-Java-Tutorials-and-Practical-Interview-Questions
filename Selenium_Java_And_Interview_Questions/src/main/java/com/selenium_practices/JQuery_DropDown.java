package com.selenium_practices;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQuery_DropDown {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();
		driver.findElement(By.id("justAnInputBox")).click();
		selectChoiceValue(driver, "choice 2");
	}

	public static void selectChoiceValue(WebDriver driver, String... value) {
		List<WebElement> choiceList = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		if (value[0].equalsIgnoreCase("all")) {
			for (WebElement item : choiceList) {
				String text = item.getText();
				for (String val : value) {
					if (text.equals(val)) {
						item.click();
						break;
					}
				}
			}
		} else {
			try {
				for (WebElement item : choiceList) {
					item.click();
				}
			} catch (Exception e) {

			}
		}
	}

}
