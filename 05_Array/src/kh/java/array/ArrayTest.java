package kh.java.array;

/**
 * 변수 : 하나의 자료형, 하나의 값을 보관
 * 배열 : 하나의 자료형, 여러가지 값을 보관
 *
 */

public class ArrayTest {
	
	public static void main(String[] args) {
		ArrayTest a = new ArrayTest();
//		a.test1();
//		a.test2();
//		a.test3();
//		a.test4();
//		a.test5();
//		a.test6();
		a.test7();
	}
	
	public void test7() {
		int[] arr = new int[5];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		
		//int[] arr = {1,2,3,4,5};
		int[] arr1 = new int[] {1,3,5}; // 배열 크기 지정하지 말 것. 쓰면 오류남.
		
	}
	
	/**
	 * 배월의 특징
	 * 
	 * - 배열의 크기는 변경할 수 없다.
	 * - 배열의 삭제는 참조형변수에 null을 대입함으로써 처리된다.
	 */
	public void test6() {
		int[] arr1 = new int[10];
		System.out.println(arr1.length);
		//hashCode : 객체가 가진 고유값(주소값은 아니다.)
		System.out.println(arr1.hashCode());
		
		//새로운 배열을 할당
		arr1 = new int[10];
		System.out.println(arr1.length);
		System.out.println(arr1.hashCode());
		
		//배열 삭제
		arr1 = null;
		
		//참조형변수가 heap에 가리키는 객체가 없을 때, (null인 경우)
		// 메소드, 속성 등을 참조하면 NullPointerException 예외 발생
		System.out.println(arr1.length);
	}
	
	/**
	 * @실습문제 : 알파벳 소문자 배열을 만들고 모든 요소를 한 줄로 출력해라
	 * a, b, c, .... , z
	 */
	
	public void test5() {
		char[] alpha = new char[26];
		
		for(int i = 0; i < alpha.length; i++) {
			alpha[i] = (char)(i + 97);
			
			System.out.print(alpha[i]);
			if(i == alpha.length-1)
				break;
			System.out.print(", ");
		}
		System.out.println();
		
	}
	
	public void test4() {
		//1. 배열선언 및 할당
		int[] numArr = new int[8];
		
		//2. 요소의 값 대입
		for(int i = 0; i < numArr.length; i++) {
			numArr[i] = (i + 1) * 2;
		}
		// 2, 4, 6, 8, 10, 12, 14, 16
		//3. 요소 값 사용
//		System.out.print(numArr[0]);
//		for(int i = 0; i < numArr.length; i++) {
//			System.out.print("," + numArr[i]);
//		}
		for(int i = 0; i < numArr.length; i++) {
			System.out.print(numArr[i]);
			if(i!=numArr.length-1)
				System.out.print(", ");
		}
	}
	
	public void test3() {
		
		String[] strArr = new String[10];
		strArr[0] = "홍길동";
		strArr[1] = "둘리";
		strArr[2] = "도우너";
		
		System.out.println(strArr.length);
		for(int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);			
		}

	}
	
	/**
	 * @실습문제 : 문자 배열을 이름 길이로 생성하고, 각 index에 이름을 대입 후 출력할 것.
	 */
	public void test2() {
		//1. 배열선언
		//2. heap에 배열할당
		char[] name = new char[3];
		System.out.println("[" + name[0] + "]");
		System.out.println("[" + name[1] + "]");
		System.out.println("[" + name[2] + "]");
		//3. 요소에 값대입
		name[0] = '김';
		name[1] = '진';
		name[2] = '하';
		//4. 출력
		System.out.println(name);
	}
	
	public void test1() {
		// 변수공간은 초기화되지 않고, 쓰레기값이 들어있다.
		// callstack의 변수는 초기화(값대입) 하지 않고는 사용할 수 없다.
		int kor= 80;
		int eng = 100;
		int math = 90;
		
		System.out.println(kor);
		System.out.println(eng);
		System.out.println(math);
		
		//1. 배열변수 선언
		int[] arr;
		
		//2. 배열 할당(heap 영역에 공간 확보)
		//배열크기를 반드시 지정할 것.
		//heap은 자료형별 기본값으로 초기화된다.
		//int : 0, double : 0.0, boolean : false, char : ' '
		//참조형인 경우 null로 초기화 됨.
		arr = new int[3];
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);

		//배열 요소 값 대입
		arr[0] = 80;
		arr[1] = 100;
		arr[2] = 90;
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		
	}
}
