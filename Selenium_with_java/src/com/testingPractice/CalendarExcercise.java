package com.testingPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarExcercise {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/leonardoramirez/Desktop/selenium/chromedriver");

		WebDriver chrome = new ChromeDriver();

		chrome.get("https://www.path2usa.com/travel-companions");

		chrome.findElement(By.xpath("//input[@id='travel_date']")).click();

		while (!chrome.findElement(By.cssSelector("div[class='datepicker-days'] th[class='datepicker-switch']"))
				.getText().contains("March")) {
			chrome.findElement(By.cssSelector("div[class='datepicker-days'] th[class='next']")).click();
		}

		List<WebElement> days = chrome.findElements(By.className("day"));
		int count = days.size();

		for (int i = 0; i < count; i++) {
			String texto = days.get(i).getText();

			if (texto.equalsIgnoreCase("23")) {
				days.get(i).click();
				break;
			}
		}

		Thread.sleep(3000);
		chrome.quit();

	}

}
