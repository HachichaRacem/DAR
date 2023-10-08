package tp1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args){
		System.out.println("Je suis un server");
		try {
			// Reserver un port pour le serveur.
			ServerSocket serverSocket = new ServerSocket(1234);
			System.out.println("J'attend un client");
			
			// Passer vers l'etat bloqué en attendant qu'un client se connecte.
			Socket socket = serverSocket.accept();
			
			System.out.println("Un client est connecté");
			
			// Liberer les resources.
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
