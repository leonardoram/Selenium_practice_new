package com.testingPractice;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EcommerceWaitsTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/leonardoramirez/Desktop/selenium/chromedriver");

		WebDriver chrome = new ChromeDriver();
		chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		chrome.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		String [] items = {"Cucumber", "Brocolli","Tomato"};
		
		addItems(chrome, items);
		
		chrome.findElement(By.xpath("//a[@class='cart-icon']")).click();
		chrome.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		//Thread.sleep(3000);
		
		chrome.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		chrome.findElement(By.cssSelector(".promoBtn")).click();
		
		
		
		WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("span.promoInfo"))));
		
		System.out.println(chrome.findElement(By.cssSelector("span.promoInfo")).getText());
		
		
		Thread.sleep(5000);
		chrome.quit();

	}
	
	public static void addItems(WebDriver driver, String [] list) {
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		//iteration for each product 
		int j = 0;
		for (int i = 0; i < products.size(); i++) {
			//formatting the string so we can click over product 
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();

			// convert array to arraylist to use contains method
			List<String> vegetales = Arrays.asList(list);

			if (vegetales.contains(formattedName)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;
			}
			if (j == list.length) {
				//using break word to stop the iteration and continue execution 
				break;
			}
		}
		
	}

}
