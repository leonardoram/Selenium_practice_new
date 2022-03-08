package com.testingPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FramesAssignment {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "/Users/leonardoramirez/Desktop/selenium/geckodriver");
		WebDriver firefox = new FirefoxDriver();
		
		firefox.get("https://the-internet.herokuapp.com/nested_frames");
		
		firefox.switchTo().frame("frame-top");

		firefox.switchTo().frame("frame-middle");
		
		System.out.println(firefox.findElement(By.id("content")).getText());
		
		Thread.sleep(3000);
		firefox.quit();

	}

}
