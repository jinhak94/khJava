package kh.java.inherit.member.vo;

public class Gold extends Member{
	public Gold() {
		super();
	}
	
	public Gold(String name, String grade, int point) {
		super(name, grade, point);
	}
	
	public double getInterestPoint() {
		return getPoint() * 0.05;
	}
}
