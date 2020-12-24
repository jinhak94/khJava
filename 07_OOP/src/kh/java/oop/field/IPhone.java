package kh.java.oop.field;

public class IPhone {
	//2. 전역변수 - 클래스변수
	//객체간 공유할 만한 정보
	public static final int WIDTH = 10;
	public static final int HEIGHT = 20;
	
	//1. 전역변수 - 인스턴스(멤버 변수)
	private String owner;
	private String phoneNumber;
	
	//3.지역변수
	//메소드영역에 선언
	//접근제한자, static 키워드를 가질 수 없다.
	public void heySiri(int a, int b) {
		int sum= a + b;
		System.out.println("두 수의 합은" + sum + "입니다.");
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
}
