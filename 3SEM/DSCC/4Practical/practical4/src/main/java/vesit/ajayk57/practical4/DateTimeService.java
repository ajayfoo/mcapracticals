package vesit.ajayk57.practical4;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface DateTimeService extends Remote {
	Date getDate() throws RemoteException;

	String getTime() throws RemoteException;
}
