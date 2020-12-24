package kh.java.thread;

public class SleepThread implements Runnable {

	private char c;
	private long millis;
	
	public SleepThread(char c, long millis){
		this.c = c;
		this.millis = millis;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 100; i++) {
			System.out.print(c);
			
			try{
				Thread.sleep(millis);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
