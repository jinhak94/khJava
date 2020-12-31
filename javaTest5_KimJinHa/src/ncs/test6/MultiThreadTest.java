package ncs.test6;

public class MultiThreadTest {
	public static void main(String[] args) {
		Data data = new Data();
		Thread putThread;
		Thread getThread;
		
		// data를 공유하는 Provider와 Customer 객체 생성 : 
		//Thread 객체 생성함
		putThread = new Thread(new Provider(data));
		getThread = new Thread(new Customer(data));
		
		// 쓰레드 구동
		putThread.start();
		getThread.start();
	}
}
