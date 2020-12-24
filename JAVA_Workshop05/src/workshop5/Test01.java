package workshop5;

public class Test01 {
	public static void main(String[] args) {
		char[] array = args[0].toCharArray();
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[array.length - (i+1)
]);
		}
	}
}
