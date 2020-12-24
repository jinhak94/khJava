package kh.java.nested.loop;

import java.util.Scanner;

/**
 * 중첩반복문을 사용하면, 다차원적인 데이터를 처리할 수 있다.
 * 
 * 행/열로 이루어진 테이블 표현이 가능
 *
 */

public class NestedLoopTest {
	public static void main(String[] args) {
		NestedLoopTest n = new NestedLoopTest();
//		n.test1();
//		n.test2();
//		n.test3();
//		n.test4();
//		n.test5();
//		n.test6();
//		n.test7();
		n.test8();
	}
	
	/*
	 * ♥
	 * ♥♥
	 * ♥♥♥
	 * ♥♥
	 * ♥
	 */
	public void test8() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print('♥');
			}
			System.out.println();
		}
		for(int i = 0; i < 2; i++) {
			for(int j = 2; j > i; j--) {
				System.out.print('♥');
			}
			System.out.println();
		}
	}
	
	
	/*
	 * ♥♥♥♥♥
	 * ♥♥♥♥
	 * ♥♥♥
	 * ♥♥
	 * ♥
	 */
	public void test7() {
		for(int i = 0; i < 5; i++) {
			for(int j = 5; j > i ; j--) {
				System.out.print("♥");
			}
			System.out.println();
		}
	}
	
	public void test6() {
		for(int i = 2; i < 10; i++) {
			System.out.println("----" + i + "단 ----");
			for(int j = 1; j < 10; j++) {
				System.out.printf("%d * %d = %d%n", i, j, (i*j));
			}
			System.out.println();
		}
	}
	
	public void test5() {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print("★");
				if((i%2)==1)
					break;
			}
			System.out.println();
		}
	}
	
	/**
	 ★
	 ★★
	 ★★★
	 ★★★★
	 ★★★★★
	 */
	public void test4() {
//		for(int i = 0; i < 5; i++) {
//			for(int j = 0; j < i+1; j++) {
//				System.out.print("★");
//			}
//			System.out.println();
//		}
		
		//라벨을 사용한 break
		outer:
		for(int i = 0; true; i++) {
			for(int j = 0; j < i+1; j++) {
				if(i >= 5)
					break outer;

				System.out.print("★");
			}
			System.out.println();
		}

		System.out.println();
	
		//라벨을 사용한 continue
		outer:
		for(int i = 0; i < 5; i++) {
			
			for(int j = 0; j < 5; j++) {
				System.out.print("★");
//				if(i==j)
//					break;
				if(i==j) {
					System.out.println();
					continue outer;
				}
			}
			
		}
	}
	
	/**
	 * @실습문졔 : 사용자가 원하는 크기의 별 box 찍기
	 * - 행, 열 입력
	 */
	public void test3() {
		Scanner sc = new Scanner(System.in);
		int row;
		int col;
		
		System.out.print("행을 입력하세요 : ");
		row = sc.nextInt();
		System.out.print("열을 입력하세요 : ");
		col = sc.nextInt();
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
	}
	
	/**
	 * @실습문제 : 
	 *  (0,0)(0,1)(0,2)(0,3)(0,4)
	 *  (1,0)(1,1)(1,2)(1,3)(1,4)
	 *  (2,0)(2,1)(2,2)(2,3)(2,4)
	 */
	public void test2() {
		for(int i=0; i<4; i++) {
			for(int j=0; j<3; j++) {
				//System.out.print("("+i+","+j+") ");
				System.out.print("★");
			}
			System.out.println();
		}
	}
	
	public void test1() {
		//outer
		for(int i = 0; i < 2; i++) {
			System.out.print(i + " : ");
			//inner
			for(int j = 0; j < 3; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print("(" + i + "," + j + ") ");
			}
			System.out.println();
		}

	}
}
