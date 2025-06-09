package vidu2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class CapitalizeToolUDPServer {
	public static void main(String[] args) throws Exception {
		int port = 1234;
		DatagramSocket dgs = new DatagramSocket(port);
		
		byte[] buffer = new byte[1024];
		DatagramPacket inPacket = 
				new DatagramPacket(buffer, buffer.length);
		
		dgs.receive(inPacket);
		
		String s = new String(inPacket.getData(),0,inPacket.getLength());
		
		String ss = s.toUpperCase();
		
		InetAddress clientAddress = inPacket.getAddress();
		int portClient = inPacket.getPort();
		
		DatagramPacket outPacket = new DatagramPacket
				(ss.getBytes(), ss.length(),clientAddress,portClient);
		dgs.send(outPacket);// send packet to client
		dgs.close();

	}
}
