package vesit.ajayk57.dscc.practical8;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

class TokenServer {
	public static DatagramSocket ds;
	public static DatagramPacket dp;
	final private static int PORT_NUMBER = 9001;

	public static void main(String[] args) throws Exception {
		try {
			ds = new DatagramSocket(PORT_NUMBER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		while (true) {
			byte buff[] = new byte[1024];
			ds.receive(dp = new DatagramPacket(buff, buff.length));
			String str = new String(dp.getData(), 0, dp.getLength());
			System.out.println("Message from " + str);
		}
	}
}
