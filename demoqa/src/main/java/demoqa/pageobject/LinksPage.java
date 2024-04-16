package demoqa.pageobject;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import demoqa.commonutils.CommonUtils;

public class LinksPage extends BasePage {
	private CommonUtils commonUtils;

	public LinksPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//div[@class='element-list collapse show']//li[@id='item-5']")
	private WebElement linksBtn;

	@FindBy(how = How.XPATH, using = "//a[@href='https://demoqa.com']")
	private WebElement homeBtn;

	@FindBy(how = How.XPATH, using = "//a[@id='dynamicLink' and @target='_blank']")
	private WebElement homeDynamicBtn;

	@FindBy(how = How.XPATH, using = "//a[@id='created']")
	private WebElement createdBtn;

	@FindBy(how = How.XPATH, using = "//a[@id='no-content']")
	private WebElement noContentBtn;

	@FindBy(how = How.XPATH, using = "//a[@id='moved']")
	private WebElement movedBtn;

	@FindBy(how = How.XPATH, using = "//a[@id='bad-request']")
	private WebElement badRequestBtn;

	@FindBy(how = How.XPATH, using = "//a[@id='unauthorized']")
	private WebElement unauthorizedtBtn;

	@FindBy(how = How.XPATH, using = "//a[@id='forbidden']")
	private WebElement forbiddenBtn;

	@FindBy(how = How.XPATH, using = "//a[@id='invalid-url']")
	private WebElement notFoundBtn;

	@FindBy(how = How.XPATH, using = "//p[@id='linkResponse']")
	private WebElement linkResponseMsg;

	@FindBy(how = How.XPATH, using = "(//button[@type='button' and @class='rct-collapse rct-collapse-btn'])[4]")
	private WebElement workspaceBtn;

	public void newHomeWindow() throws InterruptedException {
		commonUtils.scrollDown(driver, 300);
		commonUtils.waitForElement(driver, linksBtn, 2);
		linksBtn.click();
		Thread.sleep(500);
		//commonUtils.scrollDown(driver, 300);
		//Thread.sleep(2000);

		String originalWindowHandle = driver.getCurrentUrl();
		System.out.println(originalWindowHandle);
		//commonUtils.scrollDown(driver, 300);
		//Thread.sleep(500);
		WebElement newWindowBtn = driver.findElement(By.xpath("//a[@href='https://demoqa.com']"));
		CommonUtils.waitForElementToBeClickable(driver, newWindowBtn, 10);
		newWindowBtn.click();

		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(originalWindowHandle)) {
				driver.switchTo().window(windowHandle);

				break;
			}
		}
		Thread.sleep(2000);
		String newWindowTitle = driver.getCurrentUrl();
		System.out.println(newWindowTitle);
		if (newWindowTitle.equals("https://demoqa.com/")) {
			System.out.println("Successfully switched to the new window.");
		} else {
			System.out.println("Failed to switch to the new window.");
		}

		driver.quit();

	}

	//	public void clickAllLinks() throws InterruptedException {
	//		boolean succRun = false;
	//		int count = 2;
	//		try {
	//			commonUtils.scrollDown(driver, 300);
	//			commonUtils.waitForElement(driver, linksBtn, 2);
	//			linksBtn.click();
	//			Thread.sleep(500);
	//			//commonUtils.scrollDown(driver, 560);
	//			Thread.sleep(2000);
	//			List<WebElement> links = Arrays.asList(createdBtn, noContentBtn, movedBtn, badRequestBtn, unauthorizedtBtn,
	//					forbiddenBtn, notFoundBtn);
	//
	//			for (WebElement link : links) {
	//				link.click();
	//				Thread.sleep(5000);
	//				succRun = true;
	//				System.out.println(linkResponseMsg.getText());
	//			}
	//		} catch (Exception e) {
	//			if (!succRun) {
	//				System.out.println("Exception found.");
	//				System.out.println("The exception is: ");
	//				e.printStackTrace();
	//				while (count != 0) {
	//					clickAllLinks();
	//					count--;
	//				}
	//				count = 2;
	//				System.out.println("Exception found, so executed " + count + " number of times.");
	//			}
	//		}
	//	}
	//}
	public void clickAllLinks() throws InterruptedException {
		commonUtils.scrollDown(driver, 300);
		commonUtils.waitForElement(driver, linksBtn, 2);
		linksBtn.click();
		Thread.sleep(500);
		commonUtils.scrollDown(driver, 560);
		Thread.sleep(2000);
		List<WebElement> links = Arrays.asList(createdBtn, noContentBtn, movedBtn, badRequestBtn, unauthorizedtBtn,
				forbiddenBtn, notFoundBtn);

		for (WebElement link : links) {
			link.click();
			Thread.sleep(1000);
			System.out.println(linkResponseMsg.getText());
		}
		//		commonUtils.waitForElement(driver, workspaceBtn, 2);
		//		workspaceBtn.click();
	}

	public static class LinksPageRetryAnalyzer implements IRetryAnalyzer {
		private int retryCount = 0;
		private static final int maxRetryCount = 2;

		@Override
		public boolean retry(ITestResult result) {
			if (!result.isSuccess() && retryCount < maxRetryCount) {
				retryCount++;
				return true;
			}
			return false;
		}
	}

}
