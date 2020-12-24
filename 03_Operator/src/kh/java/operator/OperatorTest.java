package kh.java.operator;

import java.util.Scanner;

public class OperatorTest {
	public static void main(String[] args) {
		OperatorTest ot = new OperatorTest();
		//ot.test1();
		//ot.test2();
		//ot.test3();
		//ot.test4();
		ot.test5();
	}
	
	/**
	 * 복합대입연산자
	 */
	public void test5() {
		int x = 15;
		x += 15;
		System.out.println(x);	// 30
		
		x -= 15;
		System.out.println(x);	// 15
		
		x *= 3;
		System.out.println(x);	// 45
		
		x /= 2;
		System.out.println(x);	// 22
		
		x %= 10;
		System.out.println(x);	// 2
	}
	
	/**
	 * 삼항 연산자
	 * (조건식)?(true일 때 값):(false일 때 값)
	 * 
	 */
	public void test4() {
		int num = 50;
		String str = num > 50 ? "안녕" : "잘가";
		System.out.println(str);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		num = sc.nextInt();
		str = (num%2==1) ? "홀수" : "짝수";
		System.out.println(str);
	
		int a = 5;
		int b = 7;
		int c = a > b ? a : (a==b? 0 : b);
		System.out.println(c);
	}
	
	/**
	 * 논리비교연산자
	 * -  a && b  (and)
	 * 
	 * -  a || b  (or)
	 * 
	 */
	public void test3() {
		
		int m = 50;
		int n = 100;
		System.out.println(m < n && m * 2 == n); // t && t = t
		System.out.println(m < n && m * 3 == n); // t && f = f
		System.out.println(m < n || m * 3 == n); // t && f = t
		
		System.out.println("--------------------------------");
		System.out.println(true && true);
		System.out.println(true && false);
		System.out.println(false && true);
		System.out.println(false && false);
		System.out.println("--------------------------------");
		System.out.println(true || true);
		System.out.println(true || false);
		System.out.println(false || true);
		System.out.println(false || false);
		
		System.out.println("--------------------------------");
		
		int a = 1;
		int b = 1;
		// && 좌항이 true일 때
//		System.out.println(a>0 && ++b > 0);
		// && 좌항이 false일 때
		System.out.println(a<0 && ++b > 0);
		// || 좌항이 true일 때
		System.out.println(a > 0 || ++b > 0);
		System.out.printf("a = %d, b = %d%n", a, b);
		
		// || 좌항이 false일 때
		System.out.println(a < 0 || ++b > 0);
		System.out.printf("a = %d, b = %d%n", a, b);

		// 중요한 점.. && 연산자 사용 시 좌항이 거짓인 경우, 우항에 대한 검사를 실행하지 않음.
		// 반대로 || 연산자 사용 시 좌항이 참인 경우, 우항에 대한 검사를 실행하지 않음.
	}
	
	/**
	 * 이항연산자
	 */
	public void test2() {
		int a = 3;
		int b = 50;
		int c = 11;
		
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b); // asterisk
		System.out.println(b / c); // 몫
		System.out.println(b % c); // 나머지 연산자
		
		//짝홀구분 : 2로 나눈 나머지가 0이면 짝수, 아니면 홀수입니다.
		System.out.println(10 % 2 == 0);	//짝수
		System.out.println(3 % 2 == 0);		//홀수
		
		//비교연산
		System.out.println(a == b);	// false
		System.out.println(a != b);	// true
		
		System.out.println(a > b); 	// greater than (gt)
		System.out.println(a < b);	// less than (lt)
		System.out.println(a >= b);	// greater than or equal to (ge)
		System.out.println(a <= b); // less than or equal to (le)
		
	}
	
	/**
	 * 단항연산자
	 */
	public void test1() {
		int a = +10;
		int b = -33;
		System.out.println(a+b);
	
		//증감연산자
		int c = 7;
		
		//해당 변수값을 1 증가/감소 시킨 후에 다시 대입한다.
		c++;	// c = c+1;
		c--;	// c = c-1;
		
		System.out.println(c);
	
		//1. 전위증감연산자 ++c : 먼저 1 증감 후에 인접 연산 처리
		//2. 후위증감연산자 c-- : 인접연산 처리 후에 1 증감
		
		int d = 3;
		int k = d--;
		System.out.println("d = " + d);
		System.out.println("k = " + k);
		
		
		int m = 10;
		int n = 20;
		System.out.println(m++ + 20); // 30
		
		System.out.println("m = " + m); // m = 11
		System.out.println("n = " + n); // n = 20
		
		
		//@실습문제
		int x = 10;
		int y = 10;
		int z = ++x;	
		System.out.println("z = " + z);	// z = 11
		System.out.println("x = " + x); // x = 11
		
		z = y++;
		System.out.println("z = " + z); // z = 10
		System.out.println("y = " + y); // y = 11
		
		x = 20;
		z = x++ + --y;
		System.out.println("x = " + x); // x = 21
		System.out.println("y = " + y); // y = 10
		System.out.println("z = " + z); // z = 30
		
		int num = 20;
		int result = num++ + num;
		System.out.println("num = " + num); // num = 21
		System.out.println("result = " + result); // result = 41
		
		// 논리부정 연산자 !
		boolean bool = true;
		bool = !bool;
		System.out.println("bool = " + bool);
				
	}
}









