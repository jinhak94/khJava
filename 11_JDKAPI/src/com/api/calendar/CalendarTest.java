package com.api.calendar;

import java.util.Calendar;

public class CalendarTest {
	public static void main(String[] args) {
		int year;
		int month;
		int day;
		int hour;
		int minute;
		int second;
		
		Calendar today = Calendar.getInstance();
		year = today.get(Calendar.YEAR);
		month = today.get(Calendar.MONTH)+1;
		day = today.get(Calendar.DATE);
		hour = today.get(Calendar.HOUR_OF_DAY);
		minute = today.get(Calendar.MINUTE);
		second = today.get(Calendar.SECOND);
		
		String[] arr = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
		String yoil = arr[today.get(Calendar.DAY_OF_WEEK)];
		
		System.out.printf("%d년 %d월 %d일 %s",
				year, month, day, yoil);
		
		
	}
	
	
}
