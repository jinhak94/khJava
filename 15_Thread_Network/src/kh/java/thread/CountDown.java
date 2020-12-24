package kh.java.thread;

public class CountDown implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 10; i >= 0; i--) {
			System.out.print(Thread.currentThread().getName() + " : ");
			System.out.println(i);
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				System.out.println("카운트 다운 중지!");
				return;
			}
		}
	}

}
