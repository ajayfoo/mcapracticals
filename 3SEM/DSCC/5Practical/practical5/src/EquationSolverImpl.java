
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

public class EquationSolverImpl extends UnicastRemoteObject implements EquationSolver {
	private static final long serialVersionUID = 1L;

	EquationSolverImpl() throws RemoteException {
		super();
	}

	@Override
	public int evaluateEquation(String equation, ArrayList<Integer> params) {
		System.out.print("Equation recieved: " + equation);
		int a = 0, b = 0, c = 0;
		HashMap<String, Integer> map = new HashMap<>();
		if (params.size() == 2) {
			params.add(c);
		}
		map.put("a^2-b^2", (params.get(0) - params.get(1)) * (params.get(0) + params.get(1)));
		map.put("a^2+b^2", (int) (Math.pow((params.get(0) - params.get(1)), 2) + 2 * params.get(0) * params.get(1)));
		map.put("(a+b)^2",
				(int) (Math.pow(params.get(0), 2) + 2 * params.get(0) * params.get(1) + Math.pow(params.get(1), 2)));
		map.put("(a-b)^2",
				(int) (Math.pow(params.get(0), 2) - 2 * params.get(0) * params.get(1) + Math.pow(params.get(1), 2)));
		map.put("(a+b+c)^2",
				(int) (Math.pow(params.get(0), 2) + Math.pow(params.get(1), 2) + Math.pow(params.get(2), 2)
						+ 2 * params.get(0) * params.get(1) + 2 * params.get(1) * params.get(2)
						+ 2 * params.get(0) * params.get(2)));
		map.put("(a-b-c)^2",
				(int) (Math.pow(params.get(0), 2) + Math.pow(params.get(1), 2) + Math.pow(params.get(2), 2)
						- 2 * params.get(0) * params.get(1) + 2 * params.get(1) * params.get(2)
						- 2 * params.get(0) * params.get(1)));
		map.put("a^3-b^3", (int) ((params.get(0) - params.get(1))
				* (Math.pow(params.get(0), 2) + params.get(0) * params.get(1) + Math.pow(params.get(1), 2))));
		map.put("a^3+b^3", (int) ((params.get(0) + params.get(1))
				* (Math.pow(params.get(0), 2) - params.get(0) * params.get(1) + Math.pow(params.get(1), 2))));
		map.put("(a+b)^3", (int) (Math.pow(params.get(0), 3) + 3 * Math.pow(params.get(0), 2) * params.get(1)
				+ 3 * params.get(0) * Math.pow(params.get(1), 2) + Math.pow(params.get(1), 3)));
		map.put("(a-b)^3", (int) (Math.pow(params.get(0), 3) - 3 * Math.pow(params.get(0), 2) * params.get(1)
				+ 3 * params.get(0) * Math.pow(params.get(1), 2) - Math.pow(params.get(1), 3)));
		int answer = map.get(equation);
		System.out.print(answer);
		return answer;
	}
}
