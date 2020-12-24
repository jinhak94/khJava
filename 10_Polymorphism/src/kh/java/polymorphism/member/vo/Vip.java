package kh.java.polymorphism.member.vo;

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
	
	@Override
	public int buy(int price) {
		return (int) (price - (price * 0.1));
	}
}
