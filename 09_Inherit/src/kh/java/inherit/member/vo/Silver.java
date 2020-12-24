package kh.java.inherit.member.vo;

public class Silver extends Member{
	public Silver() {
		super();
	}
	
	public Silver(String name, String grade, int point) {
		super(name, grade, point);
	}
	
	public double getInterestPoint() {
		return getPoint() * 0.02;
	}
}
