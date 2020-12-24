package kh.java.multi.dimentional.array;

/**
 * 2차원배열
 * - 참조의 참조형태로 2차원 배열을 생성할 수 있다.
 * - 간단하게 행/열을 이용해서 배열을 다룰 수 있다.
 *
 */

public class MultiDimentionalArrayTest {
	public static void main(String[] args) {
		MultiDimentionalArrayTest m = new MultiDimentionalArrayTest();
		//m.test1();
		//m.test2();
		//m.test3();
		//m.test4();
		m.test5();
	}
	
	/**
	 * 2차원 배열 구조
	 */
	public void test5() {
		int[][] arr = new int[2][3];
		
	}
	
	/**
	 * 1 2 3 4
	 * 5 6 7 8 
	 * 9 10 11 12
	 */
	public void test4() {
		int[][]arr = new int[3][4];
		//int count = 0;
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				arr[i][j] = count = count + 2;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		// 2차원배열 2 * 26
		// A B C D .......Z
		// a b c d .......c
		char[][] alpha = new char[2][26];
		char flag = 65;
		for(int i = 0; i < alpha.length; i++) {
			if(i==1)
				flag = (char)(flag + 32);
			for(int j = 0; j < alpha[0].length; j++){
				alpha[i][j] = (char)(flag + j);
				System.out.print(alpha[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 2 * 5
	 * A B C D E
	 * a b c d e
	 */
	public void test3() {
		char[][] alphabet = {{'A','B','C','D','E'},
				{'a','b','c','d','e'}};
		
		for(int i = 0; i < alphabet.length;i++) {
			for(int j = 0; j < alphabet[0].length; j++) {
				System.out.print(alphabet[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void test2() {
		String[][] arr = {{"이원빈","김동현","유영국","강준혁","정인식","권송현"},
				{"김진하","주진홍","유선아","정다미","김지헌","김지훈"},
				{"한광희","정다솜","이상원","이제환","황현준","정다빈"},
				{"황수빈","김지수","김자경","박소연","서강석","유리"},
				{"정소희","사영리","강송이","강유정","이효정","이수연"}};
		
		System.out.println(arr.length);
		System.out.println(arr[0].length);
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	public void test1() {

		//1. 배열 선언
		//int[][] 타입
		int[][] arr;
		
		//2. 할당
		arr = new int[2][3];
		
		//3. 요소에 값 대입
		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[0][2] = 3;
		arr[1][0] = 4;
		arr[1][1] = 5;
		arr[1][2] = 6;
		
//		System.out.println(arr[0][0]);
//		System.out.println(arr[0][1]);
//		System.out.println(arr[0][2]);
//		System.out.println(arr[1][0]);
//		System.out.println(arr[1][1]);
//		System.out.println(arr[1][2]);

		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.println(arr[i][j]);
			}
		}
		
	}
}



