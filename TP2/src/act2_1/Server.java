package act2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(1234);
			Socket socket = serverSocket.accept();
			
			System.out.println("Client connecté");
			
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os, true);
			
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader bfr = new BufferedReader(isr);
			int op1 = Integer.parseInt(bfr.readLine());
			String operation = bfr.readLine();
			int op2 = Integer.parseInt(bfr.readLine());
			
			int resultat = op1;
			switch(operation) {
			case "+":
				resultat += op2;
				break;
			case "-":
				resultat -= op2;
				break;
			case "*":
				resultat *= op2;
				break;
			case "/":
				resultat /= op2;
				break;
			}
			
			System.out.println(op1);
			System.out.println(operation);
			System.out.println(op2);
			System.out.println(resultat);
			
			pw.println(resultat);
			
			serverSocket.close();
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
