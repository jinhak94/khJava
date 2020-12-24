package kh.java.exception;

import java.util.Scanner;

public class AdultGame {
	public static void main(String[] args) {
		new AdultGame().start();
		
		System.out.println("--- 이용해 주셔서 감사합니다. ---");
	}
	
	public void start() {
		//1. 성인인증
		try{
			checkAge();
		}catch(UnderAgeException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		}
		
		//2. 게임 시작
		System.out.println("뚜루뜨루루루루..........");
	}
	//예외를 던져서 메인에서 할 수 있게 함.
	public void checkAge() throws UnderAgeException{
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		if(age < 20) 
			throw new UnderAgeException("나이가 미성년자입니다.");
	}
	
	public void start_() {
		//1. 성인인증
		boolean isAdult = checkAge_();
		if(!isAdult) {
			System.out.println("성인만 이용가능합니다.");
			return;
		}
		//2. 게임시작
		System.out.println("--- 게임을 시작합니다. ---");
	}
	
	
	
	public boolean checkAge_() {
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		return age>=20 ? true : false;
	}
}
