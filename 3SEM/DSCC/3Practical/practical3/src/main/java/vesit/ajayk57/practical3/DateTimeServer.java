package vesit.ajayk57.practical3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeServer {
	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket(12345);
			byte[] receiveData = new byte[1024];

			System.out.println("Date-Time Server is running and listening on port 12345...");

			while (true) {
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				socket.receive(receivePacket);

				String request = new String(receivePacket.getData(), 0, receivePacket.getLength());

				// Process the request and generate a response.
				String response = processRequest(request);

				InetAddress clientAddress = receivePacket.getAddress();
				int clientPort = receivePacket.getPort();

				byte[] sendData = response.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
				socket.send(sendPacket);

				System.out.println("Response sent to client: " + response);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String processRequest(String request) {
		// Check the request type and generate a response accordingly.
		if ("date()".equals(request)) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			return "Date: " + dateFormat.format(new Date());
		} else if ("time()".equals(request)) {
			SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
			return "Time: " + timeFormat.format(new Date());
		} else {
			return "Invalid request";
		}
	}
}
