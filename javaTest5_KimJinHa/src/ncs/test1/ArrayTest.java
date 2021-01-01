package ncs.test1;

public class ArrayTest {
	public static final int ARRAY_SIZE = 6;
	public static void main(String[] args) {
		ArrayTest t = new ArrayTest();
		int[] array = new int[ARRAY_SIZE];
		for(int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random()*100+1);
		}
		
		
		System.out.println("할당된 배열의 크기 : " + array.length);
		System.out.print("array : "); t.print(array);
		System.out.println("가장 큰 값 : " + t.max(array));
		System.out.println("가장 작은 값 : " + t.min(array));
		System.out.println("짝수의 개수 : " + t.evenCount(array));
		System.out.println("홀수의 개수 : " + t.oddCount(array));
		System.out.println("합계 : " + t.sum(array));
		System.out.printf("평균 : %.2f", t.avg(array));
	}
	
	public int sum(int[] arr) {
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	public double avg(int[] arr) {
		return sum(arr)/(double)arr.length;
	}
	
	public int max(int[] arr) {
		int max = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > max)
				max = arr[i];
		}
		return max;
	}
	
	public int min(int[] arr) {
		int min = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < min)
				min = arr[i];
		}
		return min;
	}
	
	public int evenCount(int[] arr) {
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			if((arr[i] % 2) == 0 )
				count++;
		}
		return count;
	}
	
	public int oddCount(int[] arr) {
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			if((arr[i] % 2) != 0 )
				count++;
		}
		return count;
	}
	
	public void print(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
	}
}





