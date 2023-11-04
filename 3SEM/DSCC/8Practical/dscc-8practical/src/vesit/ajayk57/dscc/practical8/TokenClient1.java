package vesit.ajayk57.dscc.practical8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class TokenClient1 {
	public static DatagramSocket ds;
	public static DatagramPacket dp;
	public static BufferedReader br;
	static int cp = 100;
	final private static int PORT_NUMBER = 9002;
	final private static int SERVER_PORT_NUMBER = 9001;
	final private static int CLIENT2_PORT_NUMBER = 9003;

	public static void main(String[] args) throws Exception {
		boolean hasToken;
		try {
			ds = new DatagramSocket(PORT_NUMBER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		hasToken = true;
		while (true) {
			if (hasToken == true) {
				System.out.println("Do you want to enter data...(yes/no):");
				br = new BufferedReader(new InputStreamReader(System.in));
				String ans = br.readLine();
				if (ans.equalsIgnoreCase("yes")) {
					System.out.println("ready to send");
					System.out.println("sending");
					System.out.println("Enter the data");
					br = new BufferedReader(new InputStreamReader(System.in));
					String str = "Client-1===> " + br.readLine();
					byte buff[] = new byte[1024];
					buff = str.getBytes();
					ds.send(new DatagramPacket(buff, buff.length, InetAddress.getLocalHost(), SERVER_PORT_NUMBER));
					System.out.println("now sending");
				} else if (ans.equalsIgnoreCase("no")) {
					System.out.println("I am busy state");
					// sending msg to client-2
					String msg = "Token";
					byte bf1[] = new byte[1024];
					bf1 = msg.getBytes();
					ds.send(new DatagramPacket(bf1, bf1.length, InetAddress.getLocalHost(), CLIENT2_PORT_NUMBER));
					hasToken = false;
					// recevingmsg from client-2
					byte bf2[] = new byte[1024];
					ds.receive(dp = new DatagramPacket(bf2, bf2.length));
					String clientmsg = new String(dp.getData(), 0, dp.getLength());
					System.out.println("The data is " + clientmsg);

					if (clientmsg.equals("Token")) {
						hasToken = true;
					}
					System.out.println("I am leaving busy state");
				}
			} else {
				System.out.println("Entering in receive mode.");
				byte bf[] = new byte[1024];
				ds.receive(dp = new DatagramPacket(bf, bf.length));
				String clientmsg1 = new String(dp.getData(), 0, dp.getLength());
				System.out.println("The data is " + clientmsg1);
				if (clientmsg1.equals("Token"))
					;
				{
					hasToken = true;
				}
			}
		}
	}
}
