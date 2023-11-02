package vesit.ajayk57.dscc.stqa_practical5;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest {
	@Test
	public void f() {
		System.out.println("f()");
		assert(true);
	}
	@Test
	public void eightComponents() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");

		String title = driver.getTitle();
		assertEquals("Web form", title);

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

		WebElement textBox = driver.findElement(By.name("my-text"));
		WebElement submitButton = driver.findElement(By.cssSelector("button"));

		textBox.sendKeys("Selenium");
		submitButton.click();

		WebElement message = driver.findElement(By.id("message"));
		String value = message.getText();
		assertEquals("Received!", value);

		driver.quit();
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Runs before the test methods");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Runs after the test methods");
	}

}
