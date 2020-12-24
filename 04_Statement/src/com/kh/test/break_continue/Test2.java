package com.kh.test.break_continue;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Test2 t = new Test2();
		t.test();
	}
	
	public void test() {
		Scanner sc = new Scanner(System.in);
		
		// 난수 생성
		int rand = (int)(Math.random()*50)+1;
		// 정답 맞추기를 시도한 횟수를 저장할 count 변수 초기화
		int count = 0;
		//System.out.println(rand);
		
		while(true) {
			System.out.print("정수 한 개를 입력하세요 : ");
			// 사용자로부터 정수값을 입력 받음
			int input = sc.nextInt();
			// 시도 횟수 증가
			count++;
			
			// 난수가 정수값보다 크면, 큽니다 출력하고, continue 구문으로 이후 문장들 생략 후 while문 재실행
			if(rand>input) {
				System.out.println("입력하신 정수보다 큽니다");
				continue;
			// 난수가 정수값보다 작으면, 큽니다 출력하고, continue 구문으로 이후 문장들 생략 후 while문 재실행
			} else if(rand<input) {
				System.out.println("입력하신 정수보다 작습니다.");
				continue;
			// 난수와 정수값 같으면 정답입니다 출력하고, count 변수(시도 횟수) 출력
			} else if(rand==input){
				System.out.println("정답입니다." + count + "회 만에 정답을 맞추셨습니다.");
				break;
			}
			
		}
		
	}
}


