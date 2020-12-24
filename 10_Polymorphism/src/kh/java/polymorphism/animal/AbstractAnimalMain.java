package kh.java.polymorphism.animal;

/**
 * 부모클래스의 메소드 오버라이딩 강제화
 *  - 부모클래스 추상메소드(미완성메소드)
 *  
 *  추상메소드를 하나라도 가지고 있다면, 추상클래스가 됨.
 *  추상클래스는 객체화 할 수 없는 특징이 있음.
 *
 *  자식클래스마다 달라져야 하는 필수적인 기능이 있다면,
 *  추상메소드 사용을 권장한다.
 *	
 */

public class AbstractAnimalMain {
	public static void main(String[] args) {
		AbstractAnimalMain aam = new AbstractAnimalMain();
//		aam.test1();
//		aam.test2();
		aam.test3();
		
	}
	
	public void test3() {
		//System.out.println(Runnable.NUM_OF_LEGS);
		Runnable rTiger = new Tiger();
		//rTiger.run();
	
		Runnable rLion = new Lion();
		//rLion.run();
		
		Eagle e = new Eagle();
		e.say();
		e.fly();
	}
	
	
	/**
	 * 인터페이스
	 */
	public void test2() {
		// 인터페이스는 객체화 할 수 없다.
//		Barkable b = new Barkable();
		Barkable bLion = new Lion();
		bLion.bark();
		
		Barkable bTiger = new Tiger();
		bTiger.bark();
	
		Barkable[] arr = new Barkable[2];
		arr[0] = bLion;
		arr[1] = bTiger;
		
		for(Barkable b: arr) {
			b.bark();
		}
		
		//주의점
		((Lion)bLion).say();
		((Animal)bLion).say();
	}
	
	public void test1() {
		// 추상클래스는 객체화 할 수 없다.
		//Animal a = new Animal();
		
	}
}
