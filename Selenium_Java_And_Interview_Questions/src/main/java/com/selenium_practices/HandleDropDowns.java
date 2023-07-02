package com.selenium_practices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDowns {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://www.leafground.com/select.xhtml;jsessionid=node012ev41d67vjje5p5peg0bi78q323617.node0");
		driver.manage().window().maximize();
		WebElement noOfTools = driver.findElement(By.xpath("//*[@id=\"j_idt87\"]/div/div[1]/div[1]/div/div/select"));
		selectOptionFromDropDown(noOfTools, "Selenium");
	}

	public static void selectOptionFromDropDown(WebElement ele, String value) {
		Select drp = new Select(ele);
		List<WebElement> allOptions = drp.getOptions();
		for (WebElement option : allOptions) {
			if (option.getText().equals(value)) {
				option.click();
				break;
			}
		}
	}

}