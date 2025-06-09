package vidu2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class CapitalizeToolUDPClient {
	public static void main(String[] args) throws Exception {
		DatagramSocket dgs = new DatagramSocket();
		InetAddress address = InetAddress.getLocalHost();
		int port = 1234;
		Scanner inputKB = new Scanner(System.in);
		System.out.println("Nhap chuoi: ");
		String s = inputKB.nextLine();
		DatagramPacket outPackage = 
				new DatagramPacket(s.getBytes(), s.length(),address,port);
		dgs.send(outPackage);// send package to server
		byte[] buffer = new byte[1024];
		DatagramPacket inPackage = new DatagramPacket(buffer, buffer.length);
		dgs.receive(inPackage);
		String ss = new String(inPackage.getData(),0,inPackage.getLength());
		System.out.println(ss);
		dgs.close();
	}
}
