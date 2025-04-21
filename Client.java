package pt;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 3636);
		
		Scanner inc = new Scanner(socket.getInputStream());
		PrintWriter outc = new PrintWriter(socket.getOutputStream(),true);
		
		Scanner input = new Scanner(System.in);
		System.out.println("Nhap he so a:");
		double a = input.nextDouble();
        
        System.out.println("Nhap he so b:");
        double b = input.nextDouble();
        
    
        outc.println(a + " " + b);
		
		String kq = inc.nextLine();
		System.out.println("Ket qua: "+ kq);
		socket.close();
	}
}
