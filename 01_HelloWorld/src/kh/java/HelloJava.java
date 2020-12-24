package kh.java;

import java.util.Date;

import kh.java.other.HongGildong;

/*
 * package는 모두 소문자로 작성
 * 단어별로 끊어서 작성한다.
 * 연달아서 쓰지 않고 단어별로 끊어서 작성하는 것이 원칙. korea.seoul
 * 
 * class는 반드시 대문자로 시작함. 단어가 연결될 때는 연결된 단어의 첫 글자는 다시 대문자로 쓴다.
 * 이걸 CamelCasing이라고 한다.
 * 
 * java.lang.String
 * java.io.File
 * java.util.collection.Collection
 */


public class HelloJava {
	public static void main(String[] args) {
		// 객체 레시피 : 클래스를 객체로 만들어주는 문법
		HelloJava hello = new HelloJava();
		hello.callMyName();
		HelloKH kh = new HelloKH();
		kh.welcome();
		HongGildong hong = new HongGildong();
		hong.say();
		//java.util.Date
		Date today = new Date();
		System.out.println(today.getDate());
		
		String name = new String("신사임당");
		System.out.println(name);
	}
	public void test() {
		System.out.println("안늉~~~~");
	}

	public void callMyName() {
		System.out.println("김진하!!!!");
	}
}
