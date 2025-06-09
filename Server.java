package datetime;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(3636);
		while(true) {
			Socket socket = serverSocket.accept();
			Scanner inServer = new Scanner(socket.getInputStream());
			PrintWriter outServer = new PrintWriter(socket.getOutputStream(),true);
			String s = inServer.nextLine();
			Calendar calen = Calendar.getInstance();
			SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat time = new SimpleDateFormat("hh-mm-ss");
			String kq;
			if(s.equalsIgnoreCase("date")) {
				kq = date.format(calen.getTime());
			} else {
				kq = time.format(calen.getTime());
			}
			outServer.println(kq);
			socket.close();
		}
	}
	
}
