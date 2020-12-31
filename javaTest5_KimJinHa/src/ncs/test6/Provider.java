package ncs.test6;

public class Provider extends Thread{
	
	private Data data;
	
	public Provider(Data data) {
		this.data = data;
	}
	
	public void run() {
		int i = 0;
		int random;
		while(i < 10) {
			
			random = (int)(Math.random()*100+1);
			System.out.println("값이 입력되었습니다.");
			System.out.println("put value : " + random);
			data.setValue(random);
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
