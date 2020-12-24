package com.kh.function.run;

import java.util.Scanner;

public class Example {
	
	public void opSample0() {
		int a = 20;
		int b = 30;
		String str;
		
		str = ((a >= 10 && a <= 30) || (b >=20 && b >=25)) ? "참" : "거짓";
		
		System.out.println(str);
		
		int c = 20;
		int d = c++ + --a * b++;
		System.out.println(d);
	}
	
	public void opSample1() {
		Scanner sc = new Scanner(System.in);
		int kor;
		int eng;
		int math;
		int tot;
		int avg;
		String result;
		
		System.out.println("문제 1번 시작");
		
		System.out.print("국어 점수를 입력하세요 : ");
		kor = sc.nextInt();

		System.out.print("영어 점수를 입력하세요 : ");
		eng = sc.nextInt();

		System.out.print("수학 점수를 입력하세요 : ");
		math = sc.nextInt();
		
		tot = kor + eng + math;
		avg = tot / 3;
	
		result = kor>=40&&eng>=40&&math>=40&&avg>=60 ? "합격" : "불합격";
		System.out.println(result);
	}

	public void opSample2() {
		Scanner sc = new Scanner(System.in);
		String name;
		int grade;
		int cls;
		int number;
		char gender;
		String gd;
		double jumsu;
		
		System.out.println("문제 2번 시작");
		
		System.out.print("학생 이름을 입력하세요 : ");
		name = sc.next();
		
		System.out.print("학년을 입력하세요 : ");
		grade = sc.nextInt();
		
		System.out.print("반을 입력하세요 : ");
		cls = sc.nextInt();
		
		System.out.print("번호를 입력하세요 : ");
		number = sc.nextInt();
		
		System.out.print("성별을 입력하세요 : ");
		gender = sc.next().charAt(0);
		gd = (gender=='M') ? "남학생" : "여학생";
		
		System.out.print("성적을 입력하세요 : ");
		jumsu = sc.nextDouble();
		
		System.out.printf("%d학년 %d반 %d번 %s %s은 성적이 %.2f이다.",grade, cls, number, gd, name, jumsu);
	}
	
	public void opSample3() {
		Scanner sc = new Scanner(System.in);
		int iNum;
		String str;
		
		System.out.print("양수를 하나 입력하세요! : ");
		iNum = sc.nextInt();
		str = (iNum%2)==0 ? "양수다" : "양수가 아니다";
		System.out.println(str);
	}
}




