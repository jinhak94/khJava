package kh.java.thread;

import javax.swing.JOptionPane;

/**
 * 
 * 쓰레드 제어
 * - sleep() : 쓰레드 일정시간 중지
 * - join() : 다른 쓰레드에 대해 대기
 * - interrupt() : 쓰레드 중지
 *
 */

public class ThreadControlTest {
	public static void main(String[] args) {
		ThreadControlTest t = new ThreadControlTest();
		//t.test1();
		//t.test2();
		t.test3();
		System.out.println(Thread.currentThread().getName() + " 종료!");
	}
	
	/**
	 * interrupt
	 * - 해당쓰레드에 interrupt를 호출해서 
	 *   InterruptedException 유발
	 * - catch절에 처리구문 작성
	 */
	private void test3() {
		Thread cd = new Thread(new CountDown());
		cd.setName("CountDown");
		cd.start();
		
		//중지
		// 실제로는 중지라기보단 InterruptedException을 유발
		if("exit".contentEquals(JOptionPane.showInputDialog("중지하려면 exit를 입력하세요")));
			//CountDown의 run() 메소드의 catch절에서 찍어줌.
			cd.interrupt(); 
	
	}
	
	/**
	 * daemon thread
	 *  - 일반쓰레드에 종속된 쓰레드
	 *  - 일반쓰레드가 종료시 자동종료된다.
	 */
	public void test2() {
		Thread countDown = new Thread(new CountDown());
		countDown.setName("카운트다운 쓰레드");
//countDown 쓰레드를 데몬 쓰레드로 만듦
//		countDown.setDaemon(true);
		countDown.start();
		
	// start()를 수행하면, 쓰레드의 콜스택을 할당받고,
	// 그 콜스택 내에서 run() 메소드를 수행한다.
	
		//사용자입력값을 기다렸다 출력!
		String input = JOptionPane.showInputDialog("아무 문자열을 입력하세요");
		System.out.println(input);
	
		//join : 조인할 쓰레드에 대해 호출
		try{
			//countDown.join();
			countDown.join(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * sleep
	 */
	private void test1() {
		Thread th1 = new Thread(new SleepThread('-', 100));
		Thread th2 = new Thread(new SleepThread('|', 200));
		
		th1.start();
		th2.start();
	}
}
