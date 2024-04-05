package demoqa.tests;

import org.testng.annotations.Test;

public class CheckBoxTest extends BaseTest {
	@Test
	public void testCheckBox() throws InterruptedException {
		checkBoxPage.checkBox();
	}
}
