package kh.java.exception;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Exception을 try~catch 구문을 이용해서 처리
 * -> 프로그램 비정상종료를 방지
 * 
 */

public class ExceptionTest {
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		ExceptionTest e = new ExceptionTest();
		//e.test1();
		//e.test2();
		//e.test3();
		//e.test4();
		//e.test5();
		e.test6();
		System.out.println("=== 프로그램 정상 종료 ===");
	}
	
	/**
	 * CheckedException
	 * 예외처리 강제화
	 */
	public void test6() {
		String fileName = "test.txt";
		try{
			FileReader fr = new FileReader(fileName);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @실습문제 : 사용자에게 두 정수를 입력받고,
	 * 두수의 합, 차, 곱, 나누기, 나머지를 출력
	 * 이를 반복제공할 것.
	 * 
	 * 정수1 : 7
	 * 정수2 : 3
	 * -> 합 : 10, 차 : 4, 곱 : 21, 몫 : 2, 나머지 : 1
	 * -> 계속 하시겠습니까?(y/n) : 
	 */
	public void test5() {
		int a=0;
		int b=0;
		char yn='y';
		while(true) {
			try{
			
				System.out.print("정수1 : ");
				a = sc.nextInt();
				System.out.print("정수2 : ");
				b = sc.nextInt();
				if(a<0 || b<0) {
					System.out.println("음수를 입력할 수 없습니다.");
					//continue;
					throw new RuntimeException("음수입력");
				}
				System.out.printf("-> 합 : %d, 차 : "
						+ "%d, 곱 : %d, 몫 : %d, "
						+ "나머지 : %d%n", a+b, a-b,a*b,
						a/b , a%b);
				System.out.print("계속 하시겠습니까?(y/n) : ");
				yn = sc.next().toLowerCase().charAt(0);
				if(yn=='n')
					break;
			}catch(InputMismatchException e) {
				System.out.println("유효한 정수를 입력해주세요!");
				sc.next();
			}catch(ArithmeticException e) {
				System.out.println("0으로 나눴습니다. 다시 입력해주세요.");
			}catch(Exception e) {
				System.out.println("처리중 오류가 발생했습니다. 다시 시작합니다. " + e.getMessage());
			}
		}
	}
	
	public void test4() {
		int x = 0;
		while(true) {
			try {
				System.out.print("정수 입력 : ");
				x = sc.nextInt();
	//InputMismatchException이 발생했을 때,
	//입력값이 버퍼에 여전히 남아있어서 문제가 생김.
				break;
			}catch(Exception e ) {
				System.out.println("유효한 정수를 입력해주세요.");
				sc.next();
				//break;
			}
		}
		//break로 빠져나오고 아래 문장 실행시
		//정말 입력값이 출력되는 것을 확인할 수 있음.
		//System.out.println(sc.next());
		if(x%2 == 0)
			System.out.println("짝수입니다.");
		else
			System.out.println();
	}

	/**
	 * finally
	 * 예외가 발생하든 안하든 무조건 실행되는 구문.
	 * 사용한 자원 반납 용도로 사용
	 * try절 안에서 return(조기리턴) 사용시에도 실행된다.
	 */
	public void test3() {
		System.out.println(1);
		try {
			System.out.println(2);
			
			String s = null;
//			System.out.println(s.length());
			
			if(true)
				return;//조기리턴
			
			System.out.println(3);
		} catch(Exception e) {
			System.out.println(4);
		} finally {
			//예외가 발생하든 안하든 무조건 실행되는 구문.
			System.out.println("finally");
		}
		System.out.println(5);
	}
	
	/**
	 * catch절 작성요령
	 * 1. 상속관계가 없다면 작성 순서는 상관이 없음.
	 * 2. 상속관계가 있다면 자식 부모 클래스 순으로 작성해야 한다.
	 * 3. 다형성이 적용되므로, 부모예외클래스 catch절에서 자식예외객체를 처리할 수 있다.
	 */
	public void test2() {
		System.out.println(1);
		try {
			System.out.println(2);
			String s = null;
			System.out.println(s.length());
			int[] arr = new int[3];
			System.out.println(arr[3]);
			
			System.out.println(3);
//		} catch(NullPointerException e) {
//			System.out.println(4);
//		} catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println(5);
		// 부모자식관계에 있는 익셉션은 항상 자식 익셉션부터 먼저
		// 적어주고, 밑에 부모 익셉션을 적어줘야함.
//		} catch(RuntimeException e) {
			
		} catch(Exception e) {
			
		}
		System.out.println(6);
	}
	
	public void test1() {
	
		try {
			// 예외가 발생할 수 있는 코드 작성
			System.out.print("정수1 입력 : ");
			int num1 = sc.nextInt();
			System.out.print("정수 2 입력 : ");
			int num2 = sc.nextInt();
			System.out.printf("%d / %d => %d%n"
					, num1, num2, num1/num2);
		}catch(ArithmeticException e) {
			// 해당예외가 발생했을 경우 처리구문
			System.out.println("ArithmeticException");
			System.out.println("message : " + e.getMessage());
			e.printStackTrace();
		}catch(NullPointerException e) {
			//해당 예외가 발생했을 경우 처리구문
		}catch(InputMismatchException e) {
			//해당 예외가 발생했을 경우 처리구문
			System.out.println("유효한 정수를 입력하셔야 합니다.");
		}
	}
}
