package com.exception.charcheck;

import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		new Run().test1();
	}
	
	public void test1()	{
		Scanner sc = new Scanner(System.in);
		String input = "";
		CharacterProcess cp = new CharacterProcess();
		System.out.print("문자열을 입력하세요! : ");
		try{
			input = sc.nextLine();
			int length = cp.countAlpha(input);
			System.out.println("문자열의 길이는 "+length+"입니다.");
		}catch (CharCheckException e) {
			System.out.println("체크할 문자열 안에 공백 포함할 수 없습니다.");
			e.printStackTrace();
		}
	}
}
