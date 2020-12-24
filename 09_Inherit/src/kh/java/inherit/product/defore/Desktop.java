package kh.java.inherit.product.defore;

public class Desktop {
	private String brand;
	private String productName;
	private int price;
	
	private String os;
	
	private String monitor;
	private String keyboard;
	
	public Desktop() {
		
	}
	
	public Desktop(String brand, String productName, int price, String os, String monitor, String keyboard) {
		this.brand = brand;
		this.productName = productName;
		this.price = price;
		this.os = os;
		this.monitor = monitor;
		this.keyboard = keyboard;
	}

	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getMonitor() {
		return monitor;
	}
	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}
	public String getKeyboard() {
		return keyboard;
	}
	public void setKeyboard(String keyboard) {
		this.keyboard = keyboard;
	}	
	public String getDesktopInfo() {
		return brand + ", " + productName + ", " +price + ", " +
	os+ ", " + monitor + ", " + keyboard;
	}
}
