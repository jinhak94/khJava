package kh.java.polymorphism.animal;

/**
 * 일반필드 메소드 없이 상수, 추상메소드만 가질 수 있다.
 * 
 *
 */

public interface Barkable {

//	public abstract void bark();
	// 인터페이스는 무조건 추상 메소드이므로, 아래와 같이 써도 자동으로 public abstract가 붙는다.
	void bark();
}
