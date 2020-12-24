package kh.java.byte_.object;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class ObjectIOTest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 객체입출력스트림에 사용될 클래스는 반드시 Serializable 인터페이스를 구현해야함.
	 * 
	 * 직렬화/역직렬화
	 * 객체의 정보를 이진데이터로 나열해서 관리하기 위한 방법
	 * 
	 * Serializable을 구현하지 않고, 객체입출력스트림에서 사용하게 되면,
	 * NotSerializableException을 던진다.
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		ObjectIOTest o = new ObjectIOTest();
		o.test1();
		o.test2();
	}
	
	/**
	 * 직렬화된 User데이터를 파일로부터 읽어서 JVM에 가져오기
	 * 
	 * try with resource
	 * jdk1.7
	 * 
	 */
	public void test2() {
		File f = new File("object/users.ser");
		try(ObjectInputStream ois = 
				new ObjectInputStream(new FileInputStream(f));){
//			User u1 = (User)ois.readObject();
//			User u2 = (User)ois.readObject();
//			User u3 = (User)ois.readObject();
			
			
//			//객체가 문자열로 찍어줘야 할 때는 자동으로 toString()으로 호출됨.
//			System.out.println(u1);
//			System.out.println(u2);
//			System.out.println(u3);
			//User객체의 개수를 모르는 경우
//			while(true) {
//				User u = (User)ois.readObject();
//				System.out.println(u);
//			}
			//2. User[]객체 읽어오기
			User[] userArr = (User[])ois.readObject();
			for(int i = 0; i < userArr.length; i++) {
				System.out.println(userArr[i]);
			}
			
		}catch(EOFException e) {
			System.out.println("모든 정보를 읽었습니다.");
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void test1() {
		ObjectOutputStream oos = null;
		String fileName = "object/users.ser";
		User u1 = new User("honggd","1234","홍길동", new Date());
		User u2 = new User("sinsa","1234","신사임당", new Date());
		User u3 = new User("sejong","1234","세종대왕", new Date());
		
		User[] userArr = new User[10];
		userArr[0] = u1;
		userArr[1] = u2;
		userArr[2] = u3;
		
		
		try {
			oos = new ObjectOutputStream(
					new FileOutputStream(fileName));
//			//1. User객체를 여러개 출력
//			oos.writeObject(u1);
//			oos.writeObject(u2);
//			oos.writeObject(u3);
			//2. User[]객체 하나 출력
			oos.writeObject(userArr);
			
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("객체 출력 완료!");
	}

}
