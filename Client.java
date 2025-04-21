package math;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
public static void main(String[] args) throws Exception {
	Socket socket = new Socket("localhost", 3636);
	Scanner inclient = new Scanner(socket.getInputStream());
	PrintWriter outclient = new PrintWriter(socket.getOutputStream(),true);
	Scanner input = new Scanner(System.in);
	System.out.println("Nhap cu phap tinh toan");
	String s = input.nextLine();
	outclient.println(s);
	String kq = inclient.nextLine();
	System.out.println("Ket qua: " + kq);
	socket.close();
	
}
}
