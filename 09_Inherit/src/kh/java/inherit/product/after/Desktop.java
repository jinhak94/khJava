package kh.java.inherit.product.after;

public class Desktop extends Computer{
	
	private String monitor;
	private String keyboard;
	
	public Desktop() {
		
	}
	
	public Desktop(String brand, String productName, int price,
			String os, String monitor, String keyboard) {
		//this.brand = brand;
		//this.productName = productName;
		//this.price = price;
		//부모 클래스의 private 멤버는 상속은 되지만,
		//같은 클래스가 아니므로 접근 불가
		//public 메소드를 이용해 우회 접근, 값 대입시에 부모생성자 super를 이용해 처리 나으
		
		//2. super 부모생성자를 이용한 값대입
		//생성자가 상속이 됐으면 this(brand, productName, price);
		//와 같은 방식으로 하는 것이 가능했을 것임.
		super(brand, productName, price, os);
		
		//1. public 메소드를 통해 우회 접근
//		setBrand(brand);
//		setProductName(productName);
//		setPrice(price);
		
		this.monitor = monitor;
		this.keyboard = keyboard;
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
	
//	public String getDesktopInfo() {
//		return getBrand() + ", " + getProductName() + ", " + getPrice() + ","
//				+ os+", " + monitor + ", " + keyboard;
//	}
	/**
	 * 오버라이드 하는 것을 명시적으로 표시
	 * 부모메소드의 시그니쳐와 다른 경우 컴파일 오류를 유발함
	 */
	@Override
	public String getProductInfo() {
		//부모클래스 Product의 getProductInfo 호출
		//super 안 붙이면 재귀오류 발생
		return super.getProductInfo() + ","
				 + monitor + ", " + keyboard;
	}
}
