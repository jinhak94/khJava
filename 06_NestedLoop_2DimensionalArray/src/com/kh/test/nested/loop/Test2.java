package com.kh.test.nested.loop;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Test2 t = new Test2();
		t.test();
	}
	
	public void test() {
		Scanner sc = new Scanner(System.in);
		
		int input;
		
		for(;;) {
			System.out.print("양수 입력 : ");
			input = sc.nextInt();
			if(input > 0)
				break;
			System.out.println("양수가 아닙니다. 다시 입력하세요!");
		}

		for(int i = 0; i < input; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = 0; i < input-1; i++) {
			for(int j = 0; j < input; j++) {
				if(j <= i) {
					System.out.print(" ");
				}else 
					System.out.print("*");
			}
			System.out.println();
			
		}
	}
}
