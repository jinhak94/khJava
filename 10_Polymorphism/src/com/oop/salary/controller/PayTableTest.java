package com.oop.salary.controller;

import com.oop.salary.model.Calculate;
import com.oop.salary.model.PayTable;
import com.oop.salary.model.Salary;

public class PayTableTest {
	public static void main(String[] args) {
	    PayTable pt  = new PayTable();
	    pt.insertSalaryData(new Salary("소서노",750000,2,3));
	    pt.insertSalaryData(new Salary("고주몽",800000,1,4));
	    pt.insertSalaryData(new Salary("모팔모",650000,6,2));
	    pt.output();
	    
	    System.out.println("\n\n");
	    Calculate.incentive = 0.7f;
	    pt.output();
	}
}
