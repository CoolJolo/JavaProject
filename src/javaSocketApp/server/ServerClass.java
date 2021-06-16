package javaSocketApp.server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import javaSocketApp.gui.WindowClass;

public class ServerClass {

    // list of all clients
	private List<ClientHandler> clients; // or "protected static List<ClientThread> clients;"

    private ServerSocket server = null;

    public void serverConstructor(int port, WindowClass window){
        
        try {
            server = new ServerSocket(port);
            server.setReuseAddress(true);
            System.out.println("... server started and is accessable under: " + server.getLocalSocketAddress());

            // running infinite loop for getting client request
            while (true) {

                Socket client = server.accept();

                // Displaying that new client is connected to server
                System.out.print("New client "
                    + client.getInetAddress()
                        .getHostAddress()
                    + " request connection... ");

                if (window.serverAccess == true) {
                    // create a new thread object
                    ClientHandler clientSock = new ClientHandler(client);

                    // This thread will handle the client separately
                    new Thread(clientSock).start();

                    clients.add(clientSock);

                    System.out.println("connected!");

					// should return all clients names
					System.out.println(clients);
                } else {

                    System.out.println("rejected!");
					client.close();
                }

            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        finally {
            if (server != null) {
                try {
                    System.out.println("Server shutdown...");
                    server.close();
                } 
                catch (IOException e) {
                    System.out.print("...");
                    e.printStackTrace();
                }
            }
        }
        
    }

    private static class ClientHandler implements Runnable {
		private final Socket clientSocket;

		// Constructor
		public ClientHandler(Socket socket)
		{
			this.clientSocket = socket;
		}

		public void run()
		{
			PrintWriter out = null;
			BufferedReader in = null;
			try {
				// get the outputstream of client
				out = new PrintWriter(
					clientSocket.getOutputStream(), true);

				// get the inputstream of client
				in = new BufferedReader(
					new InputStreamReader(
						clientSocket.getInputStream()));

				String line;
				while ((line = in.readLine()) != null) {

					// writing the received message from client
					System.out.printf(
						" Sent from the client: %s\n",
						line);
					out.println(line); // Server replied
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				try {
					// where difference
					if (out != null) {
						System.out.println("...");
						out.close();
					}
					if (in != null) {
						System.out.println("ClientSocket closed...");
						in.close();
						clientSocket.close();
					}
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

