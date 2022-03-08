package com.testingPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/leonardoramirez/Desktop/selenium/chromedriver");

		WebDriver chrome = new ChromeDriver();

		chrome.get("https://rahulshettyacademy.com/AutomationPractice/");

		chrome.findElement(By.id("name")).sendKeys("testitu");

		Thread.sleep(3000);
		chrome.findElement(By.id("alertbtn")).click();

		String alerta = chrome.switchTo().alert().getText();
		System.out.println(alerta);
		chrome.switchTo().alert().accept();

		chrome.findElement(By.id("confirmbtn")).click();
		String alertita = chrome.switchTo().alert().getText();
		System.out.println(alertita);
		chrome.switchTo().alert().dismiss();

		Thread.sleep(3000);
		chrome.quit();

	}

}
