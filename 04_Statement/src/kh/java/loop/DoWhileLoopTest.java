package kh.java.loop;

import java.util.Scanner;

/**
 * while 초기식 -> 조건식 -> 반복실행구문 -> 증감식......
 * do.while 초기식 -> 반복실행구문 -> 증감식) -> 조건식
 * 
 *
 */
public class DoWhileLoopTest {
	public static void main(String[] args) {
		DoWhileLoopTest t = new DoWhileLoopTest();
		//t.test1();
		//t.test2();
		//t.test3();
		//t.test4();
		t.test5();
	}

	/**
	 * @실습문제:
	 * 사용자에게 단수를 입력받아 해당 단의 구구단 출력
	 * 계속 여부를 입력 진행할 것
	 * 
	 * 출력할 구구단 입력 (2 ~ 9) : 3
	 * 3 * 1 = 3
	 * 3 * 2 = 6
	 * ...
	 * 3 * 9 = 27
	 * 계속 하시겠습니까? (y/n) : y
	 */
	public void test5() {
		Scanner sc = new Scanner(System.in);
		int input;
		char yn = 'y';
		
		do {
			
//			System.out.print("단을 입력하세요 (2 ~ 9) : ");
//			input = sc.nextInt();
//			for(int i = 1; i < 10; i++) {
//				System.out.println(input + " * " + i + " = " + (input * i));
//			}
			
			calcWaterFree();
			
			System.out.print("진행 여부를 선택해주세요(y/n) : ");
			yn = sc.next().charAt(0);
		} while(yn == 'y');
		System.out.println("종료되었습니다.");
	}
	
	public void test4() {
		Scanner sc = new Scanner(System.in);
		int wcase, use;
		
		String str="";
		
		char yn = 'y';
		
		
		int charge = 0;
		double tax = 0;
		double tot;
		do {
			System.out.print("용도를 입력하세요 : ");
			wcase = sc.nextInt();
			System.out.print("사용량을 입력하세요 : ");
			use = sc.nextInt();
			switch(wcase) {
			case 1: str = "가정용"; charge = 50*use; tax = charge*0.05; break;
			case 2: str = "상업용"; charge = 45*use; tax = charge*0.05; break;
			case 3: str = "공업용"; charge = 30*use; tax = charge*0.05; break;
			default: System.out.println("잘못 입력하셨습니다!");
			}
			System.out.print("계속 진행할지 여부를 입력하세요(y/n) : ");
			yn = sc.next().charAt(0);
		
		tot = charge + tax;
		
		System.out.println("--- 총 사용요금 ---");
		System.out.println("- " + str + "을 사용하고 계십니다.");
		System.out.println("- 사용요금 : " + charge + "원");
		System.out.println("- 수도세 : " + (int)tax + "원");
		System.out.println("- 총납부금액 : " + (int)tot + "원");
		}while(yn=='y');	
		System.out.println("종료되었습니다.");
	}
	
	/**
	 * 메뉴 가격 계산기
	 * 
	 */
	public void test3() {
		Scanner sc = new Scanner(System.in);
		String menu = "===============\n"
				+ "1. 참치김밥\n"
				+ "2. 멸치김밥\n"
				+ "3. 라뽁기\n"
				+ "-------------------\n"
				+ "선택 : ";
		char yn = 'n';	// 추가주문 여부
		int choice = 0;	// 사용자 메뉴 선택
		int sum = 0;	// 누적합
		do {
			System.out.print(menu);
			choice = sc.nextInt();
			System.out.println(choice);
			
			//누적합 계산
			switch(choice) {
			case 1: sum += 3000; break;
			case 2: sum += 2500; break; 
			case 3: sum += 3500; break;
			default: System.out.println("잘못 입력하셨습니다.");
			}
			
			// 추가주문 여부
			System.out.println("더 주문하시겠습니까?(y/n) : ");
			
			yn = sc.next().charAt(0);
			
		} while(yn == 'y');
		System.out.println("총 음식값은 " + sum + "입니다.");
		System.out.println("--- 이용해 주셔서 감사합니다. ---");
	}
	public void calcWaterFree() {
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
	public void test2() {
		Scanner sc = new Scanner(System.in);
		char yn = 'y'; // do~while 조건식에 사용될 변수는 블럭 바깥에 선언할 것.
		
		do{
			System.out.println("--- 게임 시작 ---");
			System.out.println("얍~ 빡~ 쿵~ 와~");
			System.out.println("--- 게임 오버 ---");
			System.out.print("한 판 더 하시겠습니까?(y/n) : ");
			yn = sc.next().charAt(0);
		} while( yn == 'y');
		System.out.println("=== 이용해주셔서 감사합니다. ===");
	}
	
	public void test1() {
		int i=0;
//		while(i>0) {
//			System.out.println("안녕");
//			i--;
//		}
		do {
			System.out.println("안녕");
			i--;
		}
		while(i>0);
		
		System.out.println("--- 끝 ---");
	}
}
