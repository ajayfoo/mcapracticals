package vesit.ajayk57.practical4;

import java.rmi.Naming;

public class DateTimeClient {
	public static void main(String[] args) {
		try {
			// Lookup the remote object in the RMI registry using its name.
			DateTimeService dateTimeService = (DateTimeService) Naming.lookup("rmi://localhost/DateTimeService");

			// Call the remote methods to get date and time.
			System.out.println("Server Date: " + dateTimeService.getDate());
			System.out.println("Server Time: " + dateTimeService.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
