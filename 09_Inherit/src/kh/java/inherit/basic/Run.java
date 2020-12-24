package kh.java.inherit.basic;

/**
 * 상속
 * 부모클래스의 멤버(필드, 메소드)를 자식클래스에서 가져다가 쓸 수 있는 것
 * 
 * 1. 부모멤버는 자식클래스에서 선언없이 사용 가능
 *   - 물려받은 메소드는 오버라이딩 가능
 * 2. 모든 클래스는 Object 클래스의 후손
 *   - Object의 모든 메소드를 후손클래스에서 사용 가능
 * 3. 상속관계는 UML에서 빈 화살표로 표시
 * 4. 부모클래스의 초기화블럭, 생성자는 상속되지 않는다.
 *   - 자식클래스 객체 생성시, super(); 키워드로 부모생성자를 먼저 자동 호출
 * 5. 부모클래스의 private 멤버는 상속은 되지만, 같은 클래스가 아니므로 접근 불가
 *   - public 메소드를 이용해 우회 접근.
 *   - 값 대입시에는 부모생성자 super를 이용해서 값 대입 가능
 *   - static 멤버는 상속되지 않음.
 */

public class Run {
	public static void main(String[] args) {
		Parent p = new Parent();
		p.name = "고길동";
		p.age = 30;
		p.say();
		p.printInfo();
		
		Child c = new Child();
		c.name = "둘리";
		c.age = 300;
		c.say();
		c.printInfo();
		c.doGame();
		
		Child2 c2 = new Child2();
		c2.name = "도우너";
		c2.age = 40;
		c2.say();
		c2.printInfo();
		
		GrandChild gc = new GrandChild();
		gc.name = "둘리 아들";
		gc.age = 3;
		gc.say();
		gc.printInfo();
		gc.doGame();
	}
}
