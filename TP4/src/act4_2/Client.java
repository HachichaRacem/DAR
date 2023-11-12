package act4_2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	
	private static final int PORT = 1234;
	private static final int buffLen = 1024;
	private static final byte[] buff = new byte[buffLen];
	
	public static void main(String[] args) {
		try {
			// Création d'une socket UDP pour se connecter au serveur sur le port 1234
			DatagramSocket socket = new DatagramSocket();
			
			// Adresse du serveur
			InetAddress serverAddress = InetAddress.getByName("localhost");
			
			// Envoi de la demande au serveur
			DatagramPacket sendPacket = new DatagramPacket("temps".getBytes(), "temps".getBytes().length, serverAddress, PORT);
			socket.send(sendPacket);
			
			// Création du paquet pour recevoir les données
			DatagramPacket packet = new DatagramPacket(buff, buffLen, serverAddress, PORT);
			socket.receive(packet);
			
			// Conversion des données reçues en String et affichage
			String resultat = new String(packet.getData(), 0, buffLen);
			System.out.println("Resultat : " + resultat);
			
			socket.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
