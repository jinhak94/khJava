package com.oop.method.static_;

public class Run {
	
	public static void main(String[] args) {
		
		int idx = 11;
		char change = 'd';
		String str = "nice to meet you!";
		
		StaticMethod.toUpper();
		StaticMethod.setChar(idx, change);
		System.out.println(StaticMethod.valueLength());
		System.out.println(StaticMethod.valueConcat(str));
	}
	
	
	
}
