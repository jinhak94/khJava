package kh.java.inherit.shape;

/**
 * 
 * Circle - Point (연관관계) has a 포함관계) : Circle has a Point
 * Circle - Shape (상속, 일반화관계) is a 상속관계 : Circle is a Shape
 * 
 */

public class Circle extends Shape{
	Point center;	//중심점
	int r;			//반지름
	
	void draw() {
		
	}
}
