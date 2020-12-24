package com.kh.test.break_continue;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Test1 t = new Test1();
		//t.test1();
		t.test2();
	}
	
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 하나를 입력하세요 : ");
		int input = sc.nextInt();
		int i = 1;
		int tot = 1;
		while(i <= input) {
			if((i%2)==1) {
				tot *= i;
			}
			i++;
		}
		System.out.println("결과는 " + tot + "입니다.");
	}
	
	public void test2() {
		Scanner sc = new Scanner(System.in);
		int input1, input2; // 입력받을 값 1,2
		System.out.print("첫 번째 수를 입력하세요 ! : ");
		input1 = sc.nextInt();
		System.out.print("두 번째 수를 입력하세요 ! : ");
		input2 = sc.nextInt();
		
		// 입력 받을 값의 대소비교를 위해 선언한 변수 big, small
		int big = 0;
		int small = 0, small1 = 0;	
		// while문을 돌 때 small를 index로 하면 small++;에서 입력받은 small 값의 변형이 일어나므로 
		// small1을 선언하고 small의 값을 대입해서 small1을 index로 지정해줌.
		int sum = 0;	// 홀수의 합계를 저장할 sum 변수
		
		// 대수 비교 로직 input1이 input2보다 크면 input1을 big으로 지정
		// small1 = small = input2 의미는 input2 값을 small에, small 값을 small1에 대입한다는 의미
		if(input1 > input2) {
			big = input1;
			small1 = small = input2;
		} else if(input1 < input2) {
			big = input2;
			small1 = small = input1;
		} else {
			// input1과 input2가 같으면, input1 홀수 여부만 확인하고 sum에 더해줌
			if((input1%2)==1)
				sum += input1;
		}
		
		// big과 small 사이에 있는 홀수들의 합계를 더하는 로직
		while(big > small1) {
			if((small1%2)==1) {
				sum += small1;
			}
			small1++;
		}
		
		System.out.printf("%d부터 %d까지의 홀수의 합은 %d입니다.", small, big, sum);
	}
}
