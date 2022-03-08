package com.testingPractice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinkstest {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/leonardoramirez/Desktop/selenium/geckodriver");

		WebDriver fire = new FirefoxDriver();
		fire.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		SoftAssert a = new SoftAssert();

		List<WebElement> urls = fire.findElements(By.cssSelector("li[class='gf-li'] a"));
		System.out.println(urls.size());
		for (WebElement link : urls) {

			String liga = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(liga).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();

			int resp = conn.getResponseCode();
			if (resp > 400) {
				a.assertTrue(false);
				System.out.println("link failed: " + link.getText() + "response code: " + resp);
			}
			System.out.println(resp);
		}
		
		a.assertAll();

		// use java methods to make calls to the urls and get the status code
		/*
		 * HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		 * conn.setRequestMethod("HEAD"); conn.connect();
		 * 
		 * int resp = conn.getResponseCode();
		 */

		Thread.sleep(3000);
		fire.quit();

	}

}
