import java.rmi.Naming;
public class Server {
    public static void main(String[] args) {
try {
DBImpl di = new DBImpl();
Naming.rebind("rmi://127.0.0.1/DBServerBill", di);
System.out.println("Server Registered.");
} catch (Exception e1) {
e1.printStackTrace();
}
}
}
