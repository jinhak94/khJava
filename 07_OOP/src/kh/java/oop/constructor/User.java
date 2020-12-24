package kh.java.oop.constructor;


/**
 * 생성자
 * - new연산자를 통해 호출되는 메소드로써, 
 * - 객체 필드 초기화등을 수행한다.
 * 
 * - 리턴타입을 작성하지 않는다.
 * - 클래스명과 생성자명은 동일하다.
 *
 * - 기본생성자(파라미터가 없음)와 하나이상의 파라미터생성자를 가질 수 있다.
 * - 파라미터생성자를 작성하지 않았다면, JVM이 자동으로 기본생성자를 생성해 처리하지만,
 * - 파라미터생성자를 작성했다면, JVM이 기본생성자를 자동생성하지 않는다.
 * 
 */
public class User {

	private String userId;
	private String password;
	private boolean enable; 
	//setEnable
	//isEnable : 필드의 자료형이 boolean인 경우에만, getter는 is로 시작한다.
	
	//생성자
	//1. 기본생성자
	// 기본생성자를 호출하지 않아도, 무조건 작성해둘것.
	public User() {
		System.out.println("User() 기본생성자 호출!");
	}
	
	//2. 파라미터생성자
	public User(String userId) {
		//다른 생성자 호출
		//최상단에서 딱한번 호출할 수 있다. 
		this(userId, "0000");
//		this.userId = userId;
//		this.password = "0000";
	}
	
	public User(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}
	
	
	public void printUserInfo() {
		System.out.println("userId = " + userId + ", password = " + password);
	}
	
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
	
	
	
	
}
