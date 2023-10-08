package tp1;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String arg[]) {
		try{
			// Attentative de connexion au serveur utilisant l'addresse 'localhost' et le port 1234.
			Socket socket = new Socket("localhost", 1234);
			System.out.println("Je suis connecté");
			
			// Liberer les resources
			socket.close();
		}catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
