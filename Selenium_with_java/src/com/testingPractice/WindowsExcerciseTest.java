package com.testingPractice;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowsExcerciseTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "/Users/leonardoramirez/Desktop/selenium/geckodriver");

		WebDriver firefox = new FirefoxDriver();
		firefox.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		firefox.get("https://the-internet.herokuapp.com/windows");

		String parentWindowText = firefox.findElement(By.tagName("h3")).getText();
		firefox.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();

		// get all handles of windows and iterate
		Set<String> windows = firefox.getWindowHandles();
		Iterator<String> ite = windows.iterator();

		String parent = ite.next();
		String child = ite.next();

		firefox.switchTo().window(child);

		String childWindonwText = firefox.findElement(By.className("example")).getText();

		firefox.switchTo().window(parent);

		System.out.println(childWindonwText);
		System.out.println(parentWindowText);

		Thread.sleep(3000);
		firefox.quit();

	}

}
