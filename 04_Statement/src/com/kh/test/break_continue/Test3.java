package com.kh.test.break_continue;

import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		Test3 t = new Test3();
		t.test();
	}
	
	public void test() {
		Scanner sc = new Scanner(System.in);
		int input;
		// 해당 정수가 소수인지 판별할 boolean 변수 선언. 처음에 true로 지정해둠.
		boolean isPrime = true;
		// 소수 판별 여부를 위해서 index는 2부터 시작하게 
		int i = 2;
		
		while(true) {
			System.out.print("정수 하나를 입력하세요! (2 이상의 정수) : ");
			// 정수값을 입력 받음
			input = sc.nextInt();
			// 2보다 작은 값 입력 시에는 다시 입력받게..
			if(input < 2) {
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
				continue;
			// 2보다 큰 경우, while문 탈출
			} else {
				break;
			}
		}
		// 소수 판별하는 while문. 2부터 input 전까지(1과 input 자신은 input으로 나눠지기 때문에)
		// 1씩 증가하면서 input으로 나눴을 때 나머지가 0인지 여부 판별.
		// 나머지가 0이라는 얘기는 나눠지므로 소수가 아니라는 의미임.
		// 나눠지면 isPrime을 false로 변경
		while(i < input) {
			if((input%i)==0) {
				isPrime = false;
				break;
			}
			i++;
		}
		
		// 위에서 0으로 나눠지지 않은 경우에는 isPrime에 처음에 초기화한 true값이 그대로 존재해서 소수를 출력할 것이고,
		// 나눠진 경우에는 false에 의해 소수가 아니다를 출력함.
		if(isPrime) {
			System.out.printf("%d는 소수다..",input);
		} else {
			System.out.printf("%d는 소수가 아니다.",input);
		}
	}
}
