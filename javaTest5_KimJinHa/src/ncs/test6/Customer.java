package ncs.test6;

public class Customer extends Thread{
	
	private Data data;
	
	public Customer(Data data) {
		this.data = data;
	}
	
	public void run() {
		int i = 0;
		int random;
		while(i < 10) {
			try {
				random = data.getValue();
				System.out.println("get value : " + random);
			} catch (EmptyException e1) {
				// TODO Auto-generated catch block
				System.out.println("현재 입력된 값이 없습니다. 기다리십시오...");
			}
			i++;
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
