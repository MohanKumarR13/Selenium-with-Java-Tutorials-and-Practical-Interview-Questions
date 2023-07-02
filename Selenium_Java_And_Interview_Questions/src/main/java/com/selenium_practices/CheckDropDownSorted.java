package com.selenium_practices;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckDropDownSorted {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
		WebElement dropElement = driver.findElement(By.name("category_id"));
		Select select = new Select(dropElement);
		List<WebElement> optionList = select.getOptions();
		ArrayList<String> originalList = new ArrayList<String>();
		ArrayList<String> tempList = new ArrayList<String>();
		for (WebElement option : optionList) {
			originalList.add(option.getText());
			tempList.add(option.getText());
		}
		System.out.println("Original List " + originalList);
		System.out.println("Temp List " + tempList);
		Collections.sort(tempList);
		System.out.println("Original List " + originalList);
		System.out.println("Temp List After Sort " + tempList);
		if (originalList.equals(tempList)) {
			System.out.println("DropDown Sorted");
		} else {
			System.out.println("DropDown UnSorted");
		}
		driver.close();
	}

}
