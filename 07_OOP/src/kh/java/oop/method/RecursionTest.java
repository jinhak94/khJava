package kh.java.oop.method;

public class RecursionTest {

	public static void main(String[] args) {
		RecursionTest r = new RecursionTest();
		
		//factorial 5! = 5 * 4 * 3 * 2 * 1
		int result = r.factorial(5);
		System.out.println(result);
		
	}
	//재귀함수는 종료조건 반드시 명시하고, 스스로를 호출할 것
	//StackOverflowError 주의할 것.
	//주사위두개던지기, 하노이의 탑등 심화예제
	public int factorial(int n) {
		System.out.println(n);
		if(n == 1)
			return 1;
		else
			return n * factorial(n - 1);
	}

}
