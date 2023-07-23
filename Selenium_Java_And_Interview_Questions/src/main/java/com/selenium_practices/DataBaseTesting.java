package com.selenium_practices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataBaseTesting {
	static String fname = "John";
	static String lname = "Wick";
	static String email = "john123@gmail.com";
	static String pwd = "John123@";

	public static void main(String[] args) throws SQLException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/index.php?route=account/register&language=en-gb");
		driver.manage().window().maximize();
		driver.findElement(By.name("firstname")).sendKeys(fname);
		driver.findElement(By.name("lastname")).sendKeys(lname);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Continue']")).click();
		String confirmMsg = driver.findElement(By.name("//h1[text()='Your Account Has Been Created!']")).getText();
		try {
			if (confirmMsg.equals("Your Account Has Been Created!")) {
				System.out.println("Register Successful In UI/Application");
			} else {
				System.out.println("Register Not Successful");

			}
		} catch (Exception e) {
			System.out.println("Some Problem In UI/Application");
		}
		// 1.Create a conncetion
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/opencart", "root", "root");

		// 2.Create Statement/Query
		Statement statement = connection.createStatement();
		String select = "SELECT firstname,lastname,email,password FROM opencartusers";

		// 3.Excecute Statement/Query
		statement.execute(select);

		// 4.Store Data in Result set
		ResultSet resultSet = statement.executeQuery(select);
		boolean status = false;
		while (resultSet.next()) {
			String firstname = resultSet.getString("firstname");
			String lastname = resultSet.getString("lastname");
			String email = resultSet.getString("email");
			String password = resultSet.getString("password");
			if (fname.equals(firstname) && lname.equals(lastname) && email.equals(email) && pwd.equals(password)) {
				System.out.println("Record Found In Table || Test Passed");
				status = true;
				break;
			}
		}
		if (status == false) {
			System.out.println("Record Not Found || Test Failed");

		}

	}

}
