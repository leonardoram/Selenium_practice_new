package com.testingPractice;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class SortedWebElementsStreams {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/leonardoramirez/Desktop/selenium/geckodriver");

		WebDriver firefox = new FirefoxDriver();

		firefox.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		firefox.findElement(By.xpath("//tr/th[1]")).click();
		// capture all webelements into list
		List<WebElement> fruits = firefox.findElements(By.xpath("//tbody/tr/td[1]"));
		// capture text of all webelements into new list
		List<String> original = fruits.stream().map(s -> s.getText()).collect(Collectors.toList());
		// sort on the original list
		List<String> sortedlist = original.stream().sorted().collect(Collectors.toList());
		// compare lists if they are sorted as expected
		// Assert.assertTrue(original.equals(sortedlist));
		List<String > rows;
		do {
			List<WebElement> fruits2 = firefox.findElements(By.xpath("//tbody/tr/td[1]"));
			rows = fruits2.stream().filter(s -> s.getText().contains("Beans"))
					.map(s -> getpriceVeggies(s))
					.collect(Collectors.toList());

			rows.forEach(a -> System.out.println(a));
			if(rows.size()< 1) {
				firefox.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		}
		while(rows.size()< 1);
		
		Thread.sleep(3000);
		firefox.quit();
	}

	private static String getpriceVeggies(WebElement s) {
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
