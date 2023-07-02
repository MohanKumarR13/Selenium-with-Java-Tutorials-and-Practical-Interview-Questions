package com.selenium_practices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDown {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.leafground.com/select.xhtml;jsessionid=node012ev41d67vjje5p5peg0bi78q323617.node0");
		driver.manage().window().maximize();
		WebElement drpCountryEle = driver
				.findElement(By.xpath("//*[@id=\"j_idt87\"]/div/div[1]/div[1]/div/div/select"));
		Select select = new Select(drpCountryEle);
		// select.selectByVisibleText("Selenium");
		// select.selectByValue("1");
		//select.selectByIndex(1);
		// Select Option From Dropdown withut using methods
		List<WebElement> allOptions = select.getOptions();
		for (WebElement option : allOptions) {
			if (option.getText().equals("Selenium")) {
				option.click();
				break;
			}
		}
	}

}
