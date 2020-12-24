package com.kh.test.loop;

import java.util.Scanner;

public class Test6 {
	public static void main(String[] args) {
		Test6 t = new Test6();
		t.test();
	}
	
	public void test() {
		Scanner sc = new Scanner(System.in);
		
		// 입력한 메뉴를 저장하기 위한 변수
		int menu;
		// 입력한 수량을 저장하기 위한 변수
		int su;
		// 추가 구매 여부를 나타내는 yn
		char yn;
		
		// 가격의 합계를 계산하기 위한 sum 변수 초기화
		int sum = 0;
		
		// 메뉴의 이름을 저장하기 위한 menuName 변수 선언
		String menuName;
		// 메뉴의 가격을 저장하기 위한 price 변수 선언
		int price;
		
		// 사용자가 선택한 정보들을 이어서 저장하기 위한 result 변수 초기화
		String result = "";
		// 출력용 String 변수
		String str = "----------------------------------";
		
		while(true) {
		// 메뉴 출력
			System.out.println("메뉴");
			System.out.println("김밥류 =====================");
			System.out.println("1. 원조김밥==========1500원");
			System.out.println("2. 치즈김밥==========2000원");
			System.out.println("3. 참치김밥==========2300원");
			System.out.println("라면류 =====================");
			System.out.println("4. 그냥라면==========3000원");
			System.out.println("5. 치즈라면==========3500원");
			System.out.println("6. 짬뽕라면==========4000원");
			System.out.println("분식류 =====================");
			System.out.println("7. 떡볶이===========2500원");
			System.out.println("8. 순대============2500원");
			System.out.println("9. 오뎅============1000원");
			System.out.println("기타 =======================");
			System.out.println("10. 음료수===========1000원");
		
		// 메뉴 입력 받는 부분
			System.out.print("메뉴를 선택하세요! : ");
			menu = sc.nextInt();
			System.out.print("수량을 입력하세요! : ");
			su = sc.nextInt();
		// 사용자가 입력한 메뉴 번호에 따라 switch문 분기 처리
			switch(menu) {
			case 1: menuName = "원조김밥"; price = 1500 * su; break;
			case 2: menuName = "치즈김밥"; price = 2000 * su; break;
			case 3: menuName = "참치김밥"; price = 2300 * su; break;
			case 4: menuName = "그냥라면"; price = 3000 * su; break;
			case 5: menuName = "치즈라면"; price = 3500 * su; break;
			case 6: menuName = "짬뽕라면"; price = 4000 * su; break;
			case 7: menuName = "떡볶이"; price = 2500 * su; break;
			case 8: menuName = "순대"; price = 2500 * su; break;
			case 9: menuName = "오뎅"; price = 1000 * su; break;
			case 10: menuName = "음료수"; price = 1000 * su; break;
			
		// 이상한 값 입력한 경우 다시 입력 받도록 수행 continue를 사용해서 이후 명령들 무시하게 수행
			default: System.out.println("메뉴를 잘못 입력하셨습니다. 정확한 메뉴를 입력해주세요!\n\n"); continue;
			}
			System.out.print("추가 구매 여부를 선택하세요(y/n) : ");
		// 추가 구매 여부 확인
			result += menuName + " : " + su + "개 - " + price + "원" + "\n";
			sum += price;
			yn = sc.next().charAt(0);
			if(yn == 'n')
				break;

		}	
		
		// 결과 출력
		System.out.println("주문하신 정보는 다음과 같습니다.");
		System.out.println(str);
		System.out.print(result);
		System.out.println(str);
		System.out.printf("합계 : %d원",sum);
	}
}
