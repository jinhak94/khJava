package com.kh.test.condition;

import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		Test3 t = new Test3();
		t.test();
	}
	
	public void test() {
		Scanner sc = new Scanner(System.in);
		double height;
		double weight;
		
		System.out.print("키(cm)를 입력하세요 : ");
		height = sc.nextDouble()/100;
		System.out.print("몸무게(kg)를 입력하세요 : ");
		weight = sc.nextDouble();
		
		double BMI = weight / (height * height);
		System.out.println(BMI);
		if(BMI >= 30) {
			System.out.println("고도비만");
		} else if (BMI >= 25 && BMI < 30) {
			System.out.println("비만");
		} else if (BMI >= 23 && BMI < 25) {
			System.out.println("과체중");
		} else if (BMI >= 18.5 && BMI < 23) {
			System.out.println("정상체중");
		} else if (BMI < 18.5){
			System.out.println("저체중");
		}
	}
}
