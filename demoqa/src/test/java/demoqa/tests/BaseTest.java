package demoqa.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import demoqa.commonutils.CommonUtils;
import demoqa.pageobject.BasePage;
import demoqa.pageobject.CheckBoxPage;
import demoqa.pageobject.LinksPage;
import demoqa.pageobject.WebTablesPage;

public class BaseTest {
	protected WebDriver driver;
	private CommonUtils commonUtils;
	protected CheckBoxPage checkBoxPage;
	protected BasePage basePage;
	protected WebTablesPage webTablesPage;
	protected LinksPage linksPage;

	@BeforeMethod
	public void setUp() throws IOException {
		driver = commonUtils.createDriver(basePage.loadProperties());
		basePage = new BasePage(driver);
		checkBoxPage = new CheckBoxPage(driver);
		webTablesPage = new WebTablesPage(driver);
		linksPage = new LinksPage(driver);
		commonUtils.browserSetup(driver);
	}

	@AfterMethod
	public void tearDown() {
		basePage.closeBrowser();
	}

}
