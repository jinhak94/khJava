package kh.java.byte_.system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SystemIOTest {
	public static void main(String[] args) {
		SystemIOTest s = new SystemIOTest();
		//s.test1();
		s.test2();
	}
	
	/**
	 * Scanner(jdk1.5) 이전에는 
	 * 	- System.in 1byte
	 *	- InputStreamReader    byte to char : 브릿지스트림
	 *	- Buffered	2byte : 라인단위로 처리가 가능한 readLine() 메소드 제공
	 *
	 * 주스트림 객체를 보조스트림 객체에 전달하고,
	 * 보조스트림 객체를 제어한다.
	 * 반납도 보조스트링만 반납하면, 주스트링도 함께 반납된다.
	 */
	
	public void test2() {
//		InputStreamReader isr = new InputStreamReader(System.in);
//		BufferedReader br = new BufferedReader(isr);
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));
		String line ="";
		
		//잃어온 값이 없다면 null을 리턴
		try{
			int sum = 0;
			while((line = br.readLine()) != null){
				if("quit".equals(line))
					break;
				System.out.print("입력값 : " + line);
				sum += Integer.parseInt(line);
			}
			System.out.println("총합 : " + sum);
		}catch(IOException e ){
			e.printStackTrace();
		}
			
	}
	
	
	/**
	 * System.in -> System의 클래스 변수 in
	 * System.out -> System의 클래스 변수 out
	 */
	private void test1() {
		//사용자의 키보드 입력 -> 입력버퍼 -> JVM
		//read 메소드는 입력값이 없다면 -1 리턴.
		//종료 단축키(윈도우 : Ctrl + c, 맥 : Ctrl + d
		//	, 이클립스 : Ctrl + z)사용시에도 -1 리턴
		int data = 0;
		try {
			Scanner sc = new Scanner(System.in);
			sc.next();
			//표준 입출력은 절대 닫지 말 것.
			
			//sc.close();
			while((data = System.in.read())!=-1){
				System.out.println(data);
				//한글은 utf-8에 의해 3바이트씩 처리가 된다.
				//a 입력 -> 97 : a,  13 : \r,  10 : \n
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//예외적으로 표준입출력은 닫지 않는다.
			//얘네 닫으면 그 애플리케이션 사용하는 동안 입출력을 쓸 수 없음.
				//System.in.close();
				System.out.close();
		}
	}
}
