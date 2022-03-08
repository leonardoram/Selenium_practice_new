package com.testingPractice;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class VerifyTextStreams {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/leonardoramirez/Desktop/selenium/geckodriver");
		WebDriver firefox = new FirefoxDriver();

		firefox.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		firefox.findElement(By.id("search-field")).sendKeys("rice");
		List<WebElement> veggies = firefox.findElements(By.xpath("//tr/td[1]"));

		List<WebElement> filteredList = veggies.stream().filter(veggie -> veggie.getText().contains("Rice"))
				.collect(Collectors.toList());
		
		Assert.assertEquals(veggies.size(), filteredList.size());

		Thread.sleep(3000);
		firefox.quit();
	}

}
