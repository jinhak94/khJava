package kh.java.test.array;

public class Test1 {
	public static void main(String[] args) {
		Test1 t = new Test1();
		t.test();
	}
	
	public void test() {
		int[] arr = new int[100];
		for(int i = 0; i < 100; i++) {
			arr[i] = i + 1;
			System.out.print(arr[i]);
			if(i != 99)
				System.out.print(", ");
			if((i % 10) == 9)
				System.out.println();
		}
	}
}
