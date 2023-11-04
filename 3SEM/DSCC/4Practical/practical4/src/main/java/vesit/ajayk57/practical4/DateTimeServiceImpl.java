package vesit.ajayk57.practical4;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class DateTimeServiceImpl extends UnicastRemoteObject implements DateTimeService {
	public DateTimeServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public Date getDate() throws RemoteException {
		return new Date(); // Return the current date.
	}

	@Override
	public String getTime() throws RemoteException {
		return new Date().toString(); // Return the current time as a string.
	}
}
