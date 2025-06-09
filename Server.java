package looptun;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args)throws Exception {
		ServerSocket ss = new ServerSocket(36);
		while(true) {
			Socket socket = ss.accept();
			Scanner inS = new Scanner(socket.getInputStream());
			PrintWriter outS = new PrintWriter(socket.getOutputStream(),true);
			
			String s = inS.nextLine();
			
			String cp[] = s.split(" ");
			
			int n = Integer.parseInt(cp[1]);
			
			int kq = 0;
			if(cp[0].equalsIgnoreCase("sum")) {
				for(int i = 0; i<=n; i++)
					kq+=i;
			}
			else {
				kq = 1;
				for(int i = 1; i<=n; i++)
					kq*=i;
			}
			outS.println(kq);
			socket.close();
		}
	}
	
}
