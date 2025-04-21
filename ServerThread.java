package math;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread{
	private static ServerSocket serversocket;
	private static Socket socket;
	@Override
	public void run() {
		try {
			Scanner inServer = new Scanner(socket.getInputStream());
			PrintWriter outServer = new PrintWriter(socket.getOutputStream(),true);
			
			String s = inServer.nextLine();
			
			String cp[] = s.split(" ");
			String cp2 = s.substring(0, s.indexOf(" "));
			s = s.substring(s.indexOf(" ")+1);
			System.out.println(cp2);
			
			String nu1 = s.substring(0, s.indexOf(" ")+1);
			System.out.println(nu1);
			String nu2 = s.substring(0, s.indexOf(" ")+1);
			System.out.println(nu2);
			String kq = tinhtoan(cp[0], cp[1], cp[2]);
			outServer.println(kq);
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static String tinhtoan(String cp, String a, String b) {
		String kq = "";
		int as = Integer.parseInt(a);
		int bs = Integer.parseInt(b);
		if(cp.equalsIgnoreCase("SUM")) {
			kq = kq + (as + bs);
		} else {
			kq = kq + (as * bs);
		}
		return kq;
			}
	public static void main(String[] args) throws Exception{
		serversocket = new ServerSocket(3636);
		while(true) {
			socket = serversocket.accept();
			ServerThread st = new ServerThread();
			st.start();
		}
		
	}

}
