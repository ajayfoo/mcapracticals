
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner; // Import the Scanner class
import java.util.Set;
import java.util.TreeSet;

public class MyClient {
	public static void main(String args[]) {
		try (Scanner sc = new Scanner(System.in)) {
			while (true) {
				try {
					System.out.print("Enter equation: ");
					String equation = sc.nextLine();
					Set<String> tree = new TreeSet<>();
					ArrayList<Integer> params = new ArrayList<Integer>();
					for (char c : equation.toCharArray()) {
						if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
							tree.add(Character.toString(c));
						}
					}
					Iterator<String> value = tree.iterator();
//				tree.forEach(ele -> {
//					params.add(sc.nextInt());
//				});
					while (value.hasNext()) {
						System.out.println("Enter value for " + value.next());
						int temp = sc.nextInt();
						params.add(temp);
					}
					EquationSolver stub = (EquationSolver) Naming.lookup("rmi://localhost:5000/ajayk57EquationSolver");
					System.out.println("Answer: " + stub.evaluateEquation(equation, params));
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}
}
