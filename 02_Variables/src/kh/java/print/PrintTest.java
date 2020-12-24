package kh.java.print;

public class PrintTest {
	
	public static void main(String[] args) {
		PrintTest p = new PrintTest();
		//p.test1();
		p.test2();
	}
	
	/**
	 * 너비 / 정렬 지정하기
	 * %[flag][width]형식문자
	 *  %-10d  ->  10byte의 공간에 좌측정렬
	 *  %10d   ->  10byte의 공간에 우측정렬
	 * 
	 */
	
	public void test2() {
		int i = 12345;
		
		System.out.printf("[%10d]%n", i);
		System.out.printf("[%-10d]%n", i);
	}
	
	/**
	 * 
	 * System.out.printf(형식문자열, 값1, 값2, ...);
	 * 
	 * 데이터타입별 형식문자를 이용해서 값을 출력하는 메소드
	 * 
	 */

	public void test1() {
		boolean bool = true;
		System.out.printf("bool = %b", bool);
		
		char ch = '헐';
		System.out.printf("ch = %c", ch);
	
		//%d : decimal
		int iNum = 100;
		long lNum = 999;
		System.out.printf("iNum = %d, lNum = %d", iNum, lNum);
		
		//%f : float
		float fNum = 123.456f;
		double dNum = 123.4567890;
		System.out.printf("fNum = %f, dNum = %f", fNum, dNum);
		
		//%s : 문자열
		String name = "홍길동";
		System.out.printf("name = %s%n", name);		
	}
	
}

