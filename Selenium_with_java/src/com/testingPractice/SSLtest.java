package com.testingPractice;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SSLtest {

	public static void main(String[] args) throws Exception{

		System.setProperty("webdriver.gecko.driver", "/Users/leonardoramirez/Desktop/selenium/geckodriver");
		
		FirefoxOptions opt= new FirefoxOptions();
		opt.setAcceptInsecureCerts(true);
		opt.addPreference("profile.default_content_settings.popups", 0);
		
		WebDriver firefox = new FirefoxDriver(opt);
		
		firefox.manage().window().maximize();

		firefox.get("https://expired.badssl.com/");

		File src = ((TakesScreenshot) firefox).getScreenshotAs(OutputType.FILE);
				
		FileUtils.copyFile(src, new File("/Users/leonardoramirez/Desktop/selenium/SS/test.png"));
		
		System.out.println(firefox.getTitle());
		
		firefox.manage().deleteAllCookies();
		
		Thread.sleep(3000);
		firefox.quit();
		
	}

}
