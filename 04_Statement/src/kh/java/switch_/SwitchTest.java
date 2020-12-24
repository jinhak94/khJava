package kh.java.switch_;

import java.util.Scanner;

/**
 * if문 논리형에 따라 분기
 * switch 값에 따라 분기
 * @author jinha
 *
 */

public class SwitchTest {
	public static void main(String[] args) {
		SwitchTest s = new SwitchTest();
		//s.test1();
		//s.test2();
		//s.test3();
		s.test4();
	}

	/**
	 * @실습문제 : 수도세 계산 프로그램
	 * 
	 * 사용자에게 용도와 물 사용량을 받아 수도세를 계산할 것
	 * 	- 사용요금 : 용도별 가격 * 사용량
	 * 	- 수도세 : 사용요금의 5%
	 * 	- 총 납부금액 : 사용요금 + 수도세
	 * 
	 * 	- 용도별가격
	 * 	1. 가정용 : 50원/liter
	 * 	2. 상업용 : 45원/liter
	 * 	3. 공업용 : 30원/liter
	 *
	 *
	 *	상업용, 250liter 사용시 예
	 *
	 *	출력결과 :
	 *	--- 총 사용요금 ---
	 *	- 상업용을 사용하고 계십니다.
	 *	- 사용요금 : 11250원
	 *	- 수도세 : 562원
	 *	- 총납부금액 : 11812원
	 */
	public void test4() {
		Scanner sc = new Scanner(System.in);
		int wcase, use;
		System.out.print("용도를 입력하세요 : ");
		wcase = sc.nextInt();
		System.out.print("사용량을 입력하세요 : ");
		use = sc.nextInt();
		String str="";
		
		int charge = 0;
		double tax = 0;
		double tot;
		
		switch(wcase) {
		case 1: str = "가정용"; charge = 50*use; tax = charge*0.05; break;
		case 2: str = "상업용"; charge = 45*use; tax = charge*0.05; break;
		case 3: str = "공업용"; charge = 30*use; tax = charge*0.05; break;
		default: System.out.println("잘못 입력하셨습니다!");
		}
		tot = charge + tax;
		
		System.out.println("--- 총 사용요금 ---");
		System.out.println("- " + str + "을 사용하고 계십니다.");
		System.out.println("- 사용요금 : " + charge + "원");
		System.out.println("- 수도세 : " + (int)tax + "원");
		System.out.println("- 총납부금액 : " + (int)tot + "원");
		
	}
	
	/**
	 * @실습문제 : 사용자로부터 회원등급을 입력받습니다. (골드, 실버, 브론즈)
	 * 등급별로 선물을 부여하세요.
	 * 1. 골드 : 스마트TV, 전자렌지, 전기다리미
	 * 2. 실버 : 전자레인지, 전기다리미
	 * 3. 브론즈 : 전기다리미
	 */
	
	public void test3() {
		Scanner sc = new Scanner(System.in);
		int input;
		System.out.print("회원등급을 입력하세요 (골드 : 1, 실버 : 2, 브론즈 : 3) > ");
		String grade = "";
		String gift = "";
		
		input = sc.nextInt();
		
		// fall through 현상
		switch(input) {
		case 1 : grade = "골드"; gift = "스마트TV, ";
		case 2 : grade = "실버"; gift += "전자레인지, ";
		case 3 : grade = "브론즈"; gift += "전기다리미"; break;
		default : System.out.println("잘못 입력하셨습니다."); return;
		}
		System.out.printf("등급 : %s, 선물로 %s를 받으셨습니다!",grade, gift);
	}
	
	public void test2() {
		
		Scanner sc = new Scanner(System.in);
		String menu = "======================\n"
					+ "1. 순대국\n"
					+ "2. 김치찌개\n"
					+ "3. 순두부찌개\n"
					+ "-----------------------\n"
					+ "> ";
		System.out.print(menu);
		
		int choice = sc.nextInt();
		int price = 0;
		switch(choice) {
		case 1: price = 8000; break;
		case 2: price = 7000; break;
		case 3: price = 7000; break;
		default : System.out.println("잘못 입력하셨습니다."); return;
		}
		System.out.println("가격은 [" + price + "]원 입니다.");
	}
	
	
	/*
	 * 괄호안에는 byte, short, int, char, String, enum(열거형) 등이 올 수 있다.
	 * long, float, double 사용 불가
	 * String은 jdk 1.7부터 사용 가능
	 * 
	 *  switch(변수 | 계산식){
	 *  	case 값1:
	 *  		실행문1
	 *  	break;
	 *  	case 값2:
	 *  		실행문2
	 *  	break;
	 *  	default : 
	 *  		기몬 실행문 (모든 case에 해당되지 않는 경우)
	 *  }
	 */
	
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴를 선택하세요.");
		System.out.println("1. 사과 2.바나나 3. 오렌지");
		System.out.print("> ");
		
		int choice = sc.nextInt();
		String color = "";
		
		switch(choice) {
		case 1 : color = "빨간색"; break;
		case 2: color = "노란색"; break;
		case 3: color = "주황색"; break;
		default : System.out.println("잘못 입력하셨습니다."); return;
		}
		
		System.out.println("선택한 과일의 색상은 [" + color + "] 입니다.");
	}
}



