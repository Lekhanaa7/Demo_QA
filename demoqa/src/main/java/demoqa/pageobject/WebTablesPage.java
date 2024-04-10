package demoqa.pageobject;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import demoqa.commonutils.CommonUtils;

public class WebTablesPage extends BasePage {

	private CommonUtils commonUtils;

	public WebTablesPage(WebDriver driver) {

		super(driver);

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

	@FindBy(how = How.XPATH, using = "//div[@class='rt-td']")
	private WebElement searchText;

	public void addDetails() throws InterruptedException {
		commonUtils.scrollDown(driver, 300);
		commonUtils.waitForElement(driver, webTableBtn, 2);
		webTableBtn.click();

		commonUtils.waitForElement(driver, addBtn, 2);
		addBtn.click();
		commonUtils.waitForElement(driver, firstName, 2);
		firstName.sendKeys("Lekhana");
		String lastNameText = RandomStringUtils.randomAlphabetic(4);
		commonUtils.waitForElement(driver, lastName, 2);
		lastName.sendKeys(lastNameText);
		commonUtils.waitForElement(driver, userEmail, 2);
		userEmail.sendKeys(lastNameText + "@email.com");
		commonUtils.waitForElement(driver, ageInput, 2);
		ageInput.sendKeys("30");
		Thread.sleep(1000);
		Random random = new Random();
		int salaryValue = 10000 + random.nextInt(90000);
		commonUtils.waitForElement(driver, salary, 2);
		salary.sendKeys(Integer.toString(salaryValue));
		commonUtils.waitForElement(driver, department, 2);
		department.sendKeys("railways");
		Thread.sleep(2000);
		commonUtils.scrollDown(driver, 300);
		commonUtils.waitForElementToBeClickable(driver, submitBtn, 2);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitBtn);
		Thread.sleep(2000);
		commonUtils.waitForElement(driver, searchBtn, 2);
		searchBtn.click();
		searchBtn.sendKeys("Lekhana");
		Thread.sleep(1000);
		commonUtils.waitForElement(driver, searchText, 2);
		String searchtext = searchText.getText();
		if (searchtext.equals("Lekhana")) {
			System.out.println("Details exist");
		} else {
			System.out.println("No such details exist");
		}
	}
}
