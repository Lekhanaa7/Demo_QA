package demoqa.commonutils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonUtils {
	private final WebDriver driver;

	public CommonUtils(WebDriver driver) {
		this.driver = driver;
	}

	public static void waitForElement(WebDriver driver, WebElement webElement, int timeUnit_sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeUnit_sec));
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}

	public static void waitForElementToBeClickable(WebDriver driver, WebElement webElement, int timeUnit_sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeUnit_sec));
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
	}

	public static WebDriver createDriver(String browser) {
		WebDriver driver = null;
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid browser specified. Defaulting to Chrome.");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		return driver;
	}

	public static void scrollDown(WebDriver driver, int pixels) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, arguments[0]);", pixels);
		Thread.sleep(1000);
	}

	public static void scrollUp(WebDriver driver, int pixels) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, arguments[0]);", pixels);
		Thread.sleep(1000);
	}

	public static void browserSetup(WebDriver driver) {

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.get("https://demoqa.com/elements");
	}

}
