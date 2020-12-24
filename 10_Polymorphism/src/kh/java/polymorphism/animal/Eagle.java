package kh.java.polymorphism.animal;

public class Eagle extends Animal implements Flyable{
	public void say() {
		System.out.println("안녕하세요, 이글이글입니다.");
	}
	
	public void fly() {
		System.out.println("독수리가 " + NUM_OF_WINGS + "날개로 "
				+ "시속128km로 납니다.");
	}
}
