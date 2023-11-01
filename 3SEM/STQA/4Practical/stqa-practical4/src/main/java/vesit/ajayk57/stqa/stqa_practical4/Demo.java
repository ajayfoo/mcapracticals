package vesit.ajayk57.stqa.stqa_practical4;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo {
	private final WebDriver driver;
	private final Scanner sc = new Scanner(System.in);

	public Demo(WebDriver driver) {
		this.driver = driver;
	}

	public void runDifferentAlertsDemo() {
		final String htmlDocumentName = "index.html";
		Path htmlDocPath = Paths.get(htmlDocumentName);
		driver.get(htmlDocPath.toUri().toString());
		runAlertBoxDemo();
		runConfirmBoxDemo();
		runPromptBoxDemo();
	}

	private void runAlertBoxDemo() {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		waitForEnterKey("Alert Box");
		alert.accept();
	}

	private void runConfirmBoxDemo() {
		WebElement button = driver.findElement(By.id("set_confirmation_button"));
		button.click();
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		waitForEnterKey("Confirm Box");
		alert.dismiss(); // select Cancel
	}

	private void runPromptBoxDemo() {
		WebElement button = driver.findElement(By.id("set_name_button"));
		button.click();
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		final String inputForPrompt = "Ajay Karthikesan";
		alert.sendKeys(inputForPrompt);
		alert.accept();
		waitForEnterKey("Prompt Box");
	}

	public void runDropdownDemo() {
		final String htmlDocumentName = "index2.html";
		Path htmlDocPath = Paths.get(htmlDocumentName);
		driver.get(htmlDocPath.toUri().toString());
		Select dropdown = new Select(driver.findElement(By.id("myDropdown")));
		final String optionToSelect = "India";
		dropdown.selectByVisibleText(optionToSelect);
		waitForEnterKey("Dropdown");
	}

	public void runCommandButtonDemo() {
		final String htmlDocumentName = "index3.html";
		Path htmlDocPath = Paths.get(htmlDocumentName);
		driver.get(htmlDocPath.toUri().toString());
		WebElement cmdButton = driver.findElement(By.cssSelector("button"));
		waitForEnterKey("Command Button(Before Clicking]");
		cmdButton.click();
		waitForEnterKey("Command Button(After Clicking]");
	}

	public void runRadioButtonDemo() {
		final String htmlDocumentName = "index3.html";
		Path htmlDocPath = Paths.get(htmlDocumentName);
		driver.get(htmlDocPath.toUri().toString());
		final String valueToSelect = "Java";
		WebElement radioButton = driver
				.findElement(By.cssSelector(String.format("input[type='radio'][value='%s']", valueToSelect)));
		radioButton.click();
		waitForEnterKey("Radio Button");
	}

	public void runTextBoxDemo() {
		final String htmlDocumentName = "index3.html";
		Path htmlDocPath = Paths.get(htmlDocumentName);
		driver.get(htmlDocPath.toUri().toString());
		final String name = "Ajay Karthikesan";
		WebElement textBox = driver.findElement(By.id("my_name_input"));
		textBox.sendKeys(name);
		WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
		submitButton.click();
		waitForEnterKey("Textbox");
	}

	public void runWaitCommandsDemo() {
		runImplicitWaitDemo();
		runExplicitWaitDemo();
		runFluentWaitDemo();
	}

	private void runImplicitWaitDemo() {
		final String htmlDocumentName = "index3.html";
		Path htmlDocPath = Paths.get(htmlDocumentName);
		System.out.println("Waiting for 3 seconds(implicit wait)");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(htmlDocPath.toUri().toString());
		System.out.println("Current URL = " + driver.getCurrentUrl());
	}

	private void runExplicitWaitDemo() {
		driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
		WebElement revealed = driver.findElement(By.id("revealed"));
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		driver.findElement(By.id("reveal")).click();
		wait.until(d -> revealed.isDisplayed());
		revealed.sendKeys("Displayed");
		System.out.println("[ExplicitWait]Value of property 'value' = " + revealed.getDomProperty("value"));
	}

	private void runFluentWaitDemo() {
		driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
		WebElement revealed = driver.findElement(By.id("revealed"));
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(2))
				.pollingEvery(Duration.ofMillis(300)).ignoring(ElementNotInteractableException.class);

		driver.findElement(By.id("reveal")).click();
		wait.until(d -> {
			revealed.sendKeys("Displayed");
			return true;
		});
		System.out.println("[FluentWait]Value of property 'value' = " + revealed.getDomProperty("value"));
	}

	public void runActionsDemo() {
		runKeyboardActionsDemo();
		runMouseActionsDemo();
		wheelActionsDemo();
	}

	private void runKeyboardActionsDemo() {
		driver.get("https://www.selenium.dev/selenium/web/single_text_input.html");

		new Actions(driver).keyDown(Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT).sendKeys("b").perform();

		WebElement textField = driver.findElement(By.id("textInput"));
		final String expectedValue = "Ab";
		System.out.println("Expected Value: " + expectedValue);
		System.out.println("Actual Value: " + textField.getAttribute("value"));
		waitForEnterKey("Keyboard Actions");
	}

	private void runMouseActionsDemo() {
		driver.get("https://www.selenium.dev/selenium/web/mouse_interaction.html");

		WebElement clickable = driver.findElement(By.id("clickable"));
		new Actions(driver).doubleClick(clickable).perform();
		final String expectedValue = "double-clicked";
		System.out.println("Expected Value: " + expectedValue);
		System.out.println("Actual Value: " + driver.findElement(By.id("click-status")).getText());
		waitForEnterKey("Mouse Actions");
	}

	private void wheelActionsDemo() {
		// scroll to element
		driver.get(
				"https://www.selenium.dev/selenium/web/scrolling_tests/frame_with_nested_scrolling_frame_out_of_view.html");
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		new Actions(driver).scrollToElement(iframe).perform();
		System.out.println("In Viewport = " + inViewport(iframe));
		waitForEnterKey("Wheel Actions");
	}

	private boolean inViewport(WebElement element) {

		String script = "for(var e=arguments[0],f=e.offsetTop,t=e.offsetLeft,o=e.offsetWidth,n=e.offsetHeight;\n"
				+ "e.offsetParent;)f+=(e=e.offsetParent).offsetTop,t+=e.offsetLeft;\n"
				+ "return f<window.pageYOffset+window.innerHeight&&t<window.pageXOffset+window.innerWidth&&f+n>\n"
				+ "window.pageYOffset&&t+o>window.pageXOffset";

		return (boolean) ((JavascriptExecutor) driver).executeScript(script, element);
	}

	private void waitForEnterKey(String demoName) {
		while (true) {
			System.out.println("Press enter after taking screenshots of " + demoName + " demo.");
			String entered = sc.nextLine();
			if (entered.equals("")) {
				break;
			}
		}
	}

	public void end() {
		sc.close();
		driver.quit();
	}
}
