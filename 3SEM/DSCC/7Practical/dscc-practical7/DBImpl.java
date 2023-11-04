import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
public class DBImpl extends UnicastRemoteObject implements IDB {
String str, str1;
public DBImpl() throws RemoteException {
}
@Override
public String getData(int id) throws RemoteException {
String URL = "jdbc:mysql://localhost:3306/dscc";
String UName = "ajayk";
String Pass = "0";
try {
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection(URL, UName, Pass);
PreparedStatement ps = con.prepareStatement("select * from bill where bill_id=?");
ps.setInt(1, id);
ResultSet rs = ps.executeQuery();
ResultSetMetaData rsmd = rs.getMetaData();
str = "";
str1 = "";
for (int i = 1; i <= rsmd.getColumnCount(); i++) {
str1 = str1 + rsmd.getColumnName(i) + "\t";
}
System.out.println();
while (rs.next()) {
for (int i = 1; i <= rsmd.getColumnCount(); i++) {
str = str + rs.getString(i) + "\t";
}
str = str + "\n";
}
} catch (Exception e) {
e.printStackTrace();
}
return (str1 + "\n" + str);
}
}
