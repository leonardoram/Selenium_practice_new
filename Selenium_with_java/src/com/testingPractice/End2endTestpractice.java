
package com.testingPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class End2endTestpractice {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "/Users/leonardoramirez/Desktop/selenium/geckodriver");

		String url = "https://rahulshettyacademy.com/dropdownsPractise/";
		WebDriver firefox = new FirefoxDriver();

		firefox.get(url);

		firefox.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		firefox.findElement(By.xpath("//a[@value='DEL']")).click();
		Thread.sleep(2000);

		firefox.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();

		firefox.findElement(By.cssSelector(".ui-datepicker-days-cell-over.ui-datepicker-today")).click();

		if (firefox.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("its enabled ");
			Assert.assertTrue(true);
		} else {
			System.out.println("its disabled");
			Assert.assertTrue(false);
		}
		;

		firefox.findElement(By.id("divpaxinfo")).click();
		for (int i = 1; i < 4; i++) {

			firefox.findElement(By.id("hrefIncAdt")).click();

		}
		;
		Assert.assertEquals(firefox.findElement(By.id("divpaxinfo")).getText(), "4 Adult");
		System.out.println(firefox.findElement(By.id("divpaxinfo")).getText());

		firefox.findElement(By.id("btnclosepaxoption")).click();

		firefox.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();

		Thread.sleep(5000);
		firefox.quit();

	}

}
