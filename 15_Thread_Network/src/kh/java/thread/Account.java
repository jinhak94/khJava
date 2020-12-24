package kh.java.thread;

public class Account {
	private int balance;
	
	public Account(int balance){
		this.balance = balance;
	}
	
	public int getBalance() {
		return balance;
	}
	/**
	 * 1. synchronized 메소드안에 사용된 모든 객체나 변수가 임계 영역으로 설정
	 * 2. synchronized block을 이용하여 일정 부분만 임계 영역으로 설정
	 */
	//1. public synchronized void withdraw(int money) {
	public void withdraw(int money) {
		
		String name = Thread.currentThread().getName();
		System.out.println(name + " >> 현재잔액 : " + balance + "원");
		//this는 현재 객체
		synchronized(this) {
			if(money>balance) {
				//잔액부족
				System.out.println(name + "잔액이 부족합니다.");
			}else {
				//출금 가능
				balance -= money;
				System.out.println(name + ">> 출금 : " + money + "원, 잔액 : " + balance + "원");
			}
		}
	}
}
