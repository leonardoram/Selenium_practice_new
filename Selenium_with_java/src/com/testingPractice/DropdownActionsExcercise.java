package com.testingPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DropdownActionsExcercise {

	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "/Users/leonardoramirez/Desktop/selenium/chromedriver");

		WebDriver chrome = new ChromeDriver();
		chrome.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		chrome.findElement(By.id("autocomplete")).sendKeys("united");
		Thread.sleep(2000);
		
		Actions act = new Actions(chrome);
		
		WebElement united = chrome.findElement(By.xpath("//div[text()='United Kingdom (UK)']"));
		
		act.moveToElement(united).click().build().perform();
		Thread.sleep(2000);
		
		Assert.assertEquals(chrome.findElement(By.id("autocomplete")).getAttribute("value"), "United Kingdom (UK)");
		
		Thread.sleep(3000);
		chrome.quit();

	}

}
