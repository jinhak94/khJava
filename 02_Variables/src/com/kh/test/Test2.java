package com.kh.test;

public class Test2 {
	String name = "김진하";
	byte age = 27;
	char gender = '남';
	String address = "인천 미추홀구";
	String number = "01012344321";
	String email = "jinhak@gmail.com";
	
	public static void main(String[] args) {
		Test2 t = new Test2();
		t.test2();
	}
	
	public void test2() {
		
		System.out.printf("=======================================================================\n");
		System.out.printf("이름\t나이\t성별\t전화번호\t\t이메일\t\t\t주소\n");
		System.out.printf("=======================================================================\n");
		System.out.printf("%s\t%d\t%c\t%s\t%s\t%s\n",name, age, gender, number, email, address);
		name = "홍길동";
		age = 22;
		char gender = '여';
		String address = "경기도 광주시";
		String number = "01012341234";
		String email = "hgs@gmail.com";
		System.out.printf("%s\t%d\t%c\t%s\t%s\t\t%s\n",name, age, gender, number, email, address);
	}
}
