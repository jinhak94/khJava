package kh.java.thread;

public class MyThread extends Thread{

	private char c;
	public MyThread(char c){
		this.c = c;
	}
	
	/**
	 * 쓰레드에서 호출될 메소드
	 */
	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.print(c);
		}
	}
}
