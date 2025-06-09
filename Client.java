package datetime;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws Exception{
		Socket socket = new Socket("localhost", 3636);
		Scanner inClient = new Scanner(socket.getInputStream());
		PrintWriter outClient = new PrintWriter(socket.getOutputStream(),true);
		Scanner input = new Scanner(System.in);
		System.out.println("Nhap date/time");
		String s = input.nextLine();
		outClient.println(s);
		String kq = inClient.nextLine();
		System.out.println("Ket qua: " + kq);
		socket.close();
}
}
