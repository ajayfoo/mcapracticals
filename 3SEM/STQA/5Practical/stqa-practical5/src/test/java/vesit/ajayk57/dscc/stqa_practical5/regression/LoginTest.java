package vesit.ajayk57.dscc.stqa_practical5.regression;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	@Test(priority = 1)
	public void testLoginWithValidCredentials() {
		login("standard_user", "secret_sauce");
		Assert.assertTrue(isLoggedIn(), "Login with valid credentials failed.");
	}

	@Test(priority = 2)
	public void testLoginWithInvalidCredentials() {
		login("locked_out_user", "secret_sauce");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Assert.assertTrue(isErrorMessageDisplayed(), "Error message not displayed for invalid login.");
	}

	private void login(String username, String password) {
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
	}

	private boolean isLoggedIn() {
		WebElement cartIcon = driver.findElement(By.id("shopping_cart_container"));
		return cartIcon.isDisplayed();
	}

	private boolean isErrorMessageDisplayed() {
		WebElement errorElement = driver.findElement(By.cssSelector("[data-test='error']"));
		return errorElement.isDisplayed();
	}
}
