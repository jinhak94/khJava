package com.oop.salary.model;

public class PayTable implements Output{

	private Salary[] salArr = new Salary[10];
	private int idx = 0;
	private String str = "-------------------------------------------------"
			+ "---------------------------------------------";
	
	public void insertSalaryData(Salary s) {
		salArr[idx++] = s;
	}
	
	@Override
	public void output() {
		// TODO Auto-generated method stub
		System.out.println("\t\t\t\t    **** 급여명세서 ****");
		System.out.println(str);
		System.out.println("이름\t기본급\t가족수\t가족수당\t"
				+ "시간외근무\t시간외수당\t세금\t인센티브(%)"
				+ "\t성과금\t실수령액");
		System.out.println(str);
		
		for(int i = 0; i < idx; i++) {
			salArr[i].calc();
			salArr[i].output();
		}
		System.out.println(str);
		System.out.println("인원수 : " + Salary.getCount() + "명");
		System.out.println(str);
	}
}
