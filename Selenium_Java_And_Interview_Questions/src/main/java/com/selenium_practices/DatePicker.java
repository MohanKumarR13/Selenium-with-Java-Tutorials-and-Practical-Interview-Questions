package com.selenium_practices;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://redbus.in/");
		driver.manage().window().maximize();
		String year = "2023";
		String month = "September";
		String date = "16";
		driver.findElement(By.xpath("//*[@id='onwardCal']")).click();
		while (true) {
			String monthYear = driver.findElement(By.xpath("//*[@class='sc-eNQAEJ doStZx topSection']")).getText();
			String arr[] = monthYear.split(" ");
			String yr = arr[1];
			String mon = arr[0];
			if (mon.equalsIgnoreCase(month) && yr.equals(year))
				break;
			else
				driver.findElement(By.xpath("//*[@class='sc-eNQAEJ doStZx topSection']")).click();
		}
		// Date selection
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));

		for (WebElement ele : allDates) {
			String dates = ele.getText();
			if (dates.equals(date))
				ele.click();
			break;

		}

	}

}
