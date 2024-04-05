package demoqa.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import demoqa.commonutils.CommonUtils;

public class WebTablesPage {
	private final WebDriver driver;
	private CommonUtils commonUtils;

	public WebTablesPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//div[@class='element-list collapse show']//li[@id='item-3']")
	private WebElement webTableBtn;

	@FindBy(how = How.XPATH, using = "//button[@id='addNewRecordButton' and @class='btn btn-primary']")
	private WebElement addBtn;

	@FindBy(how = How.XPATH, using = "//input[@id='searchBox' and @class='form-control']")
	private WebElement searchBtn;

	@FindBy(how = How.XPATH, using = "//input[@id='firstName']")
	private WebElement firstName;

	@FindBy(how = How.XPATH, using = "//input[@id='lastName']")
	private WebElement lastName;

	@FindBy(how = How.XPATH, using = "//input[@id='userEmail']")
	private WebElement userEmail;

	@FindBy(how = How.XPATH, using = "//input[@id='age']")
	private WebElement ageInput;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Salary']")
	private WebElement salary;

	@FindBy(how = How.XPATH, using = "//input[@id='department']")
	private WebElement department;

	@FindBy(how = How.XPATH, using = "//button[@id='submit' and @class='btn btn-primary']")
	private WebElement submitBtn;

	public void addDetails() throws InterruptedException {
		commonUtils.scrollDown(driver);
		commonUtils.waitForElement(driver, webTableBtn, 2);
		webTableBtn.click();

		commonUtils.waitForElement(driver, addBtn, 2);
		addBtn.click();
		commonUtils.waitForElement(driver, firstName, 2);
		firstName.sendKeys("kesh");
		commonUtils.waitForElement(driver, lastName, 2);
		lastName.sendKeys("anj");
		commonUtils.waitForElement(driver, userEmail, 2);
		userEmail.sendKeys("123@email.com");
		commonUtils.waitForElement(driver, ageInput, 2);
		ageInput.sendKeys("30");
		Thread.sleep(1000);
		commonUtils.waitForElement(driver, salary, 2);
		salary.sendKeys("30000");
		commonUtils.waitForElement(driver, department, 2);
		department.sendKeys("health");
		Thread.sleep(2000);
		commonUtils.scrollDown(driver);
		commonUtils.waitForElementToBeClickable(driver, submitBtn, 2);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitBtn);
		Thread.sleep(2000);
		commonUtils.waitForElement(driver, searchBtn, 2);
		searchBtn.click();
		searchBtn.sendKeys("anj");
		Thread.sleep(1000);

	}
}
