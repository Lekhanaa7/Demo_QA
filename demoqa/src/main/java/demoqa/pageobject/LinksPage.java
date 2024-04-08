package demoqa.pageobject;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

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

	@FindBy(how = How.XPATH, using = "//a[@id='dynamicLink']")
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

	public void newHomeWindow() throws InterruptedException {
		commonUtils.scrollDown(driver, 300);
		commonUtils.waitForElement(driver, linksBtn, 2);
		linksBtn.click();
		Thread.sleep(500);
		commonUtils.scrollDown(driver, 300);
		Thread.sleep(2000);

		CommonUtils.waitForElementToBeClickable(driver, homeBtn, 10);
		homeBtn.click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		if (currentUrl.equals("https://demoqa.com/")) {
			System.out.println("New Window opened");
		} else {
			System.out.println("New Window didn't opened");
		}

		driver.quit();

	}

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
			Thread.sleep(5000);
			System.out.println(linkResponseMsg.getText());
		}
	}
}
