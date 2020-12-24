package kh.java.oop.method;

/**
 * 
 * method
 * - 클래스 메소드 static
 * - 인스턴스 메소드 non-static
 * 
 * static자원(필드, 메소드)은 non-static자원(필드, 메소드)를 참조할 수 없다.
 * 
 */

public class MethodTest {

	static int sno = 99;
	int num = 100;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MethodTest m = new MethodTest();
		m.instanceMethod();
		MethodTest.classMethod();
	}
	
	public static void classMethod() {
		System.out.println(sno);
//		System.out.println(num);//인스턴스변수 사용 불가
	}
	
	/**
	 * instance메소드에서는 static/non-static 자원 모두 사용 가능
	 */
	
	public void instanceMethod() {
		System.out.println(sno);
		System.out.println(num);
//		System.out.println(MethodTest.sno);
//		System.out.println(this.num);
		classMethod();
	}

}
