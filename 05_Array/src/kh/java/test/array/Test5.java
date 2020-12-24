package kh.java.test.array;

import java.util.Scanner;

public class Test5 {
	public static void main(String[] args) {
		Test5 t = new Test5();
		t.test();
	}
	
	public void test() {
		Scanner sc = new Scanner(System.in);
		char[] arr1 = new char[13];
		System.out.print("주민등록번호 13자리를 - 빼고 입력하세요 : ");
		arr1 = sc.next().toCharArray();
		
		char[] arr2 = arr1.clone();
		for(int i = 7; i < 13; i++) {
			arr2[i] = '*';
		}
		
		for(int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i]);
		}
	}
}
