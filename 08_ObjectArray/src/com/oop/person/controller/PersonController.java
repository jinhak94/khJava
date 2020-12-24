package com.oop.person.controller;

import java.util.Scanner;

import com.oop.person.model.vo.Person;

public class PersonController {
	final int MAX_PERSON = 5;
	private Person[] arr = new Person[MAX_PERSON];
	private Scanner sc = new Scanner(System.in);
	
	public void insertPerson() {
		String name;
		int age;
		double height;
		int weight;
		int property;
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print((i+1)+". 이름을 입력하세요 : ");
			name = sc.next();
			
			System.out.print((i+1)+". 나이를 입력하세요 : ");
			age = sc.nextInt();

			System.out.print((i+1)+". 키를 입력하세요 : ");
			height = sc.nextDouble();
			
			System.out.print((i+1)+". 몸무게를 입력하세요 : ");
			weight = sc.nextInt();
			
			System.out.print((i+1)+". 재산을 입력하세요 : ");
			property= sc.nextInt();
		
			arr[i] = new Person(name, age, height, weight, property);
		}
	}
	
	public void printPerson() {
		for(int i = 0; i < arr.length; i++) {
			System.out.println((i+1)+". 이름 : "+arr[i].getName()
					+", 나이 : "+arr[i].getAge()+ ", 키  : "+arr[i].getHeight()
					+", 몸무게 : "+arr[i].getWeight()+", 재산 : "+arr[i].getProperty());
		}
	}
	
	public void getPersonAvg() {
		double avgAge = 0;
		double avgHgt = 0;
		double avgWgt = 0;
		double avgPpt = 0;
		
		for(int i = 0; i < arr.length; i++) {
			avgAge += arr[i].getAge();
			avgHgt += arr[i].getHeight();
			avgWgt += arr[i].getWeight();
			avgPpt += arr[i].getProperty();
		}
		avgAge /= MAX_PERSON; avgHgt /= MAX_PERSON; 
		avgWgt /= MAX_PERSON; avgPpt /= MAX_PERSON;
		
		System.out.printf("평균나이 : %.0f, 평균키 : %.1f, "
				+ "평균몸무게 : %.1f, 평균재산 : %.0f",
				avgAge, avgHgt, avgWgt, avgPpt);
	}
}
