package com.luma;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.luma.exception.InvalidBrowserNameError;

public class Keyword {
	public static RemoteWebDriver driver;
	public static FluentWait wait;
	private static final Logger LOG = Logger.getLogger(Keyword.class);

	public void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			LOG.info("Launching Chrome Driver");
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			LOG.info("Launching FireFox Driver");
		} else {
			throw new InvalidBrowserNameError(browserName);
		}
		wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(10));
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withMessage("WebElements do not appear within the time limit.");
		wait.ignoring(NoSuchElementException.class);
	}

	public void tearDown() {
		driver.quit();
	}

	public void close() {
		driver.close();
	}

	public void getAppUrl(String text) {
		driver.get(text);
	}
}
