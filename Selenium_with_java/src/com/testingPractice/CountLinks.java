package com.testingPractice;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CountLinks {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "/Users/leonardoramirez/Desktop/selenium/geckodriver");
		WebDriver firefox = new FirefoxDriver();

		firefox.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> links = firefox.findElements(By.tagName("a"));
		System.out.println("links present in all page: " + links.size());

		WebElement foot = firefox.findElement(By.id("gf-BIG"));

		WebElement column = foot.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));

		for (int i = 1; i < column.findElements(By.tagName("a")).size(); i++) {

			String clickonlink = Keys.chord(Keys.COMMAND, Keys.ENTER);
			column.findElements(By.tagName("a")).get(i).sendKeys(clickonlink);

		}
		Set<String> tabs = firefox.getWindowHandles();
		Iterator<String> it = tabs.iterator();

		while (it.hasNext()) {
			firefox.switchTo().window(it.next());
			Thread.sleep(2000);
			System.out.println(firefox.getTitle());

		}

		Thread.sleep(3000);
		firefox.quit();

	}

}
