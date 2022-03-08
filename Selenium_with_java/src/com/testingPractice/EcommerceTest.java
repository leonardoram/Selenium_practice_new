package com.testingPractice;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EcommerceTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/leonardoramirez/Desktop/selenium/chromedriver");

		WebDriver chrome = new ChromeDriver();
		chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		chrome.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		//create an array that shows products we will add 
		String[] veggies = { "Cucumber", "Brocolli" };

		//wait for the page to load completely 
		Thread.sleep(3000);

		//arraylist of web elements for each product 
		List<WebElement> products = chrome.findElements(By.cssSelector("h4.product-name"));

		//iteration for each product 
		int j = 0;
		for (int i = 0; i < products.size(); i++) {
			//formatting the string so we can click over product 
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();

			// convert array to arraylist to use contains method
			List<String> vegetales = Arrays.asList(veggies);

			if (vegetales.contains(formattedName)) {
				chrome.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;
			}
			if (j == veggies.length) {
				//using break word to stop the iteration and continue execution 
				break;
			}
		}

		Thread.sleep(5000);
		chrome.quit();

	}

}
