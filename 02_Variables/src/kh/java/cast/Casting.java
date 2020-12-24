package kh.java.cast;

/**
 * 컴퓨터의 작동원리
 * 
 * 1. 같은 자료형 사이에서 연산할 수 있다.
 * 2. 리터럴은 같은 자료형의 변수에만 대입할 수 있다.
 * 3. 같은 자료형의 연산결과는 동일한 자료형이다.
 *
 */

public class Casting {
	public static void main(String[] args) {
		//Casting c = new Casting();
		//c.test1();
		//c.test2();
		//c.test3();
		//c.test4();
	}
	
	public void test4() {
		System.out.println('A' + 1);
		// 'A'가 int로 변환. 65이므로 66 출력
		System.out.println('0' + 1);
		// '0'이 int로 변환. 48이므로 49이 출력
		System.out.println(99);//알파벳 c가 출력되려면?
		// System.out.println(char(99));
		//System.out.println(2.0 == (5 / 2));
		// 5/2는 2가 됨. int가 double로 형변환이 일어나고, true
		//System.out.println('C' == 67);
		// 'C'는 67이므로 true (C가 int로 변환됨)
		//System.out.println('A' == 'B' - 1);
		// 'B'-1 연산에 의해 int로 형변환이 일어나서 65가 된다. 'A' == 65이므로 true (A가 int로 변환됨)
		//System.out.println('a' != 97);
		// 'a'가 int로 형변환이 되고, 97이므로 false이다.
	}
	
	/**
	 * int보다 작은 타입 연산 시 주의사항
	 * byte, short, char 타입은 오칙연산(+ - * / %)의 피연산자로 사용되면
	 * int로 자동 형변환되어 사용된다.
	 * 
	 */
	
	public void test3() {
		byte b1 = 100;
		byte b2 = 10;
		//byte result = b1 + b2;
		byte result = (byte)(b1 + b2);
		System.out.println(result);
		
		char a = 97;
		System.out.println(a);
	}
	
	/**
	 * 2. 명시적 형변환
	 * 	- 데이터 손실이 있을 수 있으므로 주의해서 사용
	 */
	
	public void test2() {
		
		//1. 작은 타입으로 변환 (데이터손실 있음)
		int num = (int)3.7;
		System.out.println(num);
		
		num = 290;
		byte b = (byte)num;
		System.out.println(b);
		//-> 0001 0010 0010 에서 0001을 날려버림
		
		//2. 큰 타입으로 변환 (데이터 손실 없음)
		int k = 10;
		int m = 4;
		System.out.println((double)k / m);
		
		int i = Integer.MAX_VALUE;
		System.out.println((long)i + 1);
		System.out.println(i + 1L);
		
	}
	
	/**
	 * 1. 암묵적 형변환(자동 형변환)
	 * 		- 데이터 손실이 없는 경우
	 * 		- 승격
	 * 		- byte(1) -> short(2) -> int(4) -> long(8) -> float(4) -> double(8)
	 * 				  -> char(2)
	 * 
	 */
	public void test1() {
		
		//1. 자료형이 다른 값의 연산
		int a = 3;
		double b = 2.7;
		System.out.println(a+b);
		
		//2. 리터럴이 다른 자료형에 대입될 때
		int c = 5;
		float d = c;
		System.out.println(d);
		
		char e = 'e';
		int f = e;
		System.out.println(f);
		
		System.out.println('B'+100);
		
		//3. 연산결과는 동일한 자료형
		int k = 10;
		int m = 3;
		float n = 3;
		System.out.println(k / m);
		System.out.println(k / n);
	
	}
}
