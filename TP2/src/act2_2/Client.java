package act2_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 1234);
			OutputStream os = socket.getOutputStream();
			
			ObjectOutputStream oos = new ObjectOutputStream(os);
			
			PrintWriter pw = new PrintWriter(oos, true);
			
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("Donner le premier operateur : ");
			int op1 = scanner.nextInt();
			
			System.out.print("\nDonner l'operation : ");
			String operation;
			do {
				operation = scanner.nextLine();
			}while(!(operation.equals("*")) && !(operation.equals("+")) && !(operation.equals("-")) && !(operation.equals("/")));
			
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader bfr = new BufferedReader(isr);
			
			
			System.out.print("\nDonner le deuxieme operateur : ");
			int op2 = scanner.nextInt();
			
			scanner.close();
			
			Operation op = new Operation(op1, op2, operation.charAt(0));
			pw.println(op);
			
			System.out.println("\n" + op1 + " " + operation + " " + op2 + " = " + bfr.readLine());
			
			socket.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
