package kh.java.polymorphism.animal;

/**
 * 
 * 인터페이스는 다중구현이 가능하다.
 *
 */

public class Tiger extends Animal implements Barkable, Runnable {
	@Override
	public void say() {
		System.out.println("안녕하세요, 호랑이입니다.");
	}
	public void punch() {
		System.out.println("호랑이 펀치를 날립니다.");
	}
	@Override
	public void bark() {
		System.out.println("타이거가 야옹");
	}
	@Override
	public void run() {
		System.out.println("호랑이가 " + NUM_OF_LEGS + "다리로 빠르게 달립니다.");
	}
}
