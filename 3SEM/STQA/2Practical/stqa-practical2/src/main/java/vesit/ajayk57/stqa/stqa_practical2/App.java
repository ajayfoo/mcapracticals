package vesit.ajayk57.stqa.stqa_practical2;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
	final private static Scanner sc = new Scanner(System.in);

	private static void waitForEnterKey(String demoName) {
		while (true) {
			System.out.println("Press enter after taking screenshots of " + demoName + " demo.");
			String entered = sc.nextLine();
			if (entered.equals("")) {
				break;
			}
		}
	}

	private static void runHelloSeleniumDemo() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		String title = driver.getTitle();
		System.out.printf("Title of the page: %s%n", title);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement textBox = driver.findElement(By.name("my-text"));
		WebElement submitButton = driver.findElement(By.cssSelector("button"));
		waitForEnterKey("get()");
		textBox.sendKeys("Selenium");
		submitButton.click();
		WebElement message = driver.findElement(By.id("message"));
		String value = message.getText();
		String expectedValue = "Received!";
		System.out.printf("%s == %s = %b%n", expectedValue, value, expectedValue.equals(value));
		waitForEnterKey("getText()");
		driver.close();
	}

	public static void main(String[] args) {
		runHelloSeleniumDemo();
		sc.close();
	}
}
