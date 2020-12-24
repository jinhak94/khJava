package kh.java.thread;

public class ThreadTest {
	public static void main(String[] args) {
		ThreadTest t = new ThreadTest();
		//t.test0();
		//t.test1();
		t.test2();
	}
	
	/**
	 * 2. 멀티쓰레드2 Runnable 구현 클래스를 생성하기
	 * 
	 * 쓰레드 스케쥴링
	 *  - 우선순위를 지정해서 처리
	 *  - 1(낮음) ~ 10(높음)
	 *  - 기본값은 5
	 */
	private void test2() {
		Thread th1 = new Thread(new MyRunnable('-'));
		Thread th2 = new Thread(new MyRunnable('|'));
		th1.setPriority(Thread.MAX_PRIORITY);
		th2.setPriority(Thread.MIN_PRIORITY);
		
		th1.start();
		th2.start();
	}
	/**
	 * 1. 멀티쓰레드1 T
	 * Thread클래스를 상속한 객체 만들기
	 * 메인쓰레드까지 3개의 쓰레드가 동작.
	 */
	private void test1() {
		MyThread t1 = new MyThread('-');
		MyThread t2 = new MyThread('|');
		
		//각 쓰레드 시작 : run이 아닌 start를 시작해야 함.
		t1.start();
		t2.start();
	}
	
	/**
	 * 싱글쓰레드(main thread)
	 */
	private void test0() {
		a('-');
		System.out.println();
		b('|');
	}
	
	private void a(char c) {
		for(int i = 0; i < 100; i++)
			System.out.print(c);
	}
	
	private void b(char c) {
		for(int i = 0; i < 100; i++)
			System.out.print(c);
	}
}
