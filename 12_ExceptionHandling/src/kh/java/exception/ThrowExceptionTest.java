package kh.java.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * 
 * 1. try~catch 예외 직접 처리
 * 2. throws 절을 메소드시그니쳐에 명시해서 
 *    예외처리를 호출부로 넘김
 *
 */

public class ThrowExceptionTest {
	//public static void main(String[] args) throws FileNotFoundException{
	//이런 식으로 메인에서도 예외를 던질 수 있는데, 이 경우 JVM에 던지게 됨
	//따라서 비정상 종료로 끝나게 된다. 절대 좋지 않은 코드
	public static void main(String[] args) {
		ThrowExceptionTest t = new ThrowExceptionTest();
		try{
			t.start();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	
		System.out.println("프로그램 정상 종료!");
	}

	/**
	 * 던져진 예외는 흐름을 제어할 수 있는 메소드에서 예외처리해야한다
	 * 예를 들어, a에서 파일을 검사하는데, 파일이 없으면 파일을 만들어주는 b를 호출해야 한다면,
	 * a에서 try catch문을 사용해야 한다. -> 흐름을 분기할 수 있는 곳에서 수행.
	 */
	
	public void start() throws FileNotFoundException{
		System.out.println("<start>");
		String fileName = "test.txt";

		try {
			a(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try{
//			a(fileName);
//		}catch(FileNotFoundException e) {
//			e.printStackTrace();
//		}
	}

	/**
	 * throws 절은 메소드 또는 생성자에 작성
	 *  - 다형성 적용 가능 FileNotFoundExcetion -> IOException -> Exception
	 *  - 던지는 예외클래스 개수 제한 없음.
	 *  
	 */
	
	public void a(String fileName) throws FileNotFoundException, Exception{
		//1. 직접 처리
//		try{
//			FileReader fr = new FileReader(fileName);
//		}catch(FileNotFoundException e) {
//			e.printStackTrace();
//		}
		System.out.println("<a>");
		//2. 호출부로 예외처리 넘기기
		
		try{
			FileReader fr = new FileReader(fileName);
		}catch(FileNotFoundException e) {
			// 우선 예외처리후 사용자 정의 예외객체로 바꾸어서 던지기
			// cause는 최초 발생한 예외를 추가해서 던짐.
			System.out.println("파일을 생성합니다.");
			b(fileName);
			throw new TestFileNotFoundException("기본파일명 : " + fileName, e);
		}
	}
	public void b(String fileName) {
		System.out.println("<b>");
	}
}
