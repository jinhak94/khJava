package kh.java.inherit.basic;

public class Parent {
	String name;
	int age;
	public void say() {
		System.out.println("안녕하세요, 애비입니다.");
	}
	public void printInfo() {
		System.out.println("[" + name + ", " + age + "]");
	}
}
