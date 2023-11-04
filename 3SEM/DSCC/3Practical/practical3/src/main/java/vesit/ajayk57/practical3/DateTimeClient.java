package vesit.ajayk57.practical3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class DateTimeClient {
	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket();
			InetAddress serverAddress = InetAddress.getByName("localhost");
			int serverPort = 12345;

			// Create a scanner to read user input.
			Scanner scanner = new Scanner(System.in);

			while (true) {
				// Prompt the user for a request (date or time).
				System.out.print("Enter 'date()' or 'time()' to request the date or time, or 'exit' to quit: ");
				String userInput = scanner.nextLine();

				if ("exit".equalsIgnoreCase(userInput)) {
					break; // Exit the loop if the user enters 'exit'.
				}

				// Send the user's request to the server.
				byte[] sendData = userInput.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
				socket.send(sendPacket);

				// Receive the server's response.
				byte[] receiveData = new byte[1024];
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				socket.receive(receivePacket);

				String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
				System.out.println("Server Response: " + response);
			}

			// Close the socket and scanner.
			socket.close();
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
