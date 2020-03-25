package com.cts.Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class LaunchWebDriver {

	public WebDriver driver;

	//opening the URL in Browser
	public static void setup(WebDriver driver) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.jainbookagency.com/india-largest-online-book-store.aspx");
	}

	public void tearDown() throws InterruptedException {

		driver.quit();
	}

}
