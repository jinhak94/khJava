package kh.java.polymorphism.device;

public class Device {
	private String brand;
	private String deviceName;
	private int price;
	
	public Device() {
		
	}
	public Device(String brand, String deviceName, int price) {
		this.brand = brand;
		this.deviceName = deviceName;
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String toString() {
        return "brand : " + getBrand() + ", deviceName : " + getDeviceName()
        + ", price : " + getPrice();
    }
}
