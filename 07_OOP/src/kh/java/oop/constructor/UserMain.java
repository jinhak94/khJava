package kh.java.oop.constructor;

public class UserMain {

	public static void main(String[] args) {
		User u1 = new User(); //생성자 호출
		u1.printUserInfo();
		
		User u2 = new User("honggd");
		u2.printUserInfo();
		
		User u3 = new User("sinsa", "1234");
		u3.printUserInfo();
	}

}
