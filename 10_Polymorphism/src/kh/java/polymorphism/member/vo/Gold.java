package kh.java.polymorphism.member.vo;

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
	
	@Override
	public int buy(int price) {
		return (int) (price - (price * 0.05));
	}

}
