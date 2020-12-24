package kh.java.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

public class NetworkTest {
	public static void main(String[] args) {
		NetworkTest n = new NetworkTest();
		n.test1();
		n.test2();
	}
	
	/**
	 * URL
	 */
	private void test2() {
		BufferedReader br = null;
		BufferedWriter bw = null;
		//https는 443 포트 사용
		//parsing
		try{
			URL url = 
					new URL("https://docs.oracle.com:443/javase/8/"
							+ "docs/api/index.html?java/lang/String.html");
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			System.out.println(url.getPort());
			System.out.println(url.getPath());
			
			//연결(세션) 객체 생성 ( 요청 보냄 )
			URLConnection conn = url.openConnection();
			//입력스트림
			InputStream is = conn.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			
			//파일로 저장
			String fileName = "String.html";
			bw = new BufferedWriter(new FileWriter(fileName));
			
			
			String line = "";
			while((line = br.readLine())!=null) {
				System.out.println(line);
				bw.write(line + "\n");
			}
			
		}catch(MalformedURLException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void test1() {
		try{
			InetAddress naver = InetAddress.getByName("naver.com");
			System.out.println(naver.getHostAddress());
		
			InetAddress[] navers = InetAddress.getAllByName("naver.com");
			for(InetAddress addr : navers) {
				System.out.println(addr.getHostAddress());
			}
			
			// 내 ip 찾기
			InetAddress localhost = InetAddress.getLocalHost();
			System.out.println(
					"내 ip : " + localhost.getHostAddress());
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}
		
		
	}
}
