package kh.java.test.array;

import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		Test3 t = new Test3();
		t.test();
	}
	
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력값 : ");
		String str = sc.next();
		char[] arr = new char[str.length()];
		arr = str.toCharArray();
		int count = 0;
		System.out.print("검색값 : ");
		char cmp = sc.next().charAt(0);
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == cmp) {
				count++;
			}
		}
		
		System.out.printf("출력 : 입력하신 문자열 %s에서 찾으시는 문자 %c는 %d개입니다.", str, cmp, count);
	}
}