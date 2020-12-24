package com.kh.test.loop;

import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) {
		Test4 t = new Test4();
		t.test();
	}
	
	public void test() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 입력 : ");
		String inputStr = sc.next();
		int length = inputStr.length();
		
		System.out.print("검색할 문자 입력 : ");
		char inputCh = sc.next().charAt(0);
		if(!((inputCh>=65 && inputCh<=90) || (inputCh>=97 && inputCh<=122))) {
			System.out.println("영문자가 아닙니다.");
			return;
		}
			
		int tot = 0;
		
//		for(int i = 0; i < length; i++) {
//			if(inputCh==inputStr.charAt(i)) {
//				tot+=1;
//			}
//		}
		int i = 0;
		while(i < length) {
			if(inputCh==inputStr.charAt(i)) {
				tot+=1;
			}
			i++;
		}
		System.out.println("\'" + inputCh + "\'" + "가 포함된 갯수 : " + tot + "개");
	}
}
