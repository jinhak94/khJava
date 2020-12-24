package kh.java.polymorphism.animal;

public class Lion extends Animal implements Barkable, Runnable{
	@Override
	public void say() {
		System.out.println("안녕하세요, 사자입니다.");
	}
	public void kick() {
		System.out.println("라이언 킥을 날립니다.");
	}
	
	@Override
	public void bark() {
		System.out.println("라이언이 크아악");
	}
	@Override
	public void run() {
		System.out.println("사자가 " + NUM_OF_LEGS + "다리로 빠르게 달립니다.");
	}
	
}
