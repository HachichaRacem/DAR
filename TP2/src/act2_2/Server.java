package act2_2;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
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
			
			ObjectInputStream ois = new ObjectInputStream(is);
			
			Operation op;
			
				
			op = (Operation) ois.readObject();
			int resultat = op.op1;
			switch(op.operation) {
			case '+':
				resultat += op.op2;
				break;
			case '-':
				resultat -= op.op2;
				break;
			case '*':
				resultat *= op.op2;
				break;
			case '/':
				resultat /= op.op2;
				break;
			}
			op.resultat = resultat;
			pw.println(resultat);
			
			
			serverSocket.close();
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
