package com.kh.test.loop;

import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		Test3 t = new Test3();
		t.test();
	}
	
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.print("한 개의 정수를 입력하세요 : ");
		int input = sc.nextInt();
		
		if(input<=0 || input>=10) {
			System.out.println("잘못입력하셨습니다. 프로그램종료합니다.");
			return;
		}
//		for(int i = 1; i < 10; i++) {
//			System.out.println(input + "X" + i + "=" + (input*i));
//		}
		int i = 1;
		while(i < 10) {
			System.out.println(input + "X" + i + "=" + (input*i));
			i++;
		}
	}
}
