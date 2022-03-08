package com.testingPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "/Users/leonardoramirez/Desktop/selenium/geckodriver");
		WebDriver firefox = new FirefoxDriver();
		
		firefox.get("https://jqueryui.com/droppable/");
		
		firefox.switchTo().frame(firefox.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		
		Actions act = new Actions(firefox);
		
		act.dragAndDrop(firefox.findElement(By.id("draggable")), firefox.findElement(By.id("droppable"))).build().perform();
		
		firefox.switchTo().defaultContent();
		
		firefox.findElement(By.xpath("//a[contains(text(),'Accept')]")).click();
		
		Thread.sleep(3000);
		firefox.quit();

	}

}
