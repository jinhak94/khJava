package com.kh.test.loop;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Test2 t = new Test2();
		t.test();
	}
	
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.print("한 개의 정수를 입력하세요 : ");
		int input = sc.nextInt();
		
//		for(int i = 1; i <= input; i++) {
//			if((i%2)==0){
//				System.out.print("박");
//			} else
//				System.out.print("수");
//		}
//		
		int i = 1;
		while(i <= input) {
			if((i%2)==0){
				System.out.print("박");
			} else
				System.out.print("수");			
			i++;
		}
		
	}
}
