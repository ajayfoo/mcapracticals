package vesit.ajayk57.stqa.stqa_practical3;

import org.openqa.selenium.chrome.ChromeDriver;

public class App {
	public static void main(String[] args) {
		Demo demo = new Demo(new ChromeDriver());
		demo.runSomeBrowserCommands();
		demo.runNavCommands();
		demo.runLocatorDemo();
		demo.runSynchronizationDemo();
		demo.end();
	}
}
