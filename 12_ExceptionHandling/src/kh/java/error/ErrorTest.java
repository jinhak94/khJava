package kh.java.error;

public class ErrorTest {
	public static void main(String[] args) {
		ErrorTest e = new ErrorTest();
		//e.test1();
		//e.test2();
	}
	/**
	 * OutOfMemoryError
	 */
	public void test1() {
		long[] arr = new long[Integer.MAX_VALUE];
	}
	/**
	 * java.lang.StackOverflowError
	 */
	public void test2() {
		System.out.println("test2");
		test2();
	}
}
