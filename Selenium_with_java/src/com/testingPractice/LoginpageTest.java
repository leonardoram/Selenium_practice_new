package com.testingPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginpageTest {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/leonardoramirez/Desktop/selenium/chromedriver");

		WebDriver chrome = new ChromeDriver();

		chrome.get("https://rahulshettyacademy.com/loginpagePractise/");

		loginPage(chrome, "rahulshettyacademy", "learning");
		selectItemsAndCheckout(chrome);

		Thread.sleep(3000);
		chrome.quit();

	}

	public static void loginPage(WebDriver driver, String user, String password) {

		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(password);

		driver.findElement(By.xpath("//label/input[@value='user']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']")));

		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
		driver.findElement(By.xpath("//select[@class='form-control']")).click();
		driver.findElement(By.xpath("//option[@value='stud']")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.id("signInBtn")).click();

		wait.until(ExpectedConditions.titleContains("ProtoCommerce"));
	}

	public static void selectItemsAndCheckout(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		List<WebElement> items = driver.findElements(By.xpath("//button[@class='btn btn-info']"));

		for (WebElement button : items) {

			button.click();
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='nav-link btn btn-primary']")));
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();

	}

}
