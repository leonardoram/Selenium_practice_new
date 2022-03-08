package com.testingPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableExercise {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/leonardoramirez/Desktop/selenium/chromedriver");

		WebDriver chrome = new ChromeDriver();

		chrome.get("https://rahulshettyacademy.com/AutomationPractice/");

		// count rows and columns present in table
		List<WebElement> rows = chrome.findElements(By.cssSelector("table[name='courses'] tbody tr"));
		List<WebElement> columns = chrome.findElements(By.cssSelector("table[name='courses'] tbody tr th"));

		System.out.println("number of rows: " + rows.size());
		System.out.println("number of colums: " + columns.size());

		// print 2nd row info
		System.out.println(rows.get(2).getText());

		Thread.sleep(3000);
		chrome.quit();

	}

}
