package kh.java.inherit.object.user;

public class UserMain {
	public static void main(String[] args) {
		UserMain um = new UserMain();
		//um.test1();
		um.test2();
		//um.test3();
	}
	
	public void test3() {
		User user = new User("sinsa", "1234");
		User copy = user.clone();
		
		System.out.println(user.toString());
		System.out.println(copy.toString());
		System.out.println(user.equals(copy));
		System.out.println(user.hashCode());
		System.out.println(copy.hashCode());
		// 주소값 비교
		System.out.println(user == copy);
	}
	
	/**
	 * equals()
	 * 객체간 동등비교 결과를 리턴
	 * 
	 * equals의 결과가 동일하다면, hashCode 호출 결과도 동일해야 한다.
	 */
	public void test2() {
		User u1 = new User("honggd", "1234");
		User u2 = new User("honggd", "1234");

		System.out.println(u1==u2);
		System.out.println(u1.equals(u2));
		
		System.out.println(u1.hashCode());
		System.out.println(u2.hashCode());
	}
	
	/**
	 * toString()
	 * 객체가 문자열로 표현되어야 할 때, 자동으로 호출되는 Object의 메소드
	 * 
	 */
	public void test1() {
		User u = new User("honggd", "1234");
		System.out.println(u);
		System.out.println(u.toString());
		//return getClass().getName() + "@" + Integer.toHexString(hashCode());
		System.out.println(u.getClass().getName());
	}
}
