package kh.java.polymorphism.member.controller;

import kh.java.polymorphism.member.vo.Member;

/**
 * 
 * 다형성이란?
 * 부모타입의 참조변수에 자식객체를 담아 제어하는 것
 * Silver s = new Silver();
 * Member m = s;
 * Object o = s;
 * 
 * Member[] marr = new Member[10];
 * 
 * 1. 변수에 대입, 배열에 대입
 * 2. 매개변수
 * 3. 리턴값
 *
 */

public class MemberManager{
	public static final int MAX_PEOPLE = 40;
//	private Gold[] gArr = new Gold[MAX_PEOPLE];
//	private Silver[] sArr = new Silver[MAX_PEOPLE];
//	private Vip[] vArr = new Vip[MAX_PEOPLE];
//	private VVip[] vvArr = new VVip[MAX_PEOPLE];
//	int gIdx = 0;
//	int sIdx = 0;
//	int vIdx = 0;
//	int vvIdx = 0;
	private Member[] mArr = new Member[MAX_PEOPLE];
	int mIdx = 0;
	
//	public void goldInsert(Gold g) {
//		this.gArr[gIdx] = g;
//		gIdx++;
//	}
//	
//	public void silverInsert(Silver s) {
//		this.sArr[sIdx] = s;
//		sIdx++;
//	}
//
//	public void vipInsert(Vip v) {
//		this.vArr[vIdx] = v;
//		vIdx++;
//	}
//
//	public void vvipInsert(VVip vv) {
//		this.vvArr[vvIdx] = vv;
//		vvIdx++;
//	}

	public void insertMember(Member m) {
		this.mArr[mIdx++] = m;
	}
	
	public void printData() {
		System.out.println("------------------------<<"
		     		+ "회원정보>>------------------------");
		System.out.println("이름\t\t등급\t\t포인트\t\t이자포인트");
		System.out.println("---------------------------"
					+ "-------------------------------");
//		for(int i = 0; i < sIdx; i++) {
//			System.out.printf("%s\t\t%s\t\t%d\t\t%.2f%n",
//					sArr[i].getName(),sArr[i].getGrade(),
//					sArr[i].getPoint(),sArr[i].getInterestPoint());
//		}
//		for(int i = 0; i < gIdx; i++) {
//			System.out.printf("%s\t\t%s\t\t%d\t\t%.2f%n",
//					gArr[i].getName(),gArr[i].getGrade(),
//					gArr[i].getPoint(),gArr[i].getInterestPoint());
//		}
//		for(int i = 0; i < vIdx; i++) {
//			System.out.printf("%s\t\t%s\t\t%d\t\t%.2f%n",
//					vArr[i].getName(),vArr[i].getGrade(),
//					vArr[i].getPoint(),vArr[i].getInterestPoint());
//		}
//		for(int i = 0; i < vvIdx; i++) {
//			System.out.printf("%s\t\t%s\t\t%d\t\t%.2f%n",
//					vvArr[i].getName(),vvArr[i].getGrade(),
//					vvArr[i].getPoint(),vvArr[i].getInterestPoint());
//		}
		for(int i = 0; i < mIdx; i++) {
			System.out.printf("%s\t\t%s\t\t%d\t\t%.2f%n",
					mArr[i].getName(),mArr[i].getGrade(),
					mArr[i].getPoint(),mArr[i].getInterestPoint());
		}
	}

	public void printBuyInfo(int price) {
		System.out.println("=======================================");
		for(int i = 0; i < mIdx; i++) {
			System.out.printf("%s등급회원 %s는 %d원 상품을 %d원에 구매합니다.%n",
					mArr[i].getGrade(), mArr[i].getName(),
					//Member가 직접 Buyable을 구현하므로, buy메소드 접근 가능.
					price, (int)mArr[i].buy(price));
		}
	}
	
	/**
	 * public void printBuyInfo(int price){
	 * 	for(Member m : this.m){
	 * 		is(m == null)
	 * 			break;
	 * 		System.out.printf(
	 * 			"%s등급회원 %s는 %d원 상품을 %d원에 구매합니다.%n",
	 * 			m.getGrade(),
	 * 			m.getName(),
	 * 			price,
	 * 			m.buy()
	 * 		);
	 * 	}
	 * }
	 */
	
}
