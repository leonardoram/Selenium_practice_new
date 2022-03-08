package com.testingPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ExcerciseInfo {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/leonardoramirez/Desktop/selenium/geckodriver");
		WebDriver firefox = new FirefoxDriver();
		
		firefox.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		String option = firefox.findElement(By.cssSelector("label[for='bmw']")).getText();
		System.out.println(option);
		firefox.findElement(By.id("checkBoxOption1")).click();
		
		Select dropdown = new Select(firefox.findElement(By.id("dropdown-class-example")));
		
		firefox.findElement(By.id("dropdown-class-example")).click();
		dropdown.selectByVisibleText(option);
		
		firefox.findElement(By.xpath("//input[@id='name']")).sendKeys(option);
		firefox.findElement(By.id("alertbtn")).click();
		
		String alertMessage = firefox.switchTo().alert().getText();
		
		String [] newalertmess = alertMessage.split(" ");
		String [] optionalert = newalertmess[1].split(",");
		
		firefox.switchTo().alert().accept();
		
		System.out.println("alert showed : "+optionalert[0]);
		
		Assert.assertEquals(optionalert[0], "Option1");
		
		Thread.sleep(3000);
		firefox.quit();
	}

}
