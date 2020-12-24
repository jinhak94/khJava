package com.kh.test;

public class Test1 {
	
	int iNum1 = 100;
	long lNum1 = 999900000000L;
	float fNum1 = 486.520F;
	double fNum2 = 567.890123;
	char c = 'A';
	String str = "Hello world";
	boolean bool = true;
	
	public static void main(String[] args) {
		Test1 t = new Test1();
		t.test1();
	}
	
	public void test1() {
		
		System.out.println("iNum1 = " + iNum1 + "\n" +
				"lNum1 = " + lNum1 + "\n" + 
				"fNum1 = " + fNum1 + "\n" +
				"fNum2 = " + fNum2 + "\n" + 
				"c = " + c + "\n" +
				"str = " + str + "\n" +
				"bool = " + bool + "\n");

	}

}










