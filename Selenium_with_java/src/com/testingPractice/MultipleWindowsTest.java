package com.testingPractice;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultipleWindowsTest {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/leonardoramirez/Desktop/selenium/geckodriver");
		WebDriver firefox = new FirefoxDriver();

		firefox.get("https://rahulshettyacademy.com/angularpractice/");
		firefox.switchTo().newWindow(WindowType.WINDOW);
		
		Set<String> handles = firefox.getWindowHandles();
		Iterator<String> it = handles.iterator();
		
		String parentWindow = it.next();
		String childWindonw = it.next();
		
		firefox.switchTo().window(childWindonw);
		firefox.get("https://courses.rahulshettyacademy.com/courses");
		
		String courseName = firefox.findElements(By.cssSelector("a[href*='/p/']")).get(1).getText();
		
		firefox.switchTo().window(parentWindow);
		
		WebElement name =  firefox.findElement(By.xpath("//div/input[@name='name']"));
		name.sendKeys(courseName);
		//Screenshot of an element
		File file = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("log.png"));
		
		//get height and width of element 
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		
		Thread.sleep(3000);
		firefox.quit();
	}

}
