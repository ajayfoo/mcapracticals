package vesit.ajayk57.practical4;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class DateTimeServer {
	public static void main(String[] args) {
		try {
			DateTimeService dateTimeService = new DateTimeServiceImpl();

			// Create and start the RMI registry on port 1099 (default).
			LocateRegistry.createRegistry(1099);

			// Bind the remote object to a name in the RMI registry.
			Naming.rebind("DateTimeService", dateTimeService);

			System.out.println("Server is running and ready to serve...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
