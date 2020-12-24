package kh.java.byte_.data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIOTest {
	
	public static void main(String[] args) {
		DataIOTest d = new DataIOTest();
		//d.test1();
		d.test2();
		d.test3();
	}
	
	public void test3() {
		DataInputStream dis = null;
		File f = new File("data/scores.dat");
		int sum = 0;
		int count = 0;
		try {
			dis = new DataInputStream(new FileInputStream(f));
			
			while(true) {
				sum += dis.readInt();
				count++;
			}

		//EOFException은 오류라기보다는 파일의 끝이라는 알람 정도로 생각하기.	
		}catch(EOFException e) {
			System.out.println("총점은 : " + sum);
			System.out.println(count + "명의 데이터");
			System.out.println("평균은 : " + ((double)sum / count));
		}
		catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				dis.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void test2() {
		DataOutputStream dos = null;
		File f = new File("data/scores.dat");
		
		try {
			dos = new DataOutputStream(new FileOutputStream(f));
			int[] scores = {100, 44, 55, 64, 35, 75, 80, 90, 99};

			for(int s : scores) {
				dos.writeInt(s);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				dos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * DataInputStream
	 * DataOutputStream
	 * 자료형을 단위로 읽거나 쓰는 스트림
	 * 적절한 자료형별 읽기/쓰기 메소드를 사용해야 함.
	 * 자료형이 섞여있는 경우, 순서가 매우 중요하다.
	 * 한 타입으로 많은 양의 데이터를 저장해야 할 필요가 있을 때 유용하다.
	 */
	public void test1() {
		File f = new File("data/sample.dat");
		DataOutputStream dos = null;
		DataInputStream dis = null;
		try {
			dos = new DataOutputStream(new FileOutputStream(f));		
			dis = new DataInputStream(new FileInputStream(f));
			//쓰기	
			
			//순서가 매우 중요하다.
			dos.writeInt(100);
			dos.writeDouble(123.456);
			dos.writeBoolean(true);
			dos.writeUTF("안녕하세요.");
			
			System.out.println(dis.readInt());
			System.out.println(dis.readDouble());
			System.out.println(dis.readBoolean());
			System.out.println(dis.readUTF());
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				dis.close();
				dos.close();				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
