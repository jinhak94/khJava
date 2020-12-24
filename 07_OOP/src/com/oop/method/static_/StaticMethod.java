package com.oop.method.static_;

public class StaticMethod {
	//Field
	private static String value ="Hello! My name is Kim Jin Ha";

    //필드가 모두 static 일 때는 메소드도 전부 static 이어야 함
    //static method
    //1. 반환값 없고 매개변수 없는 메소드
    //value 필드 값을 모두 대문자로 바꾸는 static 메소드
    //메소드명 : toUpper
    public static void toUpper() {
    	System.out.println("\nstatic 1번\n");
    	//value = value.toUpperCase();
    	value = value.toUpperCase();
    	System.out.println(value);
    }
    
    //2. 반환값 없고 매개변수 있는 메소드
    //인덱스와 문자를 전달받아
    //value 필드에서 전달받은 인덱스 위치의 값을 전달받은 문자로 변경하는 static 메소드
    //메소드명 : setChar
    public static void setChar(int idx, char change) {
    	System.out.println("\nstatic 2번\n");
    	value = value.substring(0,idx) + change + value.substring(idx+1);
    	System.out.println(value);
    }
    
    
    //3. 반환값 있고 매개변수 없는 static 메소드
    //value 필드에 기록된 글자갯수 리턴 처리
    //메소드명 : valueLength
    public static int valueLength() {
    	System.out.println("\nstatic 3번\n");
    	return value.length();
    }
    
    
    //4. 반환값 있고 매개변수 있는 static 메소드
    //문자열값을 전달받아, value 필드값과 하나로 합쳐서 리턴 처리
    //메소드명 : valueConcat
    public static String valueConcat(String str) {
    	System.out.println("\nstatic 4번\n");
    	return value.concat(str);
    }

}
