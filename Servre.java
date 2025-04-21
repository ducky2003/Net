package pt;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servre {
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(3636);
		while(true) {
			Socket socket = serverSocket.accept();
			
			Scanner inS = new Scanner(socket.getInputStream());
			PrintWriter outS = new PrintWriter(socket.getOutputStream(),true);
			
			String s = inS.nextLine();
			String cp[] = s.split(" ");
			
			double a = Double.parseDouble(cp[0]);
            double b = Double.parseDouble(cp[1]);

     
            String kq = tinhtoan(a, b);
            outS.println(kq);
            socket.close();
		}
	}
	public static String tinhtoan(double a, double b) {
		if(a == 0) {
			if(b == 0) {
				return"Phuong trinh vo so nghiem";
			} else {
				return"phuong trinh vo nghiem";
			}
		}
		else {
			double x = -b/a;
			return"Phuong trinh co nghiem: " + x;
		}
	}
}
