package kh.java.condition;

import java.util.Scanner;

public class IfTest {
	public static void main(String[] args) {
		IfTest f = new IfTest();
		//f.test1();
		//f.test2();
		//f.test3();
		//f.test4();
		f.test5();
	}
	
	/**
	 * @실습문제 : 두 수를 입력 받고, 그 중 큰 수와 작은 수를 차례로 출력하세요.
	 * 같다면 두 수는 같습니다. 하고 출력
	 */
	
	public void test5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 수를 입력하세요 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 수를 입력하세요 : ");
		int num2 = sc.nextInt();
		
		if(num1 > num2) {
			System.out.println("첫 번째 수 : " + num1);
			System.out.println("두 번째 수 : " + num2);
		} else if(num1 < num2) {
			System.out.println("두 번째 수 : " + num2);
			System.out.println("첫 번째 수: " + num1);
		} else {
			System.out.println("두 수는 같습니다.");
		}
	}
	
	public void test4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력해주세요 : ");
		int score = sc.nextInt();
		char grade = ' ';
		
		//유효성검사
		if(score >= 0 && score <= 100) {
			//정상입력
			if(score >= 90 && score <= 100) {
				grade = 'A';
			} 
			if(score >= 80 && score <= 89) {
				grade = 'B';
			} 
			if(score >= 70 && score <= 79) {
				grade = 'C';
			} 
			if(score >= 60 && score <= 69) {
				grade = 'D';
			} 
			if(score < 60){
				grade = 'F';
			}
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}
			
		System.out.printf("점수는 %d점이고, 학점은 %c입니다.",score,grade);
	}
	
	
	/**
	 * if...
	 * else if ...
	 * [else]
	 * 
	 * 여러 조건식을 직렬화한다.
	 * 참인 조건식의 if문이 실행된다.
	 * 
	 * if블럭 실행시 나머지 블럭을 건너뛰고, 전체 조건문을 빠져나간다.
	 *
	 * 90 ~ 100 : A
	 * 80 ~ 89 : B
	 * 70 ~ 79 : C
	 * 60 ~ 69 : D
	 * 60 미만 : F
	 *
	 */
	public void test3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력해주세요 : ");
		int score = sc.nextInt();
		char grade = ' ';
		
		if(score >= 90 && score <= 100) {
			grade = 'A';
		} else if(score >= 80 && score <= 89) {
			grade = 'B';
		} else if(score >= 70 && score <= 79) {
			grade = 'C';
		} else if(score >= 60 && score <= 69) {
			grade = 'D';
		} else {
			grade = 'F';
		}
		
		System.out.printf("점수는 %d점이고, 학점은 %c입니다.",score,grade);
	}
	
	public void test2() {
		int a = 6;
		if(a%2==1) {
			System.out.println("a는 홀수입니다.");
		} else {
			System.out.println("a는 짝수입니다.");
		}
		
		//@실습문제 : 사용자나이를 입력받고, 
		//20살 이상인 경우에만 성인인증되었습니다. 출력
		//20살 미만인 경우에는 성인인증에 실패했습니다. 출력
		int age;
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력해주세요 : ");
		age = sc.nextInt();
		if(age >= 20) {
			System.out.println("성인인증되었습니다.");
		} else {
			System.out.println("성인인증에 실패했습니다.");
		}
	}
	
	/**
	 * if
	 * 
	 * if절이 실행되지 않을수도 있다.
	 */
	public void test1() {
		int a = 10;
		//조건식 : 결과가 논리형
		if(a > 0) {
				System.out.println("a는 0보다 큽니다.");
		}
		System.out.println("--- 종료 ---");
		
	}
}
