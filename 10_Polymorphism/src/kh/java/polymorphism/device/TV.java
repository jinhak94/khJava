package kh.java.polymorphism.device;

public class TV extends Device{
	private int channel;
	public TV() {
		
	}
	public TV(String brand, String deviceName, int price, int channel) {
		super(brand, deviceName, price);
		this.channel = channel;
	}
	public void channelUp() {
		channel++;
		System.out.println("채널을 올립니다. 현재 채널 : " + channel);
	}
	public void channelDown() {
		channel--;
		System.out.println("채널을 내립니다. 현재 채널 : " + channel);
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	public String toString() {
        return "brand : " + getBrand() + ", deviceName : " + getDeviceName()
        + ", price : " + getPrice() + ", channel : " + getChannel();
    }
	
}
