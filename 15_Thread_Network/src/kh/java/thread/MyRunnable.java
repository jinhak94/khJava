package kh.java.thread;

public class MyRunnable implements Runnable{
	
	private char c;
	public MyRunnable(char c){
		this.c = c;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.print(c);
		}
	}
}
