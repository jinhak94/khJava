package kh.java.oop.encapsulation;

public class AccountMain {
	public static void main(String[] args) {
		// 계좌 객체
		Account acc = new Account();
		acc.setName("홍길동");
		acc.setBanalce(1_000_000);
		
		// 입금
//		acc.balance += 500_000;	//직접 접근
//		System.out.printf("%s 님의 계좌 잔액은 %d 원입니다.%n",acc.getName(), acc.getBalance());
		acc.deposit(500_000);;
		// 출금
//		acc.balance -= 7000_000;
//		System.out.printf("%s 님의 계좌 잔액은 %d 원입니다.%n",acc.getName(), acc.acc.getBalance());
		acc.withdraw(700_000);
		acc.withdraw(1_700_000);
		
		System.out.printf("%s 님의 계좌 잔액은 %d원입니다.%n", acc.getName(), acc.getBalance());
	}
}
