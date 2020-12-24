package com.exception.number;

import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		new Run().test();
	}
	public void test() {
		Scanner sc = new Scanner(System.in);
		NumberProcess np = new NumberProcess();
		System.out.print("1. 정수 입력 : ");
		int input1 = sc.nextInt();
		System.out.print("2. 정수 입력 : ");
		int input2 = sc.nextInt();
		
		try{
			boolean flag = np.checkDouble(input1, input2);
			if(flag) {
				System.out.printf("%d는 %d의 배수이다.%n",input1, input2);
			}else {
				System.out.printf("%d는 %d의 배수가 아니다.%n",input1, input2);
			}
		}catch(NumberRangeException e) {
			System.out.println("1부터 100 사이의 값이 아닙니다.");
			e.printStackTrace();
		}
		
		
	}
}
