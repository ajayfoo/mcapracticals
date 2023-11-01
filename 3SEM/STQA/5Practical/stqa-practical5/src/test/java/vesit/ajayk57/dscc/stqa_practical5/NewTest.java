package vesit.ajayk57.dscc.stqa_practical5;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest {
	@Test
	public void f() {
		System.out.println("f()");
		assert ("a".equals("a"));
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Runs before f()");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Runs after f()");
	}

}
