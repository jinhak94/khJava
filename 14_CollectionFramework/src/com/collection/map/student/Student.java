package com.collection.map.student;

public class Student {
	private int sno;
	private String sname;
	private int kor, eng, math, sum;
	private double avg;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int sno, String sname, int kor, int eng, int math) {
		this.sno = sno;
		this.sname = sname;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		sum = kor + eng + math;
		avg = Math.round((sum/3.0)*100)/100.0;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getSum() {
		return sum;
	}
	public double getAvg() {
		return avg;
	}
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", kor=" + kor + ", eng=" + eng + ", math=" + math
				+ ", sum=" + sum + ", avg=" + avg + "]";
	}
	
	
}
