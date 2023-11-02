package vesit.ajayk57.dscc.stqa_practical5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ValidationTest {
	private WebDriver driver;
	private final String websiteURL = "https://agilemanifesto.org/";

	@BeforeTest
	public void setupTest() {
		driver = new ChromeDriver();
		driver.get(websiteURL);
	}

	@Test
	public void testPageTitle() {
		final String expectedTitle = "Manifesto for Agile Software Development";
		final String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Page title doesn't match the expected title.");
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
