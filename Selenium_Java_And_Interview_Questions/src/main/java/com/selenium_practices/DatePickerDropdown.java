package com.selenium_practices;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerDropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-applcation");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[@id='dob']")).click();
		Select month_drp = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		month_drp.deselectByVisibleText("Oct");

		Select year_drp = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		year_drp.deselectByVisibleText("1990");

		String date = "15";
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		for (WebElement ele : allDates) {
			String dt = ele.getText();
			if (dt.equals(date)) {
				ele.click();
				break;
			}
		}
	}
}