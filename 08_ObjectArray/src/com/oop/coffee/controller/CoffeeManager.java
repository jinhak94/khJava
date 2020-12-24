package com.oop.coffee.controller;

import java.util.Scanner;

import com.oop.coffee.model.dto.Coffee;

public class CoffeeManager {
	public static final int MAX_COFFEE = 3;
	private Scanner sc = new Scanner(System.in);
	Coffee[] arr = new Coffee[MAX_COFFEE];
	private String str = "-----------------------------";
	
	public void printCoffee() {
		System.out.println("<세계3대커피>");
		System.out.println(str);
		System.out.println("원산지 \t\t 지역");
		System.out.println(str);
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].getOrigin()+"\t\t"
					+ arr[i].getLocation());
		}
		System.out.println(str);
	}
		
	public void inputCoffee() {
		String origin;
		String location;
		for(int i = 0; i < arr.length; i++) {
			System.out.print("원산지 : ");
			origin = sc.next();
			System.out.print("지역 : ");
			location = sc.next();
			arr[i] = new Coffee(origin, location);
		}
	}
}
