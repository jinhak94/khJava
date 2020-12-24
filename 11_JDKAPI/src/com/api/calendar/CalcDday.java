package com.api.calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CalcDday {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year;
		int month;
		int day;
		System.out.print("년도를 입력하세요! : ");
		year = sc.nextInt();
		System.out.print("월을 입력하세요! : ");
		month = sc.nextInt()-1;
		System.out.print("일을 입력하세요! : ");
		day = sc.nextInt();
		
		Calendar date = new GregorianCalendar(year, month, day);
		Calendar now = new GregorianCalendar();

		long future = date.getTimeInMillis();
		long past = now.getTimeInMillis();
		double diff = (future - past) / 1000.0 / 60 / 60 / 24;
		
		if(diff > 0) {
			System.out.println("d - " + ((int)diff + 1) + "일 남았습니다.");			
		}else if(diff > -1){
			System.out.println("d - day입니다.");
		}else {
			System.out.println(-(int)diff + "일 지났습니다.");
		}
	}
}
