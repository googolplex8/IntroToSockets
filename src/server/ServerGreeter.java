package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServerGreeter extends Thread {
	// 1. Create an object of the ServerSocket class
	ServerSocket ss;

	public ServerGreeter() throws IOException {
		// 2. Initialize the ServerSocket object. In the parameters,
		// you must define the port at which the server will listen for
		// connections.
		ss = new ServerSocket(8888);
		// *OPTIONAL* you can set a time limit for the server to wait by using
		// the
		// ServerSocket's setSoTimeout(int timeInMilliSeconds) method
	}

	public void run() {
		// 3. Create a boolean variable and initialize it to true.
		boolean running = true;
		// 4. Make a while loop that continues looping as long as the boolean
		// created in the previous step is true.
		while (running) {
			System.out.println("Waiting for a client to connect...");
			// JOptionPane.showMessageDialog(null, "Waiting for a client to
			// connect...");
			try {
				Socket socket = ss.accept();
				System.out.println("A client has connected");
				// JOptionPane.showMessageDialog(null, "A client has
				// connected");
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				System.out.println(dis.readUTF());
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				dos.writeUTF("Hello client");
				socket.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				running = false;
				JOptionPane.showMessageDialog(null, "An IOException has been encountered");

			}

		}
		// 5. Make a try-catch block that checks for two types Exceptions:
		// SocketTimeoutException and IOException.
		// Put steps 8 - 15 in the try block.

		// 8. Let the user know that the server is waiting for a client to
		// connect.

		// 9. Create an object of the Server class and initialize it to
		// serverSocket.accept();
		// Change serverSocket to match the ServerSocket member variable you
		// created in step 1.
		// The program will wait her until either a client connects or the
		// timeout expires.

		// 10. Let the user know that the client has connected.

		// 11. Create a DataInputStream object. When initializing it, use the
		// Server object you created in step 9 to call the getInputStream()
		// method.

		// 12. Print the message from the DataInputStream object using the
		// readUTF() method

		// 13. Create a DataOutputStream object. When initializing it, use the
		// Server object you created in step 9 to call the getOutputStream()
		// method.

		// 14. Use the DataOutputStream object to send a message to the client
		// using the writeUTF(String message) method.

		// 15. Close the client server

		// 6. If the program catches a SockeTimeoutException, let the user know
		// about it and set loop's boolean variable to false.

		// 7. If the program catches a IOException, let the user know about it
		// and set the loop's boolean variable to false.

	}

	public static void main(String[] args) {
		// 16. In a new thread, create an object of the ServerGreeter class and
		// start the thread. Don't forget the try-catch.
		new Thread(() -> {
			try {
				ServerGreeter serverGreeter = new ServerGreeter();
				serverGreeter.run();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
	}
}
