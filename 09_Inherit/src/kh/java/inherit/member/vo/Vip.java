package kh.java.inherit.member.vo;

public class Vip extends Member{
	public Vip() {
		super();
	}
	
	public Vip(String name, String grade, int point) {
		super(name, grade, point);
	}
	
	public double getInterestPoint() {
		return getPoint() * 0.1;
	}
}
