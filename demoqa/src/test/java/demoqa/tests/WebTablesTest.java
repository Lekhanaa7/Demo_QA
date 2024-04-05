package demoqa.tests;

import org.testng.annotations.Test;

public class WebTablesTest extends BaseTest {
	@Test
	public void testWebTable() throws InterruptedException {
		webTablesPage.addDetails();

	}
}
