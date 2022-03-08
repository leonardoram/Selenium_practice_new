package com.testingPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavascriptExecution {

	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "/Users/leonardoramirez/Desktop/selenium/chromedriver");

		WebDriver chrome = new ChromeDriver();
		
		JavascriptExecutor js =  (JavascriptExecutor) chrome;
		
		chrome.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		//grid example 
		int sum =0;
		List<WebElement> values = chrome.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		for(int i=0; i < values.size(); i++) {
			sum = sum + Integer.parseInt(values.get(i).getText());
		}
		String total = chrome.findElement(By.className("totalAmount")).getText();
		String[] totalnum = total.split(": ");
		
		for(String totalito:totalnum) {
			System.out.println(totalito);
		}
		
		
		Assert.assertEquals(sum, Integer.parseInt(totalnum[1].trim()));
		Thread.sleep(3000);
		chrome.quit();
		

	}

}
