package ncs.test8;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class IPSearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		System.out.print("호스트명 : ");
		str = sc.next();
		int i = 1;
		try{
			InetAddress[] domains = InetAddress.getAllByName(str);
			System.out.println(str+"는 "
					+ domains.length + "개의 IP주소를 가지고 있습니다.");			
			for(InetAddress addr : domains) {
				System.out.println(i + "번 IP = " + addr.getHostAddress());
				i++;
			}
		}catch(UnknownHostException e) {
				e.printStackTrace();
		}
	}
}
