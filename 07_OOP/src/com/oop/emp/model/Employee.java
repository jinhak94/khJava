package com.oop.emp.model;

import java.util.Scanner;

public class Employee {
	private int empNo;
	private String empName;
	private String dept;
	private String job;
	private int age;
	private char gender;
	private int salary;
	private double bonusPoint;
	private String phone;
	private String address;
	
	public void empInput() {
		Scanner sc = new Scanner(System.in);

		System.out.print("사원번호 : ");
		empNo =	sc.nextInt();
		//setEmpNo(empNo);
		
		System.out.print("이름 : ");
		empName =	sc.next();
		//setEmpName(empName);
		
		System.out.print("소속부서 : ");
		dept =	sc.next();
		//setDept(dept);
		
		System.out.print("직급 : ");
		job =	sc.next();
		//setJob(job);
		
		System.out.print("나이 : ");
		age =	sc.nextInt();
		//setAge(age);
		
		System.out.print("성별 : ");
		gender = sc.next().charAt(0);
		//setEmpNo(gender);
		
		System.out.print("급여 : ");
		salary =	sc.nextInt();
		//setSalary(salary);
		
		System.out.print("보너스포인트 : ");
		bonusPoint = sc.nextDouble();
		//setBonusPoint(bonusPoint);
		
		System.out.print("핸드폰 : ");
		phone =	sc.next();
		//setPhone(phone);
		
		sc.nextLine();
		System.out.print("주소 : ");
		address =	sc.nextLine();
		//setAddress(address);
		
		
	}
	
	public void empOutput() {
		System.out.println("사번 : " + empNo);
		System.out.println("이름 : " + empName);
		System.out.println("소속부서 : " + dept);
		System.out.println("직급 : " + job);
		System.out.println("나이 : " + age);
		System.out.println("성별 : " + gender);
		System.out.println("급여 : " + salary);
		System.out.println("보너스포인트 : " + bonusPoint);
		System.out.println("핸드폰 : " + phone);
		System.out.println("주소 : " + address);
	}
	
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public void setBonusPoint(double bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getEmpNo() {
		return empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public String getDept() {
		return dept;
	}
	public String getJob() {
		return job;
	}
	public int getAge() {
		return age;
	}
	public char getGender() {
		return gender;
	}
	public int getSalary() {
		return salary;
	}
	public double getBonusPoint() {
		return bonusPoint;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	
}
