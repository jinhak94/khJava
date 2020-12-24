package kh.java.polymorphism.device;

public class DeviceRun {
	public static void main(String[] args) {
		Device[] arr = new Device[10];
		arr[0] = new TV("삼성", "평면TV", 3_000_000, 10);
		arr[1] = new TV("LG", "울트라평면TV", 2_500_000, 20);
		arr[2] = new Laptop("LG", "그램17", 2_000_000, 512);
		arr[3] = new Laptop("apple", "맥북16", 3_000_000, 1024);
		
		for(Device a : arr) {
			System.out.println("------------------------------"
					+ "-------------------------------------");
			if(a == null)
				break;
			if(a instanceof TV) {
				((TV)a).channelUp();
			}else if(a instanceof Laptop){
				System.out.println("Laptop 용량은 : "+((Laptop)a).getCapacity() + "입니다.");
			}
			System.out.println(a.toString());
		}
	}
}
