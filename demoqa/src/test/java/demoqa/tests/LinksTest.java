package demoqa.tests;

import org.testng.annotations.Test;

public class LinksTest extends BaseTest {
	@Test(priority = 1)
	public void testLinks() throws InterruptedException {
		linksPage.newHomeWindow();

	}

	@Test(priority = 2)
	public void testAPILinks() throws InterruptedException {
		linksPage.clickAllLinks();
	}
}
