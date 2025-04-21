package pt1;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(3636);
		while(true) {
			Socket socket = serverSocket.accept();
			Scanner inServer = new Scanner(socket.getInputStream());
			PrintWriter outServer = new PrintWriter(socket.getOutputStream(),true);
			
			String s = inServer.nextLine();
			
			String cp[] = s.split(" ");
			
			
			String nu1 = s.substring(0, s.indexOf(" ")+1);
			System.out.println(nu1);
			
			String nu2 = s.substring(0, s.indexOf(" ")+ 1);
			System.out.println(nu2);
			
			String kq = tinhtoan(cp[0], cp[1]);
			outServer.println(kq);
			socket.close();
			
		}
		
	}
	public static String tinhtoan(String as, String bs) {
		int a = Integer.parseInt(as);
		int b = Integer.parseInt(bs);
		if (a == 0) {
            if (b == 0) {
                return "Phương trình có vô số nghiệm";
            } else {
                return "Phương trình vô nghiệm";
            }
        } else {
            double x = -b / a;
            return "Nghiệm của phương trình là: " + x;}

	}

}
