package kh.java.thread;

public class SynchronizationTest {
	
	/**
	 * 임계영역 Critical Section
	 * - 멀티스레드 환경에서 한 번에 한 쓰레드만 접근할 수 있는 영역(객체 단위)
	 * - lock을 획득한 쓰레드만 이용 가능하다.
	 * 
	 * 1. synchronized 메소드 만들기
	 * 2. synchronized block 생성
	 * 
	 */
	public static void main(String[] args) {
		SynchronizationTest s = new SynchronizationTest();
		s.test();
	}
	
	private void test() {
		//1. 계좌 객체
		Account acc = new Account(1000);
		
		//2. ATM 객체
		Thread atm1 = new Thread(new ATM(acc));
		Thread atm2 = new Thread(new ATM(acc));		
		atm1.setName("atm1");
		atm2.setName("atm2");
		
		atm1.start();
		atm2.start();
	}
}
