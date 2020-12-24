package kh.java.byte_.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOTest {
	public static void main(String[] args) {
		FileIOTest f = new FileIOTest();
//		f.test1();
		f.test2();
	}
	
	/**
	 * 기본스트림 + 보조스트림
	 */
	private void test2() {
		String fileName = "file/myfile.txt";
		String copy = "file/newcopy.txt";
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		//FileInputStream보다 전송 효율이 좋은
		//BufferedInputStream 사용
		try {
			bis = new BufferedInputStream(new FileInputStream(fileName));
			bos = new BufferedOutputStream(new FileOutputStream(copy));
			int data = 0;
			while((data = bis.read()) !=-1) {
				bos.write(data);

			}
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
				bos.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * file -> JVM 파일 입력
	 * JVM -> file 파일 출력
	 */
	public void test1() {
		FileInputStream fis = null; 
		FileOutputStream fos = null;
		//String fileName = "file/myfile.txt";
		String fileName = "C:\\Users\\jinha\\OneDrive\\main\\배경\\Novy_Urengoy,_Russia.jpg";
		//String copy = "file/copy.txt";
		String copy = "file/copy.jpg";
		try {
			fis = new FileInputStream(fileName);
			fos = new FileOutputStream(copy);
			//(0~255)256가지 + 1(값없음 -1) EOF
			//따라서 byte가 아닌 int data로 선언해준다.
			int data = 0;
			while((data = fis.read()) != -1) {
				System.out.println(data + " ");
				
				fos.write(data);
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				//자원반납은 선택이 아닌 필수
				fis.close();	
				fos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
