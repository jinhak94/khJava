package kh.java.type;
 /**
  * 자료형
  * 
  * 1. 기본형 Primitive Type
  * 	- 실제 데이터, 값(Literal)을 저장
  * 	- 크기가 각각 다른 8가지 타입(논리형, 문자형, 정수형, 실수형)
  * 
  * 2. 참조형 Reference Type
  * 	- 8가지 기본형을 제외한 나머지
  * 	- 주소값을 저장
  * 	- 4byte
  * 
  */
public class PrimitiveTypes {
	public static void main(String[] args) {
		PrimitiveTypes p = new PrimitiveTypes();
		//p.test1();
		//p.test2();
		//p.test3();
		//p.test4();
		p.test5();
		
	}
	
	/**
	 * Data Overflow
	 * 지정한 타입의 범위를 넘어선 값이 오게 되면, 최소값으로 다시 돌아간다.
	 */
	
	public void test5() {
		int iNum = Integer.MAX_VALUE;
		iNum = iNum + 1;
		System.out.println(iNum);
		iNum = Integer.MIN_VALUE;
		iNum = iNum - 1;
		System.out.println(iNum);
	}
	
	
	
	/**
	 * 상수 constant
	 * 한 번 값이 정해지면 변경 불가
	 * 
	 */
	
	public void test4() {
		//final int NUM = 100; // 상수는 값 다시 지정 불가, 명수명을 대문자로 사용한다.
		// NUM = 200;
		
		//final int AGE_LIMIT = 20; 
		// 상수 변수명은 대문자로 써서 단어 사이 구분을 일반 변수명과 다르게 _로 함.
		//int tomAge = 18;
		//int janeAge = 24;
		//boolean tomAllowed = tomAge > AGE_LIMIT;
		//boolean janeAllowed = janeAge > AGE_LIMIT;
		
		// jdk 표현 범위
		System.out.println("byte: " + Byte.MIN_VALUE + " ~ " + Byte.MAX_VALUE);
		System.out.println("short : " + Short.MIN_VALUE + " ~ " + Short.MAX_VALUE);
		System.out.println("int : " + Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
		System.out.println("long : " + Long.MIN_VALUE + " ~ " + Long.MAX_VALUE);
		
	}
	
	/**
	 * 초기화
	 * 변수의 선언과 값 대입을 동시에 하는 것
	 * 
	 */
	public void test3() {
		double dNum = 123.456;
		System.out.println("dNum = " + dNum);
		
		char last = '하';
		System.out.println("last = " + last);
		
	}
	
	public void test2() {
		// 같은 자료형은 한 줄에 동시 선언 가능 (비추) 
		// 한 줄에 하나씩 명확하게 선언하는 것을 추천
		//int a, b, c;
		int a;
		int b;
		int c;
		
		a = 10;
		b = 20;
		c = a + b;
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		
		boolean bool;
		bool = a < b;
		bool = a > b;
		bool = a >= b;
		bool = a <= b;
		bool = a == b;
		bool = a != b;
		bool = !true;
		bool = !false;
		bool = !(a == b);
		
		System.out.println("bool = " + bool);
	}
	
	public void test1() {
		// 1. 변수선언
		// 2. 변수 값대입
		// 3. 변수 사용(출력)
		byte bNum;
		short sNum;
		int iNum;
		long lNum;
		
		bNum = 100;
		bNum = -100;
		bNum = 50;
		//bNum = 200; // -128 ~ 127까지만 표현 가능
		
		// 정수는 기본적으로 int형으로 취급된다.
		// int범위를 넘어선 정수 리터럴은 L 접미어를 사용해서 Long 타입을 명시한다.
		sNum = 30000;
		iNum = 12345678;
		lNum = 1_000_000_000_000L; //long타입을 접미어 L, l로 명시
		
		System.out.println("bNum = " + bNum);
		System.out.println("sNum = " + sNum);
		System.out.println("iNum = " + iNum);
		System.out.println("lNum = " + lNum);
		
		// 실수 리터럴은 기본적으로 double로 취급된다.
		// f 또는 F 접미어로 float임을 명시한다.
		float fNum;
		fNum = 0.123F;
		fNum = 0.1234567891928F;
		
		double dNum;
		dNum = 0.1234567;
		dNum = 0.1309571305713003519;
		// 16번째까지만 정확하게 표시함.
		
		System.out.println("fNum = " + fNum);
		System.out.println("dNum = " + dNum);
		
		char ch = 'a';
		System.out.println("ch = " + ch);
		
		boolean bool;
		bool = true;
		System.out.println("bool = " + bool);
		
	}
	
	
	/**
	 * 1bit
	 * 
	 * 1byte : 8bit
	 * 1kbyte : 1024byte
	 * 1mb : 1024kb
	 * 1gb : 1024mb
	 * 1tb : 1024gb
	 * 1peta
	 * 1exa
	 * 1jeta
	 * 1yotta
	 * 
	 * 기본형의 종류
	 * 1. 문자형 
	 * 		char 2byte	0~65535 'a' '가' '馬' '3'
	 * 
	 * 2. 정수형 
	 * 		byte	1byte		-128 ~ 127
	 * 		short	2byte	-32768 ~ 32767
	 * 		int		4byte	-21억 ~ 21억
	 * 		long	8byte	-922경 ~ 922경
	 * 
	 * 3. 실수형
	 * 		float	4byte	
	 * 		double	8byte
	 * 
	 * 4. 논리형
	 * 		boolean 1byte		
	 * 
	 * 변수명명규칙
	 * 1. 대소문자구분
	 * 2. 길이제한없음
	 * 3. 자바예약어는 사용할 수 없다. name1 1name(x)
	 * 4. 숫자로 시작할 수 없다.
	 * 5. 특수문자는 _ &만 가능
	 * 
	 * 6. 여러 단어가 조합된 경우, 단어 첫 글자는 대문자로 시작
	 * 7. 한글사용가능하지만, 사용하지 말 것.
	 * 8. 직관적인 변수명을 사용하자.
	 */

}
