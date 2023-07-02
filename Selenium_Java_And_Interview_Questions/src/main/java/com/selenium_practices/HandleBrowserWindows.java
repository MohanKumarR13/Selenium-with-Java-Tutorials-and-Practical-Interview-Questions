package com.selenium_practices;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		// getWindowHandle
		String windowID = driver.getWindowHandle();// return ID of the single browser window
		System.out.println(windowID);
		Thread.sleep(7000);
		// getWindowHandles
		driver.findElement(By.name("username")).sendKeys(Keys.TAB, Keys.TAB, Keys.TAB);
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		Set<String> windowIDs = driver.getWindowHandles();// return ID's of multiple browser windows

		// First method-iterator()
		Iterator<String> iterator = windowIDs.iterator();
		String parentWindowID = iterator.next();
		String childWindowID = iterator.next();
		System.out.println("Parent window ID :" + parentWindowID);
		System.out.println("Child Window ID " + childWindowID);

		// Second Method-using List/ArrayList List<String>windowIDsList=new
		List<String> windowIDsList = new ArrayList<String>(windowIDs);// Converting Set-->List String
		String parentWindow_ID = windowIDsList.get(0);
		String childWindow_ID = windowIDsList.get(1);
		System.out.println("Parent window ID :" + parentWindow_ID);
		System.out.println("Child Window ID " + childWindow_ID);

		// How to use window ID's for Switching
		driver.switchTo().window(parentWindow_ID);
		System.out.println("Parent Window Title :" + driver.getTitle());

		// For Each
		for (String winID : windowIDsList) {
			System.out.println(winID);
			String title = driver.switchTo().window(winID).getTitle();
			System.out.println(title);
		}

		for (String winID : windowIDsList) {
			String title = driver.switchTo().window(winID).getTitle();
			if (title.equals("OrangeHRM"))
				driver.close();
		}
	}

}
