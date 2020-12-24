package kh.java.api.string;

import java.util.StringTokenizer;

/**
 * 
 * String
 * 	- immutable(변경 불가한)
 * 	- heap영역안에 Literal Pool에서 문자열 Literal을 관리
 * 	- 공유 가능
 * StringBuilder
 * 	- mutable(변경 가능한) 싱글쓰레드 작동
 * StringBuffer
 *	- mutable(변경 가능한) 멀티쓰레드 작동
 */


public class StringTest {
	
	public static void main(String[] args) {
		StringTest st = new StringTest();
		//st.test1();
		//st.test2();
		st.test3();
	}
	
	/**
	 * csv
	 * Comma Seperated Value 콤마로 구분된 값
	 * "a/b/c/d" -> {"a", "b", "c", "d"}
	 * "홍길동, 1, 180, 79"
	 * 
	 * 1. String - split
	 * 2. StringTokenizer
	 */
	public void test3() {
		String data = "java,oracle, jdbc, html5 css3, javascript";
		//1. split
		String[] arr1 = data.split(", ");
		//정규표현식
		arr1 = data.split("[, ]");
		for(String s : arr1) {
			System.out.println("["+s+"]");
		}
		System.out.println(arr1.length);
		
		//2. StringTokenizer
		StringTokenizer tokenizer = new StringTokenizer(data, ", ");
		System.out.println(tokenizer.countTokens());
		//구분자파라미터를 문자 단위로 파싱
		//길이값이 0인 데이터는 날려버림 9개 -> 6개
		while(tokenizer.hasMoreTokens()) {
			String s = tokenizer.nextToken();
			System.out.println("[" + s + "]");
		}
	}
	
	/**
	 * StringBuilder 안에서 변경이 일어나고, 
	 * hashCode 값도 동일하게 유지된다.
	 *
	 * 문자열의 변경이 자주 일어나게 된다면, StringBuilder를 사용할 것.
	 * 
	 */
	public void test2() {
		StringBuilder sb = new StringBuilder("자바");
		System.out.println(sb);
		System.out.println(sb.hashCode());
		System.out.println(sb.append("오라클"));
		System.out.println(sb.hashCode());
	}
	
	public void test1() {
		String s1 = "자바";
		String s2 = "자바";
		String s3 = new String("자바");
		String s4 = new String("자바");
		
		//==
		// 힙의 리터럴 풀 내의 "자바"를 s1과 s2가 동시에 가리킴
		System.out.println(s1==s2);
		// s3과 s4는 힙의 String 객체를 생성하고, 
		// String 객체가 리터럴 풀 내의 JAVA를 우회적으로 가리킴
		System.out.println(s1==s3);
		System.out.println(s3==s4);

		//equals : Object.equals를 오버라이딩해둠.
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s3.equals(s4));
		
		//hashCode
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());
		//문자열 : 더하기연산
		// 자바를 직접적으로 자바오라클로 변경하는 것이 아닌, 
		// 자바 연결을 끊고, 자바오라클 String 객체를 새로 만들어서 연결함
		s2 += "오라클";
		s4 += "오라클";
		
		System.out.println(s2);
		System.out.println(s2.hashCode());
		System.out.println(s4);
		System.out.println(s4.hashCode());
	}
}
