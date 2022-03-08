package com.testingPractice;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowsHandlersTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "/Users/leonardoramirez/Desktop/selenium/geckodriver");

		WebDriver firefox = new FirefoxDriver();
		firefox.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		firefox.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		firefox.findElement(By.cssSelector(".blinkingText")).click();
		
		Set<String> windows = firefox.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent = it.next();
		String child = it.next();
		
		firefox.switchTo().window(child);
		
		String mail = firefox.findElement(By.cssSelector(".im-para.red")).getText().split(" at ")[1].trim().split(" ")[0];
	
		firefox.switchTo().window(parent);
		
		firefox.findElement(By.id("username")).sendKeys(mail);
		
		Thread.sleep(3000);
		firefox.quit();

	}

}
