package ncs.test6;

public class Data {
	
	private int value;
	private boolean isEmpty = true;
	
	public Data() {
		
	}
	
	public synchronized void setValue(int value) {
		if(isEmpty) {
			this.value = value;
			isEmpty = false;
			notifyAll();
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public synchronized int getValue() throws EmptyException{
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int temp = 0;
		if(!isEmpty) {
			if(value == 0)
				throw new EmptyException();
			temp = value;
			value = 0;
			isEmpty = true;
			notifyAll();
		}
		return temp;
	}
}
