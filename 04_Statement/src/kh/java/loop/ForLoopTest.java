package kh.java.loop;

import java.util.Scanner;

/**
 *	for
 * 
 *	while
 *
 *	do ~ while
 *
 */

public class ForLoopTest {
	public static void main(String[] args) {
		ForLoopTest f = new ForLoopTest();
		//f.test1();
		//f.test2();
		//f.test3();
		f.test4();
	}
	
	/**
	 * 블럭 스코프
	 */
	public void test4() {
		int sum = 0;
//=		for(int i = 0; i <= 10; i++) {
//			sum += i;
//		}
//		System.out.println(sum);

		//1부터 사용자가 입력한 양수까지의 합을 구하시오.
		int input;
		Scanner sc = new Scanner(System.in);
		System.out.print("값을 입력하세요 : ");
		input = sc.nextInt();
		for(int i = 0; i <= input; i++) {
			sum+=i;
		}
		System.out.println(sum);

	}
	
	/**
	 * 이름을 반복 출력해드립니다.
	 */
	public void test3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String name = sc.next();
		
		System.out.print("반복 횟수 : ");
		int num = sc.nextInt();
		
		for(int i = 0; i <num; i++) {
			System.out.println(i+1 + name);
		}
	}
	
	
	/**
	 * @실습문제 : 구구단 2단
	 * 
	 * 2 * 1 = 2
	 * 2 * 2 = 4
	 * ...
	 * 2 * 9 = 18
	 */
	
	public void test2() {
		int dan = 2;
		for(int i = 1; i < 10; i++) {
			System.out.println(dan + " * " + i + " = " + (dan*i));
		}
	}
	
	/**
	 * for(초기식; 조건식; 증감식){
	 * 		반복 실행할 구문
	 * }
	 * 초기식 : for문실행시 최초 1회만 실행
	 * 조건식 : 매턴마다 true, false 검사, true면 반복 구문 실행
	 * 증감식 : 매턴마다 증감변수의 처리를 담당
	 * 
	 * 처리순서
	 * 1. 초기식
	 * 2. 조건식
	 * 3. 반복구문 실행
	 * 4. 증감식
	 * 
	 * 5. 조건식
	 * 6. 반복구문 실행
	 * 7. 증감식
	 *
	 * 8. 조건식이 false이면 반복문 중지
	 * - 증감변수는 어떻게 변화하는가?
	 * 
	 */
	
	public void test1() {
//		for(int i = 0; i < 3; i++) {
//			System.out.println(i+1 +". Hello world~");
//		}
		
//		// 10 ~ 1
//		for(int i = 10; i >= 1; i--) {
//			System.out.println(i);
//		}

		// 1부터 20 사이의 홀수를 출력
//		for(int i=1; i<=20; i+=2) {
//			System.out.println(i);
//		}

		// 한 번 실패하면 for문 돌지 않으므로, if문으로 나눠서 해야함
//		for(int i = 1; i%2=1 && i <= 20; i+=1) {
//			System.out.println(i);
//		}
		
//		for(int i = 1; i <= 20 ; i+=1) {
//			if(i%2!=0) {
//				System.out.println(i);
//			}
//		}
		
		
//		
//		for(i=20; i > 0; i-=2) {
//			System.out.println(i);
//		}
	}
}
