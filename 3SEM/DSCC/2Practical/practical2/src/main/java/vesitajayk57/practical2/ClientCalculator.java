package vesitajayk57.practical2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientCalculator {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 12345);

			// Create input and output streams for communication with the server.
			PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// Create a scanner to read user input.
			Scanner scanner = new Scanner(System.in);

			// Loop to keep sending math expressions until the user provides no input.
			while (true) {
				// Prompt the user for a math expression.
				System.out.print("Enter a math expression (e.g., '5 + 3') or press Enter to exit: ");
				String expression = scanner.nextLine();

				// If the user provides no input (presses Enter), exit the loop.
				if (expression.isEmpty()) {
					break;
				}

				// Send the user's input expression to the server.
				output.println(expression);

				// Receive and print the result.
				String result = input.readLine();
				System.out.println("Server Response: " + result);
			}

			// Close the socket and scanner.
			socket.close();
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
