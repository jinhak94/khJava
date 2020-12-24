package kh.java.test.array;

import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) {
		Test4 t = new Test4();
		//t.test();
		t.test2();
	}
	
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.print("전화번호 11자리를 - 빼고 입력하세요 : ");
		String phoneNum = sc.next();
		char[] arr1 = new char[11];
		arr1 = phoneNum.toCharArray();
		
		char[] arr2 = arr1.clone();
		for(int i = 3; i < 7; i++) {
			arr2[i] = '*';
		}
		for(int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i]);
		}
	}
	
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("전화번호 11자리를 - 빼고 입력하세요 : ");
		String phoneNum = sc.next();
		phoneNum = phoneNum.substring(0,3) + "****" + phoneNum.substring(7, 11);
		System.out.println(phoneNum);
	}
}
