package kh.java.inherit.product.after;

public class Computer extends Product{
	private String os;
	
	public Computer() {
		
	}
	public Computer(String brand, String productName, int price, String os) {
		super(brand, productName, price);
		this.os = os;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}
	
	@Override
	public String getProductInfo() {
		return super.getProductInfo()+ ", " + os;
		
	}
}
