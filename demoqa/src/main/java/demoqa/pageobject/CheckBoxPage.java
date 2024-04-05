package demoqa.pageobject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import demoqa.commonutils.CommonUtils;

public class CheckBoxPage extends BasePage {
	//private final WebDriver driver;
	private CommonUtils commonUtils;

	//	public static String loadProperties() throws IOException {
	//		Properties properties = new Properties();
	//		FileInputStream file = new FileInputStream("src/main/resources/config.properties");
	//		properties.load(file);
	//		String browser = properties.getProperty("browser");
	//		return browser;
	//
	//	}

	public CheckBoxPage(WebDriver driver) {

		super(driver);

		PageFactory.initElements(driver, this);

	}

	//	public void closeBrowser() {
	//		try {
	//			driver.quit();
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//
	//	}

	@FindBy(how = How.XPATH, using = "//div[@class='element-list collapse show']//li[@id='item-1']")
	private WebElement checkBoxBtn;

	@FindBy(how = How.XPATH, using = "(//button[@type='button' and @class='rct-collapse rct-collapse-btn'])[1]")
	private WebElement homeBtn;

	@FindBy(how = How.XPATH, using = "(//button[@type='button' and @class='rct-collapse rct-collapse-btn'])[2]")
	private WebElement desktopBtn;

	@FindBy(how = How.XPATH, using = "(//button[@type='button' and @class='rct-collapse rct-collapse-btn'])[3]")
	private WebElement documentsBtn;

	@FindBy(how = How.XPATH, using = "(//button[@type='button' and @class='rct-collapse rct-collapse-btn'])[4]")
	private WebElement workspaceBtn;

	@FindBy(how = How.XPATH, using = "(//button[@type='button' and @class='rct-collapse rct-collapse-btn'])[5]")
	private WebElement officeBtn;

	@FindBy(how = How.XPATH, using = "(//button[@type='button' and @class='rct-collapse rct-collapse-btn'])[6]")
	private WebElement downloadsBtn;

	@FindBy(how = How.XPATH, using = "//div[@id='result']")
	private WebElement message;

	List<String> checkboxNames = new ArrayList<>();

	public void addCheckboxName() {
		checkboxNames.add("Commands");
		checkboxNames.add("Angular");
	}

	public void selectCheckboxes() throws InterruptedException {
		for (String name : checkboxNames) {

			String xpath = String.format(
					"//span[contains(@class, 'rct-checkbox') and following-sibling::span[contains(@class, 'rct-title') and text()='%s']]",
					name);
			WebElement clickCheckBox = driver.findElement(By.xpath(xpath));
			clickCheckBox.click();
			Thread.sleep(4000); // Adjust the sleep time as necessary
			commonUtils.scrollDown(driver);
		}
	}

	public void checkBox() throws InterruptedException {

		commonUtils.waitForElement(driver, checkBoxBtn, 2);
		checkBoxBtn.click();
		commonUtils.scrollDown(driver);
		Thread.sleep(2000);
		commonUtils.waitForElement(driver, homeBtn, 2);
		homeBtn.click();
		Thread.sleep(1000);
		commonUtils.waitForElement(driver, desktopBtn, 2);
		desktopBtn.click();
		Thread.sleep(1000);
		commonUtils.waitForElement(driver, documentsBtn, 2);
		documentsBtn.click();
		Thread.sleep(1000);
		commonUtils.scrollDown(driver);
		commonUtils.waitForElement(driver, workspaceBtn, 2);
		workspaceBtn.click();
		Thread.sleep(1000);
		commonUtils.scrollDown(driver);
		commonUtils.waitForElement(driver, officeBtn, 2);
		officeBtn.click();
		Thread.sleep(1000);
		commonUtils.waitForElement(driver, downloadsBtn, 2);
		downloadsBtn.click();
		Thread.sleep(1000);
		commonUtils.scrollUp(driver);
		Thread.sleep(1000);
		addCheckboxName();
		selectCheckboxes();
		commonUtils.scrollDown(driver);
		System.out.println(message.getText());
	}
}
