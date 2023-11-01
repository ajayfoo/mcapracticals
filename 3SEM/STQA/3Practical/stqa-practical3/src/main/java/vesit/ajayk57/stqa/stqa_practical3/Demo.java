package vesit.ajayk57.stqa.stqa_practical3;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Scanner;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo {
	private final WebDriver webDriver;
	private final Scanner scanner = new Scanner(System.in);

	Demo(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public void runNavCommands() {
		System.out.println("Running Navigation Commands demo...");
		webDriver.get("https://www.linuxmint.com");
		webDriver.get("https://www.archlinux.org");
		webDriver.navigate().forward();
		webDriver.navigate().back();
		webDriver.navigate().refresh();
		waitForEnterKey("Navigation Commands");
	}

	public void runSomeBrowserCommands() {
		System.out.println("Running Browser Commands demo...");
		webDriver.get("https://www.selenium.dev/selenium/web/web-form.html");
		webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

		System.out.println("Title of Webpage = " + webDriver.getTitle());
		System.out.println("Current URL = " + webDriver.getCurrentUrl());

		WebElement textBox = webDriver.findElement(By.name("my-text"));
		WebElement submitButton = webDriver.findElement(By.cssSelector("button"));
		textBox.sendKeys("Selenium");
		submitButton.click();

		WebElement message = webDriver.findElement(By.id("message"));
		System.out.println("Text of element with id 'message' = " + message.getText());
		waitForEnterKey("Browser Commands");
	}

	public void runLocatorDemo() {
		System.out.println("Running Locator demo...");
		final String htmlDocumentName = "index.html";
		Path htmlDocPath = Paths.get(htmlDocumentName);
		webDriver.get(htmlDocPath.toUri().toString());
		webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement lname = webDriver.findElement(By.id("lname"));
		WebElement fnameId = webDriver.findElement(By.cssSelector("#newsletter"));
		WebElement inputF = webDriver.findElement(By.xpath("//input[@value='f']"));
		System.out.println("Tag name of element with id 'lname' = " + lname.getTagName());
		System.out.println("Newsletter is checked(css selector) = " + fnameId.isSelected());
		System.out.println("Value of property 'value' (xpath) = " + inputF.getDomProperty("value"));
		waitForEnterKey("Locator");
	}

	public void runSynchronizationDemo() {
		System.out.println("Running Synchronization demo...");
		runThreadWaitDemo();
		runImplicitWaitDemo();
		runExplicitSyncDemo();
		runExplicitSyncWithOptionsDemo();
		waitForEnterKey("Synchronization");
	}

	private void runThreadWaitDemo() {
		webDriver.get("https://www.google.com");
		System.out.println("Waiting for 2 seconds(via Thread.sleep())");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void runImplicitWaitDemo() {
		final String htmlDocumentName = "index.html";
		Path htmlDocPath = Paths.get(htmlDocumentName);
		System.out.println("Waiting for 3 seconds(implicit wait)");
		webDriver.get(htmlDocPath.toUri().toString());
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		System.out.println("Current URL = " + webDriver.getCurrentUrl());
	}

	private void runExplicitSyncDemo() {
		webDriver.get("https://www.selenium.dev/selenium/web/dynamic.html");
		final WebElement revealed = webDriver.findElement(By.id("revealed"));
		Wait<WebDriver> wait = new WebDriverWait(webDriver, Duration.ofSeconds(2));
		webDriver.findElement(By.id("reveal")).click();
		wait.until(new Function<WebDriver, Object>() {
			@Override
			public Object apply(WebDriver d) {
				return revealed.isDisplayed();
			}
		});
		revealed.sendKeys("Displayed");
		System.out.println("[ExplicitSync]Value of property 'value' = " + revealed.getDomProperty("value"));

	}

	private void runExplicitSyncWithOptionsDemo() {
		webDriver.get("https://www.selenium.dev/selenium/web/dynamic.html");
		final WebElement revealed = webDriver.findElement(By.id("revealed"));
		Wait<WebDriver> wait = new FluentWait<>(webDriver).withTimeout(Duration.ofSeconds(2))
				.pollingEvery(Duration.ofMillis(300)).ignoring(ElementNotInteractableException.class);

		webDriver.findElement(By.id("reveal")).click();
		wait.until(new Function<WebDriver, Object>() {
			@Override
			public Object apply(WebDriver d) {
				revealed.sendKeys("Displayed");
				return true;
			}
		});
		System.out.println("[ExplicitSyncWithOptions]Value of property 'value' = " + revealed.getDomProperty("value"));
	}

	private void waitForEnterKey(String demoName) {
		while (true) {
			System.out.println("Press enter after taking screenshots of " + demoName + " demo.");
			String entered = scanner.nextLine();
			if (entered.equals("")) {
				break;
			}
		}
	}

	public void end() {
		webDriver.quit();
		scanner.close();
	}
}