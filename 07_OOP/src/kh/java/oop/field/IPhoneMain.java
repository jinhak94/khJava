package kh.java.oop.field;

public class IPhoneMain {
	
	/**
	 * 클래스변수 IPhone.WIDTH : 프로그램시작시(해당 클래스 최초 사용시) ~ 프로그램 종료시 
	 * 인스턴스변수 owner: 객체생성시 ~ 객체소멸시 (가비지컬렉터에 의한 삭제) 
	 * 지역변수 sum : 메소드호출시 ~ 메소드종료시
	 */
	
	public static void main(String[] args) {
		IPhone hong = new IPhone();
		hong.setOwner("홍길동");
		hong.setPhoneNumber("01012341234");
		
		IPhone sin = new IPhone();
		sin.setOwner("신사임당");
		sin.setPhoneNumber("01043214321");
		
		System.out.printf("%s : %s%n", hong.getOwner(), hong.getPhoneNumber());
		System.out.printf("%s : %s%n", sin.getOwner(), sin.getPhoneNumber());
		
		//static
//		System.out.println(hong.width);
//		System.out.println(sin.width);
		System.out.println(IPhone.WIDTH);
		System.out.println(IPhone.HEIGHT);
		//IPhone.WIDTH = 13;//상수이므로 값변경 불가
		
		hong.heySiri(3,10);
		sin.heySiri(3, 5);
		
		//홍 아이폰 객체 삭제
		hong = null;
		
	
	}
}
