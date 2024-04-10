package demoqa.tests;

import org.testng.annotations.Test;

import demoqa.pageobject.LinksPage;

public class LinksTest extends BaseTest {

	@Test(priority = 1)
	public void testLinks() throws InterruptedException {
		linksPage.newHomeWindow();

	}

	@Test(priority = 2, retryAnalyzer = LinksPage.LinksPageRetryAnalyzer.class)
	public void testAPILinks() throws InterruptedException {
		linksPage.clickAllLinks();

	}

	@Test(priority = 3)
	public void testHomeLinks() throws InterruptedException {
		linksPage.newHomeWindow();

	}

}
