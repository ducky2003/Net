package looptun;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args)throws Exception {
		Socket socket = new Socket("localhost", 36);
		Scanner inC = new Scanner(socket.getInputStream());
		
		PrintWriter outC = new PrintWriter(socket.getOutputStream(),true);
		
		Scanner input = new Scanner(System.in);
		System.out.println("Nhap cu phap tinhs toan: ");
		
		String s = input.nextLine();
		outC.println(s);
		
		String kq = inC.nextLine();
		System.out.println("Ket qua: "+kq);
		socket.close();
	}
}
