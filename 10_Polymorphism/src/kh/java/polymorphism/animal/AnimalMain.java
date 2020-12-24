package kh.java.polymorphism.animal;

public class AnimalMain {
	public static void main(String[] args) {
		AnimalMain am = new AnimalMain();
//		am.test1();
//		am.test2();
//		am.test3();
		am.test4();
	}
	
	/**
	 * 다형성과 오버라이딩
	 * 
	 * 동적바인딩
	 * 	- 컴파일시 정적바인딩된 메소드를 실행하면
	 *    실제 객체타입기준으로 메소드를 동적으로 실행하는 것.
	 */
	
	public void test4() {
		//정적 바인딩
//		Tiger tiger = new Tiger();
//		tiger.say();
		
		// 동적 바인딩 : 다형성이 적용되어 있고, 오버라이드 된 메소드라면
		// 고정된 것이 아니라, 변경되어서 자식의 오버라이드 된 메소드가 호출된다.
//		Animal animal = tiger;
//		animal.say();
		
		Animal[] arr = new Animal[10];
		for(int i = 0; i < arr.length; i++) {
			if(i%2 == 0)
				arr[i] = getTiger();
			else
				arr[i] = getLion();
		}
		for(Animal a : arr) {
			a.say();
		}
		
		
	}
	
	/**
	 * 1. 부모타입 변수에 담기
	 * 2. 매개변수의 사용
	 * 3. 리턴값
	 */
	public void test3() {
		//1. 부모타입 변수, 부모타입 배열
		Animal[] arr = new Animal[3];
		arr[0] = new Tiger();
		arr[1] = new Lion();
		arr[2] = new Tiger();
		
		//forEach 반복문 (향상된 for문)
		for(Animal a:arr) {
			//System.out.println(a);
			//적절치 않은 타입으로 형변환시
			//((Lion)a).kick(); -> ClassCastException
			if(a instanceof Tiger) {
				//Tiger 타입 객체가 맞는지 확인
				((Tiger)a).punch();
			}else if(a instanceof Lion) {
				((Lion)a).kick();
			}
		}
		
		//2. 매개변수
		Tiger tiger = new Tiger();
		Lion lion = new Lion();
		attack(tiger);
		attack(lion);
		
		//3. 리턴값 처리하기
//		Tiger t = getTiger();
//		Lion l = getLion();
		Animal a1 = getTiger();
		Animal a2 = getLion();
	}
	
	public Tiger getTiger() {
		return new Tiger();
	}
	public Lion getLion() {
		return new Lion();
	}
	
//	public void attack(Tiger t) {}
//	public void attack(Lion l) {}
	public void attack(Animal a) {
		System.out.println("a");
	}
	
	public void attack(Tiger t) {
		System.out.println("t");
	}
	public void attack(Lion l ) {
		System.out.println("l");
	}
	
	public void test2() {
		Tiger tiger = new Tiger();
		Animal animal = tiger;
		Object obj = tiger;
	}
	
	public void test1() {
		Tiger tiger = new Tiger();
		Lion lion = new Lion();
		
		//부모타입참조변수 <- 자식타입객체
		//암묵적형변환 : upCasting
		Animal a1 = new Tiger();
		Animal a2 = new Lion();
	
		tiger.say();
		tiger.punch();
		
		a1.say();
		// a1.punch();
		// 자식객체를 부모타입 참조변수에 담으면 
		// 자식클래스에서 선언된 코드는 사용될 수 없다.
		
		lion.say();
		lion.kick();
		
		a2.say();
		// a2.kick();
		// 자식객체를 부모타입 참조변수에 담으면 
		// 자식클래스에서 선언된 코드는 사용될 수 없다.
		
		System.out.println("-----------------");
		
		//자식타입으로 다시 형변환하면 사용 가능하다.
		//부모타입  -> 자식타입 : 명시적 형변환 할 것 :Downcasting
		Tiger a1Tiger = (Tiger)a1;
		Lion a2Lion = (Lion)a2;
		a1Tiger.punch();
		a2Lion.kick();
	
		//힙영역의 동일한 객체를 가리킨다.
		System.out.println(a1 == a1Tiger);
		System.out.println(a2 == a2Lion);
	}
}
