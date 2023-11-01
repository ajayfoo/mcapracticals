package vesit.ajayk57.stqa.stqa_practical4;

import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Demo demo = new Demo(new ChromeDriver());
		demo.runDifferentAlertsDemo();
		demo.runDropdownDemo();
		demo.runCommandButtonDemo();
		demo.runRadioButtonDemo();
		demo.runTextBoxDemo();
		demo.runWaitCommandsDemo();
		demo.runActionsDemo();
		demo.end();
	}
}
