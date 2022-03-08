package com.testingPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestingPractice {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "/Users/leonardoramirez/Desktop/selenium/geckodriver");
		//invocar al demonio, digo al explorador jejeje 
		
		String url = "https://google.com";
		WebDriver firefox = new FirefoxDriver();
		
		firefox.get(url);
		
		String titulo = firefox.getTitle();
		System.out.println(titulo);
		
		firefox.findElement(By.xpath("//input[@type='text']")).sendKeys("leoxenon");
		firefox.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//center//input[@value='Buscar con Google']")).click();
		
		
		
		firefox.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		firefox.quit();
	}
}
