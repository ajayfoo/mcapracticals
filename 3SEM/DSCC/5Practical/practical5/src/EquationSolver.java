
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

@FunctionalInterface
public interface EquationSolver extends Remote {
	int evaluateEquation(String equation, ArrayList<Integer> params) throws RemoteException;
}
