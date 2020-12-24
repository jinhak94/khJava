package kh.java.oop.encapsulation;

public class Account {
	
	//필드 메소드의 접근제한자는 public protected default private
	//private 해당 클래스 안에서만 접근 가능
	private String name;
	private long balance;
	
	/**
	 * setter
	 * 필드값 대입 (리턴 타입은 void, 파라미터는 해당 필드의 타입과 동일)
	 */
	public void setName(String name) {
		//this는 현재객체를 가리키는 참조변수
		this.name = name;
	}
	
	public void setBanalce(long balance) {
		this.balance = balance;
	}
	
	/**
	 * getter
	 * 필드값 가져오기 (리턴 타입은 해당 필드의 타입과 동일)
	 */
	public String getName() {
		//return this.name; (this 생략 가능..)
		return name;
	}
	
	public long getBalance() {
		return balance;
	}
	
	/**
	 * 입금 메소드
	 */
	
	//public 모든 패키지 모든 클래스에서 접근 가능
	public void deposit(int money) {
		if(money > 0) {
			balance += money;
			System.out.printf("%s님 계좌에 %d 원 입금완료!%n", name, money); 
			System.out.printf("%s님 계좌 잔액은 %d 원 입니다.%n", name, balance); 
		}else {
			System.out.println("유효한 금액을 입력하세요.");
		}		
	}
	
	/**
	 * 출금 메소드
	 */
	public void withdraw(int money) {
		if(money > balance) {
			System.out.println("계좌 잔액보다 큰 값을 입력했습니다.");
		}else {
			System.out.printf("%s님 계좌에 %d 원 출금완료!%n", name, money);
			balance -= money;
			System.out.printf("%s님 계좌 잔액은 %d 원 입니다.%n", name, balance);
		}
	}
	
}








