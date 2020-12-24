package kh.java.type;

public class StringTest {
	
	/**
	 * 자료형
	 * - 기본형 boolean char byte short int long float double
	 * - 참조형
	 * 
	 */
	
	public static void main(String[] args) {
		
		// 기본형변수
		//boolean b = true;
		//char ch = '캬';
		
		// 참조형 변수
		//StringTest st = new StringTest();
		//String s = new String("안녕");
		
		// "지하철"
		String metro1 = "지하철";
		String metro2 = new String("지하철");
		
		System.out.printf("metro1 = %s%n", metro1);
		System.out.printf("metro2 = %s%n", metro2);
	}
}
