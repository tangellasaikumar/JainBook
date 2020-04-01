package com.cts.base;

import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchWebBrowser {
	public static WebDriver driver;
	
	public static void LaunchWebDriver(String browsername)
	{
		if(browsername.equalsIgnoreCase("ff"))
		{
			System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver.exe");
			driver = new FirefoxDriver();	
		}
		else if(browsername.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "src/test/resources/driver/IEDriverServer.exe");
			driver = new ChromeDriver();
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.jainbookagency.com/india-largest-online-book-store.aspx");
	}

	public static void exit() {
		Date date = new Date();
		String datestr = date.toString().replace(":", "-");

		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshot = ts.getScreenshotAs(OutputType.FILE);
		screenshot.renameTo(new File("src/test/resources/screenshots/image" + datestr + ".png"));

		driver.quit();
	}

	
	
}
