package vesit.ajayk57.dscc.stqa_practical5;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
	private WebDriver driver;
	private final String USER_DATA_PATH_STR = "users.xlsx";
	private final int SHEET_NUMBER = 0;
	private ReadExcelFile readExcelFile;

	@BeforeTest
	public void setupTest() throws IOException {
		driver = new ChromeDriver();
		readExcelFile = new ReadExcelFile(USER_DATA_PATH_STR, SHEET_NUMBER);
	}

	@Test(dataProvider = "testdata")
	public void simpleLogin(String username, String password) throws InterruptedException {
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Assert.assertTrue(driver.getCurrentUrl().matches("https://www.saucedemo.com/inventory.html"),
				"Invalid credentials");
	}

	@AfterTest
	void ProgramTermination() {
		driver.quit();
	}

	@DataProvider(name = "testdata")
	public Object[][] testDataExample() throws IOException {
		final int numRows = readExcelFile.getRowCount();
		Object[][] loginCredentials = new Object[numRows][2];
		for (int i = 0; i < numRows; i++) {
			loginCredentials[i][0] = readExcelFile.getData(i, 0);
			loginCredentials[i][1] = readExcelFile.getData(i, 1);
		}
		return loginCredentials;
	}
}