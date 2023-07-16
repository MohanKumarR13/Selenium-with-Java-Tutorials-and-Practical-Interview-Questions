package com.selenium_practices;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingCookies {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://orangehrmlive.com/");
		driver.manage().window().maximize();
		// How to capture cookies from browser
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("Size of Cookies : " + cookies.size());
		// How to print cookies from browser
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName() + " : " + cookie.getValue());
		}
		// How to add Cookie to the browser
		Cookie cookieObj = new Cookie("MyCookie", "123456");
		// driver.manage().addCookie(cookieObj);
		driver.manage().deleteCookieNamed("MyCookie");
		cookies = driver.manage().getCookies();
		System.out.println("Size of Cookie after Adding :" + cookies.size());

		// How to delete specific cookie from the browser
		driver.manage().deleteCookie(cookieObj);
		cookies = driver.manage().getCookies();
		System.out.println("Size Of Cookies after adding :" + cookies.size());

		// How to delete all cookies from the browser
		driver.manage().deleteAllCookies();
		cookies = driver.manage().getCookies();
		System.out.println("Size Of Cookies After Deletion :" + cookies.size());
	}

}
