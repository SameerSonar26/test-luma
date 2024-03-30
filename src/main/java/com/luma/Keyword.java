package com.luma;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.luma.exception.InvalidBrowserNameError;


import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

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
		wait.withTimeout(Duration.ofSeconds(30));
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

	public void waitForElementToBeVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public String localDateAndTime() {
		Calendar cal = Calendar.getInstance();
		Date time= cal.getTime();
		String currentTime = time.toString().replace(":", "").replace(" ", "_");
		return currentTime;
	}

	public void screenShot() throws IOException {

		// make object of Ashot
		AShot a1 = new AShot();
		// now define Strategy
		a1.shootingStrategy(ShootingStrategies.viewportPasting(2000));
		// which driver
		Screenshot sc = a1.takeScreenshot(driver);
		// image format
		BufferedImage img = sc.getImage();
		// path to save

		String path = ("D:\\01 Sameer\\01 Java\\01 Project\\ssWorkspace\\Z85_LUMA\\01_ScreenShoot\\"
				+ localDateAndTime() + ".jpg");
		LOG.info(path);
		ImageIO.write(img, "jpg", new File(path));
		// driver.close();
	}
}
