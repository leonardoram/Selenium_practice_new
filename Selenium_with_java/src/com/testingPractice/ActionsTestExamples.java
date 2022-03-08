package com.testingPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsTestExamples {

	public static void main(String[] args) throws InterruptedException {

		//class to use the class actions and perform different actions in the browser 
		System.setProperty("webdriver.gecko.driver", "/Users/leonardoramirez/Desktop/selenium/geckodriver");

		WebDriver firefox = new FirefoxDriver();
		String buscar = "hola";

		firefox.get("https://www.amazon.com.mx");

		Actions act = new Actions(firefox);

		WebElement move = firefox.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		WebElement searchbox = firefox.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		

		act.moveToElement(move).build().perform();
		act.moveToElement(searchbox).click()
				.keyDown(Keys.SHIFT).sendKeys(buscar).build().perform();

		act.moveToElement(move).contextClick().build().perform();
		
		
		Thread.sleep(4000);
		firefox.quit();

	}

}
