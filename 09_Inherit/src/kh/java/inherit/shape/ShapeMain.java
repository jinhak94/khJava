package kh.java.inherit.shape;

public class ShapeMain {
	public static void main(String[] args) {
		Circle c = new Circle();
		c.r = 10;
		c.center = new Point(100, 200);
		
		c.draw();
	}
}
