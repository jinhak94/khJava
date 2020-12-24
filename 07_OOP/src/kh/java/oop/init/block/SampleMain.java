package kh.java.oop.init.block;

public class SampleMain {
	public static void main(String[] args) {
		//Sample클래스 사용시(프로그램 시작시) static 자원은 메모리에 등록된다.
		//인스턴스변수는 개게생성시 만들어진다.
		new Sample();
		
		System.out.println("---- 종료 -----");
	}
}
