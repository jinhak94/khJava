package com.kh.test.condition;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Test2 t = new Test2();
		t.test();
	}
	
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1부터 10 사이의 정수를 하나 입력하세요! : ");
		int num = sc.nextInt();
		
		if(num>=1 && num<=10) {
			if((num%2)==0) {
				System.out.println("짝수다");
			} else {
				System.out.println("홀수다");
			}
		} else {
			System.out.println("반드시 1~10사이의 정수를 입력해야 합니다.");
		}
	}
}
