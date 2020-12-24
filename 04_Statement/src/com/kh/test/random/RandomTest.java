package com.kh.test.random;

import java.util.Scanner;

public class RandomTest {
	public static void main(String[] args) {
		RandomTest r = new RandomTest();
		r.test1();
		//r.test2();
	}

	public void test1() {
		double rand;
		int num;
		System.out.print("0 ~ 9까지의 랜덤 수 : ");
		rand = Math.random()*10;
		num = (int)rand;
		System.out.println(num);
		
		System.out.print("1 ~ 10까지의 랜덤 수 : ");
		rand = Math.random()*10+1;
		num = (int)rand;
		System.out.println(num);
		
		System.out.print("20 ~ 35까지의 랜덤 수 : ");
		rand = Math.random()*16+20;
		num = (int)rand;
		System.out.println(num);
		
		System.out.print("0 또는 1 : ");
		rand = Math.random()*2;
		num = (int)rand;
		System.out.println(num);
		
		
	}

	public void test2() {
		Scanner sc = new Scanner(System.in);
		double rand = Math.random()*3+1;
		int num = (int)rand;
		System.out.println("=== 가위 바위 보 게임 ===");
		System.out.print("숫자를 선택하세요(1.가위 / 2.바위 / 3.보) : ");
		int input = sc.nextInt();
		System.out.println("======== 결과 ========");
		
		String person = (input == 1) ? "가위" : (input == 2) ? "바위" : "보";
		String computer = (num == 1) ? "가위" : (num == 2) ? "바위" : "보";
		
		System.out.printf("당신은 %s를 냈습니다.%n", person);
		System.out.printf("컴퓨터는 %s를 냈습니다.%n", computer);
		
		System.out.println("====================");
		if((input==1 && num==3) || (input==2 && num==1) || (input==3 && num==2)) {
			System.out.println("당신이 이겼습니다. ㅠ.ㅠ");
		}else if((input==1 && num==2) || (input==2 && num==3) || (input==3 && num==1)) {
			System.out.println("당신이 졌습니다. ㅠ.ㅠ");
		}
		else {
			System.out.println("당신은 비겼습니다. ㅠ.ㅠ");
		}
//		else if((input==1 && num==1) || (input==2 && num==2) || (input==3 && num==3)){
//			System.out.println("당신은 비겼습니다. ㅠ.ㅠ");
//		}
	}
}


