package kh.java.polymorphism.member.vo;

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
	
	@Override
	public int buy(int price) {
		return (int) (price - (price * 0.02));
	}

}
