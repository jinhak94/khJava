package com.kh.test.loop;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Test1 t = new Test1();
		t.test();
	}
	
	public void test() {
		Scanner sc = new Scanner(System.in);
		int input;
		System.out.print("한 개의 정수를 입력하세요 : ");
		input = sc.nextInt();
		int sum = 0;
		
//		for(int i = 1; i <= input; i++) {
//			if((i%2)==0) {
//				sum += i;
//			}
//		}
		int i = 1;
		while(i <= input) {
			if((i%2)==0)
				sum+=i;
			i++;
		}
		System.out.println("합은 " + sum + "입니다.");
	}
}
