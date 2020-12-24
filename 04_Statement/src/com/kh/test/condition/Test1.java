package com.kh.test.condition;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Test1 t = new Test1();
		t.test();
	}
	
	public void test() {
		Scanner sc = new Scanner(System.in);
		char op = ' ';
		int num1;
		int num2;
		System.out.print("첫 번째 숫자를 입력해주세요 : ");
		num1 = sc.nextInt();
		System.out.print("두 번째 숫자를 입력해주세요 : ");		
		num2 = sc.nextInt();
		System.out.print("연산자를 입력해주세요 : ");		
		op = sc.next().charAt(0);
		
		if(op == '+') {
			System.out.printf("%d+%d=%d",num1,num2,num1+num2);
		} else if(op == '-') {
			System.out.printf("%d-%d=%d",num1,num2,num1-num2);
		} else if(op == '*') {
			System.out.printf("%d*%d=%d",num1,num2,num1*num2);
		} else if(op == '/'){
			System.out.printf("%d/%d=%d",num1,num2,num1/num2);
		} else {
			System.out.println("잘못 입력 하셨습니다. 프로그램을 종료합니다.");
		}
	}
}
