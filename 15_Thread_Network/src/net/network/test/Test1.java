package net.network.test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("도메인이나 호스트명을 입력하세요 : ");
		String str = sc.next();
		InetAddress[] addr = null;
		try {
			addr = InetAddress.getAllByName(str);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		for(InetAddress ar : addr) {
			System.out.println(ar.getHostAddress());
		}
		
	}
}
