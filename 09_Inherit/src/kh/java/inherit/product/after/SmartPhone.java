package kh.java.inherit.product.after;

public class SmartPhone extends Computer{
	
	private String carrier; // 통신사
	
	public SmartPhone() {
		
	}

	public SmartPhone(String brand, String productName, int price, String os, String carrier) {
		super(brand, productName, price, os);
		this.carrier = carrier;
	}



	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	
//	public String getSmartPhoneInfo() {
//		return super.getProductInfo()+ ", " + 
//	os + ", " + carrier;
//	}
	@Override
	public String getProductInfo() {
		return super.getProductInfo()+ ", " + carrier;
		
	}
}
