package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientGreeter {

	public static void main(String[] args) {
		// 1. Create a String for the ip address of the server.
		// 192.168.7.71
		String ip = "192.168.7.139";
		// If you don't know how to find a computer's ip address, ask about
		// ifconfig on linux/mac and ipconfig on windows.

		// 2. Create an integer for the server's port number
		int port = 7821;
		// 3. Surround steps 4-9 in a try-catch block that catches any
		// IOExceptions.
		try {
			Socket s = new Socket(ip, port);
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			dos.writeUTF("Thank you for accepting my virus");
			DataInputStream dis = new DataInputStream(s.getInputStream());
			System.out.println(dis.readUTF());
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e);
		}
		// 4. Create an object of the Socket class. When initializing the
		// object, pass in the ip address and the port number

		// 5. Create a DataOutputStream object. When initializing it, use the
		// Server object you created in step 4 to call the getOutputStream()
		// method.

		// 6. Use the DataOutputStream object to send a message to the server
		// using the writeUTF(String message) method

		// 7. Create a DataInputStream object. When initializing it, use the
		// Server object you created in step 4 to call the getInputStream()
		// method.

		// 8. Use the DataInputStream object to print a message from the server
		// using the readUTF() method.

		// 9. Close the client's server object

	}
}
