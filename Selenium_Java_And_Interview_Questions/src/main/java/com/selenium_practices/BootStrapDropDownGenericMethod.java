package com.selenium_practices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootStrapDropDownGenericMethod {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://www.hdfcbank.com/");
		driver.manage().window().maximize();
		// Product Types
		driver.findElement(By.xpath("//div[@class='drp1']//div[@class='dropdown']")).click();
		List<WebElement> productTypes = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));
		System.out.println("Number Of Options " + productTypes.size());
		selectOptionFromDropDown(productTypes, "Accounts");

		/*
		 * for (WebElement pType : productTypes) { if
		 * (pType.getText().equals("Accounts")) { pType.click(); break; } }
		 */
		// Products
		driver.findElement(By.xpath("//div[@class='drp2']//div[@class='dropdown']")).click();
		List<WebElement> products = driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']/li"));
		System.out.println("Number Of Options " + products.size());
		selectOptionFromDropDown(products, "Salary Accounts");
		/*
		 * for (WebElement product : products) { if
		 * (product.getText().equals("Salary Accounts")) { product.click(); break; } }
		 */
	}
public static void selectOptionFromDropDown(List<WebElement>options,String value) {
	for (WebElement option : options) {
		if (option.getText().equals(value)) {
			option.click();
			break;
		}
	}
}
}
