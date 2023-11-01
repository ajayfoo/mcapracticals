package vesit.ajayk57.stqa.stqa_practical4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;

public class PenActionsTest {
	final private WebDriver driver = new ChromeDriver();
	private final Scanner sc = new Scanner(System.in);

	@Test
	public void usePen() {
		if (!(driver instanceof ChromeDriver)) {
			System.err.println("ChromeDriver instance is needed for pen actions demo");
			return;
		}
		driver.get("https://www.selenium.dev/selenium/web/pointerActionsPage.html");

		WebElement pointerArea = driver.findElement(By.id("pointerArea"));
		new Actions(driver).setActivePointer(PointerInput.Kind.PEN, "default pen").moveToElement(pointerArea)
				.clickAndHold().moveByOffset(2, 2).release().perform();

		List<WebElement> moves = driver.findElements(By.className("pointermove"));
		Map<String, String> moveTo = getPropertyInfo(moves.get(0));
		Map<String, String> down = getPropertyInfo(driver.findElement(By.className("pointerdown")));
		Map<String, String> moveBy = getPropertyInfo(moves.get(1));
		Map<String, String> up = getPropertyInfo(driver.findElement(By.className("pointerup")));

		Rectangle rect = pointerArea.getRect();

		int centerX = (int) Math.floor(rect.width / 2 + rect.getX());
		int centerY = (int) Math.floor(rect.height / 2 + rect.getY());
		Assertions.assertEquals("-1", moveTo.get("button"));
		Assertions.assertEquals("pen", moveTo.get("pointerType"));
		Assertions.assertEquals(String.valueOf(centerX), moveTo.get("pageX"));
		Assertions.assertEquals(String.valueOf(centerY), moveTo.get("pageY"));
		Assertions.assertEquals("0", down.get("button"));
		Assertions.assertEquals("pen", down.get("pointerType"));
		Assertions.assertEquals(String.valueOf(centerX), down.get("pageX"));
		Assertions.assertEquals(String.valueOf(centerY), down.get("pageY"));
		Assertions.assertEquals("-1", moveBy.get("button"));
		Assertions.assertEquals("pen", moveBy.get("pointerType"));
		Assertions.assertEquals(String.valueOf(centerX + 2), moveBy.get("pageX"));
		Assertions.assertEquals(String.valueOf(centerY + 2), moveBy.get("pageY"));
		Assertions.assertEquals("0", up.get("button"));
		Assertions.assertEquals("pen", up.get("pointerType"));
		Assertions.assertEquals(String.valueOf(centerX + 2), up.get("pageX"));
		Assertions.assertEquals(String.valueOf(centerY + 2), up.get("pageY"));
		waitForEnterKey("Pen Actions");
		end();
	}

	private Map<String, String> getPropertyInfo(WebElement element) {
		String text = element.getText();
		text = text.substring(text.indexOf(' ') + 1);

		return Arrays.stream(text.split(", ")).map(s -> s.split(": ")).collect(Collectors.toMap(a -> a[0], a -> a[1]));
	}

	private void end() {
		sc.close();
		driver.quit();
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
}
