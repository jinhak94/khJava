package kh.java.loop;

/*
 * 초기식
 * while(조건식){
 *		반복실행구문
 *		
 *		증감식
 * }
 */

public class WhileLoopTest {
	public static void main(String[] args) {
		WhileLoopTest w = new WhileLoopTest();
		w.test1();
	}
	
	public void test1() {
//		for(int i = 1; i <= 10; i++) {
//			System.out.println(i);
//		}
//		int j = 1;
//		while(j <= 10) {
//			System.out.println(j);
//			j++;
//		}
		
		// 10 9 8 7 6 5 4 3 2 1
		int i= 10;
		while(i>=1) {
			System.out.println(i);
			i--;
		}
		
		// 1 3 5 7 9 11 13 15 17 19
		int j = 1;
		while(j<20) {
			System.out.println(j);
			j += 2;
		}
		// 20 18 16 14 12 10 8 6 4 2
		int k = 20;
		while(k > 0) {
			System.out.println(k);
			k-=2;
		}
		
	}
}
