package com.oop.person.model.vo;

public class Person {
	private String name;
	private int age;
	private double height;
	private int weight;
	private int property;
	
	public Person() {
		
	}
	
	public Person(String name, int age, double height, int weight, int property) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.property = property;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getProperty() {
		return property;
	}

	public void setProperty(int property) {
		this.property = property;
	}
	
	public String information() {
		return "[ 이름 : "+name+", 나이 : "+age+", 키 : "+height
				+"몸무게 : "+weight+"재산 : "+property+" ]";
	}
}
