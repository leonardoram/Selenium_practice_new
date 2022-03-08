package com.testingPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Dropdowns {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "/Users/leonardoramirez/Desktop/selenium/geckodriver");

		String url = "https://rahulshettyacademy.com/dropdownsPractise/";
		WebDriver firefox = new FirefoxDriver();

		firefox.get(url);

		WebElement staticDrop = firefox.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		// clase para elementos tipo "select" como dropddowns estaticos
		Select dropdown = new Select(staticDrop);
		dropdown.selectByIndex(2);

		System.out.println(dropdown.getFirstSelectedOption().getText());

		dropdown.selectByVisibleText("USD");

		System.out.println(dropdown.getFirstSelectedOption().getText());

		firefox.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		// int i =0;
		// while(i < 3){
		// firefox.findElement(By.id("hrefIncAdt")).click();
		// i++;
		// };
		for (int i = 0; i < 3; i++) {
			firefox.findElement(By.id("hrefIncAdt")).click();
		}
		;

		firefox.findElement(By.id("btnclosepaxoption")).click();

		Assert.assertEquals(firefox.findElement(By.id("divpaxinfo")).getText(), "4 Adult");
		System.out.println(firefox.findElement(By.id("divpaxinfo")).getText());

		firefox.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		firefox.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		firefox.findElement(
				By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

		firefox.findElement(By.id("autosuggest")).sendKeys("ind");

		Thread.sleep(3000);

		List<WebElement> options = firefox.findElements(By.cssSelector("ul li[class='ui-menu-item'] a"));
		System.out.println(options.size());

		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("india")) {
				option.click();
				break;
			}
			;
		}
		;

		Thread.sleep(3000);

		firefox.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		System.out.println(firefox.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());

		// System.out.println(firefox.findElements(By.xpath("//input[@type='checkbox']")).size());
		System.out.println(
				firefox.findElement(By.id("ctl00_mainContent_view_date2")).getAttribute("style").contains("1"));

		Thread.sleep(3000);

		firefox.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

		Thread.sleep(3000);
		firefox.quit();
	}

}