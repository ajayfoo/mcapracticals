package vesit.ajayk57.dscc.practical8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class TokenClient2 {
	static DatagramSocket ds;
	static DatagramPacket dp;
	static BufferedReader br;
	final private static int PORT_NUMBER = 9003;
	final private static int SERVER_PORT_NUMBER = 9001;
	final private static int CLIENT1_PORT_NUMBER = 9002;

	public static void main(String[] args) throws Exception {
		try {
			ds = new DatagramSocket(PORT_NUMBER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean hasToken = true;
		while (true) {
//System.out.println("Entering if");
			if (hasToken == true) {
				System.out.println("Do you want to enter data(Yes/No):");
				br = new BufferedReader(new InputStreamReader(System.in));
				String str = br.readLine();
				if (str.equalsIgnoreCase("yes")) {
					System.out.println("Enter Data; ");
					br = new BufferedReader(new InputStreamReader(System.in));
					String msg = "Client-2===>" + br.readLine();
					byte bf1[] = new byte[1024];
					bf1 = msg.getBytes();
					ds.send(new DatagramPacket(bf1, bf1.length, InetAddress.getLocalHost(), SERVER_PORT_NUMBER));
					System.out.println("Data sent");
				} else {
//send to client 1.
					String clientmsg = "Token";
					byte bf2[] = new byte[1024];
					bf2 = clientmsg.getBytes();
					ds.send(new DatagramPacket(bf2, bf2.length, InetAddress.getLocalHost(), CLIENT1_PORT_NUMBER));
					hasToken = false;
				}
			} else {
				try {
					byte buff[] = new byte[1024];
					System.out.println("Entering in receiving mode.");
					ds.receive(dp = new DatagramPacket(buff, buff.length));
					String clientmsg1 = new String(dp.getData(), 0, dp.getLength());
					System.out.println("The data is " + clientmsg1);
					if (clientmsg1.equals("Token")) {
						hasToken = true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
