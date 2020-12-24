package kh.java.oop.field;

public class FieldTest {
	static int s = 99;
	int a = 100;
	
	public void test3(FieldTest k) {
		k.a = 1;
		this.a = 200;
		System.out.println(this.hashCode());
		System.out.println(k.hashCode());
	}
	
	/**
	 * f.test2()인 경우,
	 * test2 메소드 안의 this는 f가 가리키는 객체이다.
	 */
	public void test2() {
		FieldTest t = new FieldTest();
		t.a = 300;
		
		// 100이 나옴.
		System.out.println(a);
	}
	
	public void test1() {
		int s = 5;
		int a = 8;
		
		System.out.println(FieldTest.s);
		System.out.println(this.a);
	}
}
