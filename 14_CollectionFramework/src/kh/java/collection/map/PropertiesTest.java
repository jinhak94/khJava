package kh.java.collection.map;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Properties
 * - HashTable을 상속한 amp의 예전 클래스
 * - key, value 타입을 String, String으로 제한해서
 * - 설정정보를 관리하는데 최적화
 * 
 */

public class PropertiesTest {
	public static void main(String[] args) {
		PropertiesTest p = new PropertiesTest();
		p.test1();
		p.test2();
	}
	
	private void test2() {
		Properties prop = new Properties();
		try{
			//prop.load(new FileReader("user.properties"));
			prop.loadFromXML(new FileInputStream("user.xml"));
			System.out.println(prop);
		}catch(IOException e) {
			e.printStackTrace();
		}
		//개별 접근
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		String url = prop.getProperty("url");
		
		System.out.println("username = " + username);
		System.out.println("password = " + password);
		System.out.println("url = " + url);
		
		//전체요소 열람
		//1. list
		prop.list(System.out);
		
		//2. Enumeration : keySet -> iterator
		Enumeration<?> names = prop.propertyNames();
		while(names.hasMoreElements()) {
			String name = (String)names.nextElement();
//			System.out.println(name);
			String value = prop.getProperty(name);
			System.out.println(name + " = " + value);
		}
	}
	
	private void test1() {
		Properties prop = new Properties();
		prop.setProperty("username", "honggd");
		prop.setProperty("password", "1234");
		prop.setProperty("url",  "https://iei.or.kr");
		
		System.out.println(prop);
		
		//파일기록
		try{
			prop.store(new FileWriter("user.properties"), 
					"user.properties");
			prop.storeToXML(new FileOutputStream("user.xml"), "user.xml");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("prop 저장 완료!");
	}
}
