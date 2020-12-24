package kh.java.inherit.product.after;

public class Television extends Product{
	
	private int size;

	public Television() {
		
	}

	public Television(String brand, String productName, int price, int size) {
		super(brand, productName, price);
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	@Override
	public String getProductInfo() {
		return super.getProductInfo() + ", " + size;
	}
}
