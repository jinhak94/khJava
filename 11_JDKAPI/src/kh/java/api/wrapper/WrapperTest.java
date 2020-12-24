package kh.java.api.wrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * WrapperClass
 * - 기본형의 값을 감싸고 있는 클래스로 기본형을 객체로 사용할 수 있다.
 * 
 * byte -> Byte
 * short -> Short
 * int -> Integer
 * long -> Long
 * 
 * float -> Float
 * double -> Double
 * 
 * boolean -> Boolean
 * 
 * char -> Character
 *
 */

public class WrapperTest {
	public static void main(String[] args) {
		WrapperTest wt = new WrapperTest();
	//	wt.test1();
	//	wt.test2();
		wt.test3();
	}
	
	/**
	 * csv데이터의 합을 구하기
	 */
	public void test3() {
		String data = "3.5, 4.4, 1.89";
		StringTokenizer st = new StringTokenizer(data, ", ");
		double sum = 0.0;
		
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			sum+= Double.parseDouble(token);
		}
		System.out.printf("합은 %.2f입니다.", sum);
	}
	
	/**
	 * 문자열 데이터를 해당 타입으로 변환
	 */
	public void test2() {
		String data = "345";
		System.out.println(Integer.parseInt(data)+10);
		
		data = "34.567";
		System.out.println(Double.parseDouble(data)*10);
	}
	
	/**
	 * 기본형 -> Wrapper객체 : auto-boxing
	 * Wrapper객체 -> 기본형 : auto-unboxing
	 */
	public void test1() {
		int i = 100;
		Integer j = new Integer(100);
		
		//auto-unboxing
		System.out.println(i + j);
		System.out.println(i + j.intValue()); // 값 + 값
		
		//auto-boxing
		Integer k = 100;
		//Integer k = new Integer(100);
		
		//generic 사용시, 기본형 사용할 수 없다.
		List<Integer> list = new ArrayList<Integer>();
//		List<Integer> list = new ArrayList<Integer>(); // compile error
		
	}
}
















