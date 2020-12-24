package kh.java.print;

public class PrintTest {
	public static void main(String[] args) {
		PrintTest p = new PrintTest();
		//p.printValueTest();
		
		//p.printTest();
		//p.escapingTest();
		p.shakeIt();
	}
	/*
	 		"ShakeIt 알람"
--------------------------------------------
	흔들기	쏴리질러	터치하기	원터치
--------------------------------------------
아침부터 쌩쑈를 해야 알람을 끌수 있음.
	 */
	public void shakeIt() {
		System.out.println("\t\t\"ShakeIt 알람\"\n"
				+ "--------------------------------------------\n"
				+ "\t흔들기\t쏴리질러\t터치하기\t원터치\n"
				+ "--------------------------------------------\n"
				+ "아침부터 쌩쑈를 해야 알람을 끌수 있음.");
	}
	
	/**
	 * escape 문자
	 * 인쇄되지 않거나 키보드로 표현 불가능한 기능성 문자를 표현
	 * \(역슬래시) + 문자
	 * 
	 * - \n : 개행처리
	 * - \t : 탭처리
	 * - \r : 캐리지 리턴 (맨 앞으로 이동)  \r\n
	 * - \\ : 역슬래시를 문자 그대로 사용하고 싶을 때
	 */
	public void escapingTest(){
		System.out.println("가\n나\t다");
		System.out.println("a\\b\\c\\d");
		System.out.println("그는 말했다. '안녕~'");
		System.out.println("그는 말했다. \"안녕~\"");
		System.out.println("C:\\Users\\user1\\Downloads");
		
	}
		
	public void printTest() {
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.print(1+"\n\n");
		System.out.print(2+"\n");
		System.out.print(3);
	}
	
	public void printValueTest() {
		// 숫자
		System.out.println(123);
		System.out.println(45.678);
		System.out.println(1+3);
		System.out.println('a');
		System.out.println('末');
		System.out.println("안녕하세요~");
		System.out.println("bcde"+'e');
		System.out.println("어디"+"가세요"+"?");
		System.out.println(123+"456");
		System.out.println(1+2+"3");  // 33
		System.out.println("1"+2+3);  // 123
		
		System.out.println('a'+1);
		System.out.println('a'+"가나다");
		System.out.println('c'+3);	// 102
		System.out.println('Z'-3);	// 87
		System.out.println('0'+3);	// 51
		System.out.println('A'+'a');// 162
	}
}
