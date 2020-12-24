package kh.java.polymorphism.member.vo;

public class VVip extends Member{
	
	public VVip() {
		super();
	}
	
	public VVip(String name, String grade, int point) {
		super(name, grade, point);
	}
	
	public double getInterestPoint() {
		return getPoint() * 0.15;
	}
	@Override
	public int buy(int price) {
		return (int) (price - (price * 0.15));
	}
}
