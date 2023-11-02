package vesit.ajayk57.dscc.stqa_practical5.regression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	final protected String WEBSITE_URL = "https://www.saucedemo.com/";
	protected WebDriver driver;

	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
	}

	@AfterTest
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
