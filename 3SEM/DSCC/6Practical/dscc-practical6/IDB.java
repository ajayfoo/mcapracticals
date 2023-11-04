import java.rmi.*;
public interface IDB extends Remote {
    public String getData() throws RemoteException;
    public String getData(int id) throws RemoteException;
}

