package kh.java.polymorphism.member.vo;

import kh.java.polymorphism.member.controller.Buyable;

public abstract class Member implements Buyable{
//	Buyable.buy 추상메소드는 Member가 추상클래스이므로 자식클래스에서 구현하도록 한다.
//	추상클래스에 한해서 buy()를 구현하는 것을 토스할 수 있다.
//	따라서 Member를 상속하는 첫 class에서 buy()를 구현하면 된다.
//	(Member는 구현 강제화가 적용되지 않는다.)
//	또한, 이렇게 하게 되면, MemberManager에서 Member 객체로 buy() 메소드에 접근이 가능하다.
	private String name;
	private String grade;
	private int point;
	
	public Member() {
		
	}
	
	public Member(String name, String grade, int point) {
		this.name = name;
		this.grade = grade;
		this.point = point;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	public abstract double getInterestPoint();
}
