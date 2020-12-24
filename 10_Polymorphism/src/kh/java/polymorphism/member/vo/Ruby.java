package kh.java.polymorphism.member.vo;

public class Ruby extends Member{
	public Ruby() {
		super();
	}
	
	public Ruby(String name, String grade, int point) {
		super(name, grade, point);
	}
	
	public double getInterestPoint() {
		return getPoint() * 0.3;
	}
	
	@Override
	public int buy(int price) {
		return (int) (price - (price * 0.3));
	}
}
