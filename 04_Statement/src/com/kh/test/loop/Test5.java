package com.kh.test.loop;

import java.util.Scanner;

public class Test5 {
	public static void main(String[] args) {
		Test5 t = new Test5();
		t.test();
	}
	
	public void test() {
		Scanner sc = new Scanner(System.in);
		// 각 변수 선언.
		String name;
		int age;
		String address;
		int height;
		int weight;
		String phoneNum;
		
		// 평균을 계산하기 위한 변수 선언
		int sAge = 0;
		int sHeight = 0;
		int sWeight = 0;
		
		String result = "";
		
		int i = 1;
		// 3명을 입력 받기 위한 while문
		while(i <= 3) {
			// 입력 받는 과정
			System.out.print("이름을 입력하세요 : ");
			name = sc.next();
			System.out.print("나이를 입력하세요 : ");
			age = sc.nextInt();
			// nextInt() 다음에 nextLine()이 나오므로 
			// nextLine()을 사이에 하나 써줘서 버퍼를 비운다.
			sc.nextLine();
			System.out.print("주소를 입력하세요 : ");
			address = sc.nextLine();
			System.out.print("키를 입력하세요 : ");
			height = sc.nextInt();
			System.out.print("몸무게을 입력하세요 : ");
			weight = sc.nextInt();
			System.out.print("핸드폰 번호를 입력하세요 : ");
			phoneNum = sc.next();
			
			// 입력 받은 값을 출력할 문자열 변수에 저장
			result += i + " " + name + " " + age + "세 " + address + " " + height + "cm " + weight + "kg " + phoneNum + "\n";
			
			// 입력 받은 값들을 값들을 더해줌
			sAge += age;
			sHeight += height;
			sWeight+= weight;
			i++;
		}
		
		
		// 나이, 키, 몸무게의 평균 값을 출력
		System.out.println("========== 저장회원 ==========");
		System.out.print(result);
		System.out.println("===========================");
		System.out.printf("평균나이 %d세 / 평균 키 : %dCM / 평균 몸무게 : %dkg", sAge/3, sHeight/3, sWeight/3);
		
	}
}