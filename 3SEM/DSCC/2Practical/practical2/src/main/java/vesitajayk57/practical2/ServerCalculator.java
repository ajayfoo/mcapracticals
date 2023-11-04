package vesitajayk57.practical2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCalculator {
	public static void main(String[] args) {
		try (ServerSocket serverSocket = new ServerSocket(12345)) {
			System.out.println("Server is running and listening on port 12345...");
			Socket clientSocket = serverSocket.accept();
			System.out.println("Client connected: " + clientSocket.getInetAddress());

			while (true) {

				// Create input and output streams for communication with the client.
				BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

				// Read the math expression from the client.
				String expression = input.readLine();
				if (expression == null || expression.isEmpty()) {
					clientSocket.close();
					System.out.println("Client disconnected.");
					break;
				}
				System.out.println("Received Expression: " + expression);
				// Evaluate the expression and send the result back to the client.
				try {
					double result = evaluateExpression(expression);
					output.println("Result: " + result);
				} catch (Exception e) {
					output.println("Error: " + e.getMessage());
				}

				// Close the client socket.

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static double evaluateExpression(String expression) throws Exception {
		// Implement your expression evaluation logic here.
		// You can use libraries like javax.script.ScriptEngine for this purpose.
		// For simplicity, we'll assume that the expression is in a valid format.

		// Example evaluation using ScriptEngine (JavaScript evaluator):
		// ScriptEngineManager manager = new ScriptEngineManager();
		// ScriptEngine engine = manager.getEngineByName("js");
		// return (double) engine.eval(expression);

		// For demonstration purposes, we'll use a simple parser here:
		String[] tokens = expression.split(" ");
		if (tokens.length != 3) {
			throw new Exception("Invalid expression format");
		}
		double operand1 = Double.parseDouble(tokens[0]);
		double operand2 = Double.parseDouble(tokens[2]);
		String operator = tokens[1];

		switch (operator) {
		case "+":
			return operand1 + operand2;
		case "-":
			return operand1 - operand2;
		case "*":
			return operand1 * operand2;
		case "/":
			if (operand2 == 0) {
				throw new Exception("Division by zero");
			}
			return operand1 / operand2;
		default:
			throw new Exception("Invalid operator");
		}
	}
}
