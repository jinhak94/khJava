package com.oop.method.nonstatic;

public class NonStaticSample {
	
	public static void main(String[] args) {
		NonStaticSample n = new NonStaticSample();
		//1.
		n.printLottoNumbers();
		//2.
		int len = 5;
		char ch = 'c';
		n.outputChar(len, ch);
		//3.
		n.alphabet();
		//4.
		String ordStr = "안녕하세요! kh 정보교육원에 다니고 있는 '김진하'라고 합니다.";
		int sidx = 5;
		int eidx = 15;
		String newStr = n.mySubstring(ordStr, sidx, eidx);
		System.out.println(newStr);
	}
	
	//1. 반환값 없고 매개변수 없는 메소드
	public void printLottoNumbers() {
		System.out.println("\nnonstatic 1번.\n");
		int[] number = new int[6];
		for(int i = 0; i < number.length; i++) {
			number[i] = (int)(Math.random()*45+1);
			
			for(int j = 0; j < i; j++) {
				if(number[i] == number[j]) {
					i--;
					break;
				}
			}
		}
		for(int i = 0; i < number.length; i++) {
			System.out.println(number[i]);
		}
		
	}
	
	//2. 반환값 없고 매개변수 있는 메소드
	public void outputChar(int length, char c) {
		System.out.println("\nnonstatic 2번\n");
		for(int i = 0; i < length; i++) {
			System.out.println(c);
		}
	}
	
	//3. 반환값 있고 매개변수 없는 메소드
	public char alphabet() {
		System.out.println("\nnonstatic 3번\n");
		char c = (char)(Math.random()*26+65);
		System.out.println("발생된 영문자 : " + c);
		return c;
	}
	
	//4. 반환값 있고 매개변수 있는 메소드
	public String mySubstring(String originStr, int sidx, int eidx) {
		System.out.println("\nnonstatic 4번\n");

		if(originStr == null)
			return null;

		return originStr.substring(sidx,eidx+1);
	}
	
	
}
