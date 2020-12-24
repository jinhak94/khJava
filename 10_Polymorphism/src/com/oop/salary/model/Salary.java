package com.oop.salary.model;

public class Salary extends Calculate implements Output{
	private String name;		//이름
	private long basePay;		//기본급
	private long familyPay;		//가족수당
	private long overtimePay;	//시간외수당
	private long incentivePay;	//성과금
	private long tax;			//세금
	private long totalPay;		//실수령액
	private int family;			//가족수
	private int overtime;		//초과근무시간
	
	public static int count = 0;
	
	public Salary() {
		calc();
		count++;
	}

	public Salary(String name, long basePay, int family, int overtime) {
		this.name = name;
		this.basePay = basePay;
		this.family = family;
		this.overtime = overtime;
		calc();
		count++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getBasePay() {
		return basePay;
	}

	public void setBasePay(long basePay) {
		this.basePay = basePay;
	}

	public long getFamilyPay() {
		return familyPay;
	}

	public void setFamilyPay(long familyPay) {
		this.familyPay = familyPay;
	}

	public long getOvertimePay() {
		return overtimePay;
	}

	public void setOvertimePay(long overtimePay) {
		this.overtimePay = overtimePay;
	}

	public long getIncentivePay() {
		return incentivePay;
	}

	public void setIncentivePay(long incentivePay) {
		this.incentivePay = incentivePay;
	}

	public long getTax() {
		return tax;
	}

	public void setTax(long tax) {
		this.tax = tax;
	}

	public long getTotalPay() {
		return totalPay;
	}

	public void setTotalPay(long totalPay) {
		this.totalPay = totalPay;
	}

	public int getFamily() {
		return family;
	}

	public void setFamily(int family) {
		this.family = family;
	}

	public int getOvertime() {
		return overtime;
	}

	public void setOvertime(int overtime) {
		this.overtime = overtime;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Salary.count = count;
	}
	//  1. 가족수당 : 가족이 3명 미만이면 가족수 *20000, 3명 이상이면 무조건 60000
    //	2. 시간외수당 : 시간외근무 * 5000
    //	3. 세금 : 기본급의 10%
    //	4. 성과금 : 인센티브 * 기본급
    //	5. 실수령액 : 기본급 + 가족수당 + 성과금 + 시간외수당 - 세금
	public void calc() {
		if(family<3) {
			familyPay = family * 20000;
		}else {
			familyPay = family * 60000;
		}
		overtimePay = overtime * 5000;
		tax = (long) (basePay * 0.1);
		incentivePay = (long) (incentive * basePay);
		totalPay = basePay + familyPay + incentivePay + overtimePay - tax;
	}
	
	public void output() {
		System.out.println(name+"\t"+basePay+"\t"+family+"\t"+familyPay
				+"\t"+overtime+"\t"+overtimePay+"\t"+tax+"\t"+incentive
				+"\t\t"+incentivePay+"\t"+totalPay);
	}
}
