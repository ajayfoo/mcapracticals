
import java.rmi.Naming;

public class MyServer {
	public static void main(String args[]) {
		System.out.print("Hello");
		try {
			System.out.print("Server started, waiting for client to enter equation");
			EquationSolver stub = new EquationSolverImpl();
			Naming.rebind("rmi://localhost:5000/ajayk57EquationSolver", stub);
		} catch (Exception e) {

			System.out.print("exception on server");
			System.out.println(e);
		}
	}
}
