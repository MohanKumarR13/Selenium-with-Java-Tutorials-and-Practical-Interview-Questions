package com.selenium_practices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {
	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
		driver.manage().window().maximize();
		// How Many Rows In Table
		int rows = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr")).size();
		System.out.println("Total number of Rows In Table : " + rows);
		// How Many Columns In Table
		int column = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr/th")).size();
		System.out.println("Total number of Rows In Table : " + column);
		// Retrieve the specific row/column data
		String value = driver.findElement(By.xpath("//*[@id='customers']/tbody/tr[2]/td[2]")).getText();
		System.out.println("The Value is " + value);

		// Retrieve All the Data from the table
		System.out.println("Data From Table");
		for (int r = 1; r <= rows; r++) {
			for (int c = 1; c <= column; c++) {
				String data = driver.findElement(By.xpath("//*[@id='customers']//tr[" + r + "]/td[" + c + "]"))
						.getText();
				System.out.print(data + " ");
			}
			System.out.println();
		}

		// Print Data
		for (int r = 1; r <= rows; r++) {
			String data = driver.findElement(By.xpath("//*[@id='customers']/tbody/tr[2]/td[2]")).getText();
			if (data.equals("Maria Anders")) {
				String values = driver.findElement(By.xpath("//*[@id='customers']/tbody/tr[" + r + "]/td[1]"))
						.getText();
				System.out.println(values);

			}
		}
	}

}
